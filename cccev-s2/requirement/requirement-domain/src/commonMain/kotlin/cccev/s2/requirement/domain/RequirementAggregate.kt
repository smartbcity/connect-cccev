package cccev.s2.requirement.domain

import cccev.s2.requirement.domain.features.command.RequirementCreateCommand
import cccev.s2.requirement.domain.features.command.RequirementInitializedEvent

interface RequirementAggregate {

	suspend fun create(cmd: RequirementCreateCommand): RequirementInitializedEvent
}
