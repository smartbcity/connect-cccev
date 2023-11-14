package cccev.projection.api.entity.unit

import cccev.s2.unit.domain.model.DataUnit

fun DataUnitEntity.toDataUnit() = DataUnit(
    id = id,
    name = name,
    description = description,
    notation = notation,
    type = type
)
