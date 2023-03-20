package cccev.projection.api.entity.unit

import cccev.projection.api.entity.SnapRepositoryBase
import cccev.s2.unit.domain.DataUnitId
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import org.springframework.stereotype.Service

interface DataUnitRepository: ReactiveNeo4jRepository<DataUnitEntity, DataUnitId>

@Service
class DataUnitSnapRepository(
    override val repository: DataUnitRepository
): SnapRepositoryBase<DataUnitEntity, DataUnitId>()
