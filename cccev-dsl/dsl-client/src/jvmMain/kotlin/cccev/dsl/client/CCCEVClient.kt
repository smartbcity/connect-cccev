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
import cccev.s2.concept.domain.command.InformationConceptCreateCommand
import cccev.s2.evidence.domain.command.list.EvidenceTypeListCreateCommand
import cccev.s2.evidence.domain.command.type.EvidenceTypeCreateCommand
import cccev.s2.requirement.client.RequirementClient
import cccev.s2.requirement.client.requirementClient
import cccev.s2.requirement.domain.command.RequirementCreatedEvent
import cccev.s2.requirement.domain.model.RequirementIdentifier
import cccev.s2.requirement.domain.model.RequirementKind
import f2.client.ktor.F2ClientBuilder
import f2.client.ktor.get
import f2.dsl.fnc.invoke
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
        val visitedConceptIdentifiers = mutableSetOf<String>()
        val visitedEvidenceTypeIdentifiers = mutableSetOf<String>()
        val visitedEvidenceTypeListIdentifiers = mutableSetOf<String>()

        fun Requirement.flatten(): Flow<Requirement> = flow {
            if (identifier in visitedRequirementIdentifiers) {
                return@flow
            }
            visitedRequirementIdentifiers += identifier!!

            emit(this@flatten)
            hasRequirement?.forEach { emitAll(it.flatten()) }
            isRequirementOf?.forEach { emitAll(it.flatten()) }
            hasQualifiedRelation?.forEach { emitAll(it.flatten()) }
        }

        return requirements.flatMapConcat(Requirement::flatten)
            .map { requirement ->
                requirement.hasConcept?.forEach { concept ->
                    if (concept.identifier !in visitedConceptIdentifiers) {
                        visitedConceptIdentifiers += concept.identifier
                        concept.create()
                    }
                }

                requirement.hasEvidenceTypeList?.forEach { etl ->
                    if (etl.identifier !in visitedEvidenceTypeListIdentifiers) {
                        visitedEvidenceTypeListIdentifiers += etl.identifier

                        etl.specifiesEvidenceType.forEach { et ->
                            if (et.identifier !in visitedEvidenceTypeIdentifiers) {
                                visitedEvidenceTypeIdentifiers += et.identifier
                                et.create()
                            }
                        }

                        etl.create()
                    }
                }

                RequirementCreateCommandDTOBase(
                    identifier = requirement.identifier,
                    name = requirement.name,
                    description = requirement.description,
                    hasConcept = requirement.hasConcept?.map(InformationConceptBase::identifier).orEmpty(),
                    hasEvidenceTypeList = requirement.hasEvidenceTypeList?.map(EvidenceTypeListBase::identifier).orEmpty(),
                    hasRequirement = requirement.hasRequirement?.mapNotNull(Requirement::identifier).orEmpty(),
                    isRequirementOf = requirement.isRequirementOf?.mapNotNull(Requirement::identifier),
                    hasQualifiedRelation = requirement.hasQualifiedRelation?.mapNotNull(Requirement::identifier),
                    kind = RequirementKind.INFORMATION.name
                )
            }.let { flow ->
                requirementClient.requirementCreate().invoke(flow)
            }
    }

    suspend fun InformationConceptBase.create() {
        InformationConceptCreateCommand(
            name = name,
            identifier = identifier,
            unitId = unit.identifier,
            description = description,
            expressionOfExpectedValue = expressionOfExpectedValue,
            dependsOn = dependsOn,
        ).let { informationConceptClient.conceptCreate().invoke(it) }
    }

    suspend fun EvidenceTypeBase.create() {
        EvidenceTypeCreateCommand(
            identifier = identifier,
            name = name,
            description = "",
            validityPeriodConstraint = null
        ).let { evidenceTypeClient.evidenceTypeCreate().invoke(it) }
    }

    suspend fun EvidenceTypeListBase.create() {
        EvidenceTypeListCreateCommand(
            identifier = identifier,
            name = name,
            description = description,
            specifiesEvidenceType = specifiesEvidenceType.map(EvidenceTypeBase::identifier)
        ).let { evidenceTypeClient.evidenceTypeListCreate().invoke(it) }
    }
}
