package cccev.f2.unit.domain

import cccev.f2.unit.domain.command.DataUnitCreateFunction

interface DataUnitCommandApi {
    fun dataUnitCreate(): DataUnitCreateFunction
}
