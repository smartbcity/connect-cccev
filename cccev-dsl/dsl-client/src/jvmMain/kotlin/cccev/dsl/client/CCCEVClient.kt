package cccev.dsl.client

import cccev.dsl.model.Requirement
import cccev.f2.requirement.domain.command.RequirementCreateCommandDTOBase
import cccev.s2.requirement.client.RequirementClient
import cccev.s2.requirement.client.requirementClient
import cccev.s2.requirement.domain.command.RequirementCreatedEvent
import cccev.s2.requirement.domain.model.RequirementKind
import f2.client.ktor.F2ClientBuilder
import f2.client.ktor.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapMerge
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
        return requirements.flatMapMerge { requirement ->
            buildList {
                requirement.let(::add)
                requirement.hasRequirement?.let(::addAll)
                requirement.isRequirementOf?.let(::addAll)
                requirement.hasQualifiedRelation?.let(::addAll)
            }.asFlow()
        }.map { requirement ->
            RequirementCreateCommandDTOBase(
                name = requirement.name,
                description = requirement.description,
                hasConcept = emptyList(),
                hasEvidenceTypeList = emptyList(),
                hasRequirement = requirement.hasRequirement?.mapNotNull { it.identifier } ?: emptyList(),
                isRequirementOf = requirement.isRequirementOf?.mapNotNull { it.identifier },
                hasQualifiedRelation = requirement.hasQualifiedRelation?.mapNotNull { it.identifier },
                kind = RequirementKind.INFORMATION.name
            )
        }.let { flow ->
            requirementClient.requirementCreate().invoke(flow)
        }
    }
}
