package cccev.f2.unit.domain

import cccev.f2.unit.domain.query.DataUnitGetByIdentifierFunction
import cccev.f2.unit.domain.query.DataUnitGetFunction

interface DataUnitQueryApi {
    fun dataUnitGet(): DataUnitGetFunction
    fun dataUnitGetByIdentifier(): DataUnitGetByIdentifierFunction
}
