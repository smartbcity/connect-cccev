package cccev.f2.unit.api.service

import cccev.f2.unit.api.model.toDTO
import cccev.f2.unit.domain.model.DataUnitDTOBase
import cccev.s2.unit.api.DataUnitFinderService
import cccev.s2.unit.domain.DataUnitId
import org.springframework.stereotype.Service

@Service
class DataUnitF2FinderService(
    private val dataUnitFinderService: DataUnitFinderService
) {
    suspend fun getOrNull(id: DataUnitId): DataUnitDTOBase? {
        return dataUnitFinderService.getOrNull(id)?.toDTO()
    }

    suspend fun get(id: DataUnitId): DataUnitDTOBase {
        return dataUnitFinderService.get(id).toDTO()
    }
}
