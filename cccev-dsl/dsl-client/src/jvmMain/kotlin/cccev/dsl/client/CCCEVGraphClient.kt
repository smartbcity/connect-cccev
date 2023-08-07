package cccev.dsl.client

import cccev.dsl.model.DataUnitDTO
import cccev.dsl.model.EvidenceTypeBase
import cccev.dsl.model.EvidenceTypeListBase
import cccev.dsl.model.InformationConcept
import cccev.dsl.model.ReferenceFramework
import cccev.dsl.model.Requirement
import cccev.f2.concept.client.InformationConceptClient
import cccev.f2.concept.client.informationConceptClient
import cccev.f2.evidence.type.client.EvidenceTypeClient
import cccev.f2.evidence.type.client.evidenceTypeClient
import cccev.f2.framework.client.FrameworkClient
import cccev.f2.framework.client.frameworkClient
import cccev.f2.certification.client.CertificationClient
import cccev.f2.certification.client.certificationClient
import cccev.f2.concept.domain.query.InformationConceptGetByIdentifierQueryDTOBase
import cccev.f2.evidence.type.domain.query.EvidenceTypeGetByIdentifierQueryDTOBase
import cccev.f2.evidence.type.domain.query.EvidenceTypeListGetByIdentifierQueryDTOBase
import cccev.f2.framework.domain.query.FrameworkGetByIdentifierQueryDTOBase
import cccev.f2.requirement.domain.command.RequirementCreateCommandDTOBase
import cccev.f2.requirement.domain.model.RequirementDTOBase
import cccev.f2.requirement.domain.query.RequirementGetByIdentifierQueryDTO
import cccev.f2.requirement.domain.query.RequirementGetByIdentifierQueryDTOBase
import cccev.f2.unit.client.DataUnitClient
import cccev.f2.unit.client.dataUnitClient
import cccev.f2.unit.domain.command.DataUnitCreateCommandDTOBase
import cccev.f2.unit.domain.query.DataUnitGetByIdentifierQueryDTOBase
import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.concept.domain.command.InformationConceptCreateCommand
import cccev.s2.concept.domain.command.InformationConceptCreatedEvent
import cccev.s2.evidence.type.domain.EvidenceTypeId
import cccev.s2.evidence.type.domain.EvidenceTypeListId
import cccev.s2.evidence.type.domain.command.list.EvidenceTypeListCreateCommand
import cccev.s2.evidence.type.domain.command.list.EvidenceTypeListCreatedEvent
import cccev.s2.evidence.type.domain.command.type.EvidenceTypeCreateCommand
import cccev.s2.evidence.type.domain.command.type.EvidenceTypeCreatedEvent
import cccev.s2.framework.domain.FrameworkId
import cccev.s2.framework.domain.command.FrameworkCreateCommand
import cccev.s2.framework.domain.command.FrameworkCreatedEvent
import cccev.s2.requirement.client.RequirementClient
import cccev.s2.requirement.client.requirementClient
import cccev.s2.requirement.domain.RequirementId
import cccev.s2.requirement.domain.command.RequirementAddRequirementsCommand
import cccev.s2.requirement.domain.command.RequirementCreatedEvent
import cccev.s2.requirement.domain.model.RequirementIdentifier
import cccev.s2.requirement.domain.model.RequirementKind
import cccev.s2.unit.domain.DataUnitId
import cccev.s2.unit.domain.command.DataUnitCreatedEvent
import f2.client.ktor.F2ClientBuilder
import f2.client.ktor.get
import f2.client.ktor.http.F2ClientConfigLambda
import f2.dsl.fnc.invokeWith
import java.util.UUID
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.json.Json

class CCCEVGraphClient(
    val evidenceTypeClient: EvidenceTypeClient,
    val informationConceptClient: InformationConceptClient,
    val certificationClient: CertificationClient,
    val requirementClient: RequirementClient,
    val dataUnitClient: DataUnitClient,
    val frameworkClient: FrameworkClient,
) {

    @Suppress("ComplexMethod", "LongMethod")
    suspend fun create(requirements: Flow<Requirement>): Flow<RequirementDTOBase> {
        val visitedRequirementIdentifiers = mutableSetOf<RequirementIdentifier>()
        val createdFrameworks = mutableMapOf<String, FrameworkId>()
        val createdUnits = mutableMapOf<String, DataUnitId>()
        val createdConcepts = mutableMapOf<String, InformationConceptId>()
        val createdEvidenceTypes = mutableMapOf<String, EvidenceTypeId>()
        val createdEvidenceTypeLists = mutableMapOf<String, EvidenceTypeListId>()
        val createdRequirements = mutableMapOf<RequirementIdentifier, RequirementId>()


        fun Requirement.flatten(): Flow<Requirement> = flow {
            if (identifier in visitedRequirementIdentifiers) {
                return@flow
            }
            visitedRequirementIdentifiers += identifier!!

            hasRequirement?.forEach { emitAll(it.flatten()) }
            isRequirementOf?.forEach { emitAll(it.flatten()) }
            hasQualifiedRelation?.values?.flatten()?.forEach { emitAll(it.flatten()) }
            emit(this@flatten)
        }

        return requirements.flatMapConcat(Requirement::flatten)
            .map { requirement ->
                requirement.isDerivedFrom?.forEach { framework ->
                    if (framework.identifier !in createdFrameworks) {
                        val frameworkId = framework.getOrCreate()
                        createdFrameworks[framework.identifier] = frameworkId
                    }
                }

                requirement.hasConcept?.forEach { concept ->
                    initConcept(concept, createdUnits, createdConcepts)
                }

                requirement.hasEvidenceTypeList?.forEach { etl ->
                    initEvidenceTypeList(etl, createdEvidenceTypeLists, createdEvidenceTypes)
                }

                val requirementIdentifier = initRequirement(
                    requirement,
                    createdFrameworks,
                    createdConcepts,
                    createdEvidenceTypeLists,
                    createdRequirements
                )

                requirementIdentifier
            }
    }

    private suspend fun initRequirement(
        requirement: Requirement,
        createdFrameworks: MutableMap<String, FrameworkId>,
        createdConcepts: MutableMap<String, InformationConceptId>,
        createdEvidenceTypeLists: MutableMap<String, EvidenceTypeListId>,
        createdRequirements: MutableMap<RequirementIdentifier, RequirementId>
    ): RequirementDTOBase {
        val identifier = requirement.identifier ?: UUID.randomUUID().toString()
        val existingRequirement = RequirementGetByIdentifierQueryDTOBase(
            identifier = identifier
        ).invokeWith(requirementClient.requirementGetByIdentifier()).item
        if(existingRequirement != null) {
            return existingRequirement
        }

        val requirementId = createRequirement(
            requirement,
            createdFrameworks,
            createdConcepts,
            createdEvidenceTypeLists,
            createdRequirements
        )

        createdRequirements[requirement.identifier!!] = requirementId

        requirement.isRequirementOf?.forEach { parent ->
            RequirementAddRequirementsCommand(
                id = createdRequirements[parent.identifier]!!,
                requirementIds = listOf(requirementId)
            ).invokeWith(requirementClient.requirementAddRequirements())
        }
        return RequirementGetByIdentifierQueryDTOBase(
            identifier = identifier
        ).invokeWith(requirementClient.requirementGetByIdentifier()).item!!
    }

    private suspend fun createRequirement(
        requirement: Requirement,
        createdFrameworks: MutableMap<String, FrameworkId>,
        createdConcepts: MutableMap<String, InformationConceptId>,
        createdEvidenceTypeLists: MutableMap<String, EvidenceTypeListId>,
        createdRequirements: MutableMap<RequirementIdentifier, RequirementId>
    ): RequirementId {
        return RequirementCreateCommandDTOBase(
            identifier = requirement.identifier,
            name = requirement.name,
            description = requirement.description,
            isDerivedFrom = requirement.isDerivedFrom?.map { createdFrameworks[it.identifier]!! }.orEmpty(),
            hasConcept = requirement.hasConcept?.map { createdConcepts[it.identifier]!! }.orEmpty(),
            hasEvidenceTypeList = requirement.hasEvidenceTypeList?.map { createdEvidenceTypeLists[it.identifier]!! }
                .orEmpty(),
            hasRequirement = requirement.hasRequirement?.map { createdRequirements[it.identifier]!! }.orEmpty(),
            hasQualifiedRelation = requirement.hasQualifiedRelation?.mapValues { (_, requirements) ->
                requirements.map { createdRequirements[it.identifier]!! }
            }.orEmpty(),
            kind = RequirementKind.INFORMATION.name,
            type = requirement.type?.let { it::class.simpleName }
        ).invokeWith(requirementClient.requirementCreate()).id
    }

    private suspend fun initEvidenceTypeList(
        etl: EvidenceTypeListBase,
        createdEvidenceTypeLists: MutableMap<String, EvidenceTypeListId>,
        createdEvidenceTypes: MutableMap<String, EvidenceTypeId>
    ) {
        if (etl.identifier !in createdEvidenceTypeLists) {

            etl.specifiesEvidenceType.forEach { et ->
                if (et.identifier !in createdEvidenceTypes) {
                    val evidenceTypeId = et.getOrCreate()
                    createdEvidenceTypes[et.identifier] = evidenceTypeId
                }
            }

            val evidenceTypeListId = etl.getOrCreate(createdEvidenceTypes)
            createdEvidenceTypeLists[etl.identifier] = evidenceTypeListId
        }
    }

    private suspend fun initConcept(
        concept: InformationConcept,
        createdUnits: MutableMap<String, DataUnitId>,
        createdConcepts: MutableMap<String, InformationConceptId>
    ) {
        val unit = concept.unit
        if (unit != null && unit.identifier !in createdUnits) {
            val unitId = unit.getOrCreate()
            createdUnits[unit.identifier] = unitId
        }
        if (concept.identifier !in createdConcepts) {
            val conceptId = concept.getOrCreate(createdConcepts, createdUnits)
            createdConcepts[concept.identifier] = conceptId
        }
    }

    private suspend fun ReferenceFramework.getOrCreate(): FrameworkId {
        return FrameworkGetByIdentifierQueryDTOBase(
            identifier = identifier
        ).invokeWith(frameworkClient.frameworkGetByIdentifier()).item?.id
            ?: FrameworkCreateCommand(
            identifier = identifier,
            name = name
        ).invokeWith(frameworkClient.frameworkCreate()).id
    }

    private suspend fun DataUnitDTO.getOrCreate(): DataUnitId {
        return DataUnitGetByIdentifierQueryDTOBase(
            identifier = identifier
        ).invokeWith(dataUnitClient.dataUnitGetByIdentifier()).item?.id
            ?:  DataUnitCreateCommandDTOBase(
            name = name,
            identifier = identifier,
            description = description,
            notation = notation,
            type = type.name.uppercase()
        ).invokeWith(dataUnitClient.dataUnitCreate()).id
    }
    private suspend fun InformationConcept.getOrCreate(
        conceptIdMap: Map<String, InformationConceptId>,
        unitIdMap: Map<String, DataUnitId>
    ): InformationConceptId {
        return InformationConceptGetByIdentifierQueryDTOBase(
            identifier = identifier
        ).invokeWith(informationConceptClient.conceptGetByIdentifier()).item?.id
            ?: InformationConceptCreateCommand(
            name = name,
            identifier = identifier,
            hasUnit = unitIdMap[unit?.identifier],
            description = description,
            expressionOfExpectedValue = expressionOfExpectedValue,
            dependsOn = dependsOn?.map { conceptIdMap[it]!! },
        ).invokeWith(informationConceptClient.conceptCreate()).id
    }

    private suspend fun EvidenceTypeBase.getOrCreate(): EvidenceTypeId {
        return EvidenceTypeGetByIdentifierQueryDTOBase(
            identifier = identifier
        ).invokeWith(evidenceTypeClient.evidenceTypeGetByIdentifier()).item?.id
            ?: EvidenceTypeCreateCommand(
            identifier = identifier,
            name = name,
            description = "",
            validityPeriodConstraint = null
        ).invokeWith(evidenceTypeClient.evidenceTypeCreate()).id
    }

    private suspend fun EvidenceTypeListBase.getOrCreate(evidenceTypeIdMap: Map<String, EvidenceTypeId>): EvidenceTypeListId {
        return EvidenceTypeListGetByIdentifierQueryDTOBase(
            identifier = identifier
        ).invokeWith(evidenceTypeClient.evidenceTypeListGetByIdentifier()).item?.id
            ?:  EvidenceTypeListCreateCommand(
            identifier = identifier,
            name = name,
            description = description,
            specifiesEvidenceType = specifiesEvidenceType.map { evidenceTypeIdMap[it.identifier]!! }
        ).invokeWith(evidenceTypeClient.evidenceTypeListCreate()).id
    }
}
