package cccev.s2.unit.domain

import cccev.s2.unit.domain.model.DataUnit

interface DataUnitFinder {
    suspend fun getOrNull(id: DataUnitId): DataUnit?
    suspend fun getOrNullByIdentifier(id: DataUnitIdentifier): DataUnit?
    suspend fun get(id: DataUnitId): DataUnit
}
