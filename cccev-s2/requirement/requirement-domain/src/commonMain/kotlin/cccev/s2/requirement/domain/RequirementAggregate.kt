package cccev.s2.requirement.domain

import cccev.s2.requirement.domain.command.RequirementCreateCommand
import cccev.s2.requirement.domain.command.RequirementCreatedEvent

interface RequirementAggregate {
	suspend fun create(command: RequirementCreateCommand): RequirementCreatedEvent
}
