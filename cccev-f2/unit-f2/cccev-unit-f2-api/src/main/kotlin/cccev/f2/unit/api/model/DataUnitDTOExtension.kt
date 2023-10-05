package cccev.f2.unit.api.model

import cccev.f2.unit.domain.model.DataUnitDTOBase
import cccev.s2.unit.domain.model.DataUnit

fun DataUnit.toDTO() = DataUnitDTOBase(
    id = id,
    name = name,
    description = description,
    notation = notation,
    type = type.name,
)
