package cccev.s2.framework.domain

import cccev.s2.framework.domain.command.FrameworkCreateCommand
import cccev.s2.framework.domain.command.FrameworkCreatedEvent

interface FrameworkAggregate {
    suspend fun create(command: FrameworkCreateCommand): FrameworkCreatedEvent
}
