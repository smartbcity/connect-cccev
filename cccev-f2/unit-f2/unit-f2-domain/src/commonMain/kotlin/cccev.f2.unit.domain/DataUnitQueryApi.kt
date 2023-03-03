package cccev.f2.unit.domain

import cccev.f2.unit.domain.query.DataUnitGetFunction

interface DataUnitQueryApi {
    fun dataUnitGet(): DataUnitGetFunction
}
