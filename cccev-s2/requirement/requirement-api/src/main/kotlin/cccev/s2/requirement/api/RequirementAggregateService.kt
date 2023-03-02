package cccev.s2.requirement.api

import cccev.s2.requirement.api.config.RequirementAutomateExecutor
import cccev.s2.requirement.api.entity.RequirementEntity
import cccev.s2.requirement.domain.RequirementAggregate
import cccev.s2.requirement.domain.RequirementState
import cccev.s2.requirement.domain.command.RequirementCreateCommand
import cccev.s2.requirement.domain.command.RequirementCreatedEvent
import cccev.s2.requirement.domain.command.RequirementUpdateCommand
import cccev.s2.requirement.domain.command.RequirementUpdatedEvent
import org.springframework.stereotype.Service

@Service
class RequirementAggregateService(
    private val automate: RequirementAutomateExecutor
): RequirementAggregate {
    override suspend fun create(command: RequirementCreateCommand) = automate.createWithEvent(command) {
        val entity = RequirementEntity(
            identifier = command.identifier,
            kind = command.kind,
            name = command.name,
            description = command.description,
            hasRequirement = command.hasRequirement,
            hasConcept = command.hasConcept,
            hasEvidenceTypeList = command.hasEvidenceTypeList,
            isRequirementOf = command.isRequirementOf.orEmpty(),
            hasQualifiedRelation = command.hasQualifiedRelation.orEmpty(),
            status = RequirementState.CREATED
        )
        entity to RequirementCreatedEvent(entity.id)
    }

    override suspend fun update(command: RequirementUpdateCommand) = automate.doTransition(command) {
        name = command.name
        description = command.description
        hasRequirement = command.hasRequirement
        hasConcept = command.hasConcept
        hasEvidenceTypeList = command.hasEvidenceTypeList

        this to RequirementUpdatedEvent(id)
    }
}
