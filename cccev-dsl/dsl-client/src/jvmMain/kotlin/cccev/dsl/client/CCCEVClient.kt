package cccev.dsl.client

import cccev.dsl.model.EvidenceTypeBase
import cccev.dsl.model.EvidenceTypeListBase
import cccev.dsl.model.InformationConceptBase
import cccev.dsl.model.Requirement
import cccev.f2.concept.client.InformationConceptClient
import cccev.f2.concept.client.informationConceptClient
import cccev.f2.evidence.type.client.EvidenceTypeClient
import cccev.f2.evidence.type.client.evidenceTypeClient
import cccev.f2.requirement.domain.command.RequirementCreateCommandDTOBase
import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.concept.domain.command.InformationConceptCreateCommand
import cccev.s2.concept.domain.command.InformationConceptCreatedEvent
import cccev.s2.evidence.domain.EvidenceTypeId
import cccev.s2.evidence.domain.EvidenceTypeListId
import cccev.s2.evidence.domain.command.list.EvidenceTypeListCreateCommand
import cccev.s2.evidence.domain.command.list.EvidenceTypeListCreatedEvent
import cccev.s2.evidence.domain.command.type.EvidenceTypeCreateCommand
import cccev.s2.evidence.domain.command.type.EvidenceTypeCreatedEvent
import cccev.s2.requirement.client.RequirementClient
import cccev.s2.requirement.client.requirementClient
import cccev.s2.requirement.domain.RequirementId
import cccev.s2.requirement.domain.command.RequirementAddRequirementsCommand
import cccev.s2.requirement.domain.command.RequirementCreatedEvent
import cccev.s2.requirement.domain.model.RequirementIdentifier
import cccev.s2.requirement.domain.model.RequirementKind
import f2.client.ktor.F2ClientBuilder
import f2.client.ktor.get
import f2.dsl.fnc.invokeWith
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class CCCEVClient(
    private val evidenceTypeClient: EvidenceTypeClient,
    private val informationConceptClient: InformationConceptClient,
    private val requirementClient: RequirementClient
) {
    companion object {
        suspend operator fun invoke(url: String): CCCEVClient {
            val f2Client = F2ClientBuilder.get(url)
            return CCCEVClient(
                f2Client.evidenceTypeClient().invoke(),
                f2Client.informationConceptClient().invoke(),
                f2Client.requirementClient().invoke()
            )
        }
    }

    suspend fun createGraph(requirements: Flow<Requirement>): Flow<RequirementCreatedEvent> {
        val visitedRequirementIdentifiers = mutableSetOf<RequirementIdentifier>()
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
            hasQualifiedRelation?.forEach { emitAll(it.flatten()) }
            emit(this@flatten)
        }

        return requirements.flatMapConcat(Requirement::flatten)
            .map { requirement ->
                requirement.hasConcept?.forEach { concept ->
                    if (concept.identifier !in createdConcepts) {
                        val conceptId = concept.create(createdConcepts).id
                        createdConcepts[concept.identifier] = conceptId
                    }
                }

                requirement.hasEvidenceTypeList?.forEach { etl ->
                    if (etl.identifier !in createdEvidenceTypeLists) {

                        etl.specifiesEvidenceType.forEach { et ->
                            if (et.identifier !in createdEvidenceTypes) {
                                val evidenceTypeId = et.create().id
                                createdEvidenceTypes[et.identifier] = evidenceTypeId
                            }
                        }

                        val evidenceTypeListId = etl.create(createdEvidenceTypes).id
                        createdEvidenceTypeLists[etl.identifier] = evidenceTypeListId
                    }
                }

                val event = RequirementCreateCommandDTOBase(
                    identifier = requirement.identifier,
                    name = requirement.name,
                    description = requirement.description,
                    hasConcept = requirement.hasConcept?.map { createdConcepts[it.identifier]!! }.orEmpty(),
                    hasEvidenceTypeList = requirement.hasEvidenceTypeList?.map { createdEvidenceTypeLists[it.identifier]!! }.orEmpty(),
                    hasRequirement = requirement.hasRequirement?.map { createdRequirements[it.identifier]!! }.orEmpty(),
                    hasQualifiedRelation = requirement.hasQualifiedRelation?.map { createdRequirements[it.identifier]!! },
                    kind = RequirementKind.INFORMATION.name
                ).invokeWith(requirementClient.requirementCreate())

                createdRequirements[event.identifier!!] = event.id

                requirement.isRequirementOf?.forEach { parent ->
                    RequirementAddRequirementsCommand(
                        id = createdRequirements[parent.identifier]!!,
                        requirementIds = listOf(event.id)
                    ).invokeWith(requirementClient.requirementAddRequirements())
                }

                event
            }
    }

    private suspend fun InformationConceptBase.create(conceptIdMap: Map<String, InformationConceptId>): InformationConceptCreatedEvent {
        return InformationConceptCreateCommand(
            name = name,
            identifier = identifier,
            hasUnit = unit.identifier,
            description = description,
            expressionOfExpectedValue = expressionOfExpectedValue,
            dependsOn = dependsOn.map { conceptIdMap[it]!! },
        ).invokeWith(informationConceptClient.conceptCreate())
    }

    private suspend fun EvidenceTypeBase.create(): EvidenceTypeCreatedEvent {
        return EvidenceTypeCreateCommand(
            identifier = identifier,
            name = name,
            description = "",
            validityPeriodConstraint = null
        ).invokeWith(evidenceTypeClient.evidenceTypeCreate())
    }

    private suspend fun EvidenceTypeListBase.create(evidenceTypeIdMap: Map<String, EvidenceTypeId>): EvidenceTypeListCreatedEvent {
        return EvidenceTypeListCreateCommand(
            identifier = identifier,
            name = name,
            description = description,
            specifiesEvidenceType = specifiesEvidenceType.map { evidenceTypeIdMap[it.identifier]!! }
        ).invokeWith(evidenceTypeClient.evidenceTypeListCreate())
    }
}
