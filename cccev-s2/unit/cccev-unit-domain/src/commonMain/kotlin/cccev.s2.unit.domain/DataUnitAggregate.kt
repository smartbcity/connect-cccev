package cccev.s2.unit.domain

import cccev.s2.unit.domain.command.DataUnitCreateCommand
import cccev.s2.unit.domain.command.DataUnitCreatedEvent

interface DataUnitAggregate {
    suspend fun create(command: DataUnitCreateCommand): DataUnitCreatedEvent
}
