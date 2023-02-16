package cccev.s2.unit.api

import cccev.s2.unit.api.config.DataUnitAutomateExecutor
import cccev.s2.unit.api.entity.DataUnitEntity
import cccev.s2.unit.domain.DataUnitAggregate
import cccev.s2.unit.domain.DataUnitState
import cccev.s2.unit.domain.command.DataUnitCreateCommand
import cccev.s2.unit.domain.command.DataUnitCreatedEvent
import org.springframework.stereotype.Service

@Service
class DataUnitAggregateService(
    private val automate: DataUnitAutomateExecutor
): DataUnitAggregate {
    override suspend fun create(command: DataUnitCreateCommand) = automate.createWithEvent(command) {
        val entity = DataUnitEntity(
            name = command.name,
            description = command.description,
            type = command.type,
            notation = command.notation,
            status = DataUnitState.EXISTS
        )
        entity to DataUnitCreatedEvent(entity.id)
    }
}
