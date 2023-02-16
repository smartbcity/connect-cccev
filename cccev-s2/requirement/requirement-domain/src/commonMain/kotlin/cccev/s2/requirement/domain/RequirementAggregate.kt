package cccev.s2.requirement.domain

import cccev.s2.requirement.domain.command.RequirementCreateCommand
import cccev.s2.requirement.domain.command.RequirementCreatedEvent
import cccev.s2.requirement.domain.command.RequirementUpdateCommand
import cccev.s2.requirement.domain.command.RequirementUpdatedEvent

interface RequirementAggregate {
	suspend fun create(command: RequirementCreateCommand): RequirementCreatedEvent
	suspend fun update(command: RequirementUpdateCommand): RequirementUpdatedEvent
}
