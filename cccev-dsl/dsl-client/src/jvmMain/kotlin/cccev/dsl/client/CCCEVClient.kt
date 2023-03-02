package cccev.dsl.client

import cccev.dsl.model.Requirement
import cccev.dsl.model.RequirementId
import cccev.f2.requirement.domain.command.RequirementCreateCommandDTOBase
import cccev.s2.requirement.client.RequirementClient
import cccev.s2.requirement.client.requirementClient
import cccev.s2.requirement.domain.command.RequirementCreatedEvent
import cccev.s2.requirement.domain.model.RequirementKind
import f2.client.ktor.F2ClientBuilder
import f2.client.ktor.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class CCCEVClient(
    private val requirementClient: RequirementClient
) {
    companion object {
        suspend operator fun invoke(url: String): CCCEVClient {
            val f2Client = F2ClientBuilder.get(url)
            return CCCEVClient(f2Client.requirementClient().invoke())
        }
    }

    suspend fun requirementCreate(requirements: Flow<Requirement>): Flow<RequirementCreatedEvent> {
        val addedRequirementIds = mutableSetOf<RequirementId>()

        fun Requirement.flatten(): Flow<Requirement> = flow {
            if (identifier in addedRequirementIds) {
                return@flow
            }
            addedRequirementIds += identifier!!

            emit(this@flatten)
            hasRequirement?.forEach { emitAll(it.flatten()) }
            isRequirementOf?.forEach { emitAll(it.flatten()) }
            hasQualifiedRelation?.forEach { emitAll(it.flatten()) }
        }

        return requirements.flatMapConcat(Requirement::flatten)
            .map { requirement ->
                RequirementCreateCommandDTOBase(
                    identifier = requirement.identifier,
                    name = requirement.name,
                    description = requirement.description,
                    hasConcept = emptyList(),
                    hasEvidenceTypeList = emptyList(),
                    hasRequirement = requirement.hasRequirement?.mapNotNull(Requirement::identifier).orEmpty(),
                    isRequirementOf = requirement.isRequirementOf?.mapNotNull(Requirement::identifier),
                    hasQualifiedRelation = requirement.hasQualifiedRelation?.mapNotNull(Requirement::identifier),
                    kind = RequirementKind.INFORMATION.name
                )
            }.let { flow ->
                requirementClient.requirementCreate().invoke(flow)
            }
    }
}
