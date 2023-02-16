package cccev.f2.unit.api.service

import cccev.f2.unit.domain.command.DataUnitCreateCommandDTOBase
import cccev.s2.unit.api.DataUnitAggregateService
import cccev.s2.unit.domain.command.DataUnitCreateCommand
import cccev.s2.unit.domain.command.DataUnitCreatedEvent
import cccev.s2.unit.domain.model.DataUnitType
import org.springframework.stereotype.Service

@Service
class DataUnitF2AggregateService(
    private val dataUnitAggregateService: DataUnitAggregateService
) {
    suspend fun create(command: DataUnitCreateCommandDTOBase): DataUnitCreatedEvent {
        return DataUnitCreateCommand(
            name = command.name,
            description = command.description,
            notation = command.notation,
            type = DataUnitType.valueOf(command.type),
        ).let { dataUnitAggregateService.create(it) }
    }
}
