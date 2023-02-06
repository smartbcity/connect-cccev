package cccev.s2.requirement.api

import cccev.s2.requirement.api.config.RequirementAutomateExecutor
import cccev.s2.requirement.api.entity.RequirementEntity
import cccev.s2.requirement.domain.RequirementAggregate
import cccev.s2.requirement.domain.RequirementState
import cccev.s2.requirement.domain.command.RequirementCreateCommand
import cccev.s2.requirement.domain.command.RequirementCreatedEvent
import org.springframework.stereotype.Service

@Service
class RequirementAggregateService(
    private val automate: RequirementAutomateExecutor
): RequirementAggregate {
    override suspend fun create(command: RequirementCreateCommand) = automate.createWithEvent(command) {
        val entity = RequirementEntity(
            kind = command.kind,
            name = command.name,
            description = command.description,
            type = command.type,
            hasRequirement = emptyList(),
            hasConcept = emptyList(),
            hasEvidenceTypeList = emptyList(),
            status = RequirementState.CREATED
        )
        entity to RequirementCreatedEvent(entity.id)
    }
}
