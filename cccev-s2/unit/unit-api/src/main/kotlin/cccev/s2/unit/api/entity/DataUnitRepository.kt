package cccev.s2.unit.api.entity

import cccev.s2.unit.domain.DataUnitId
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface DataUnitRepository: ReactiveMongoRepository<DataUnitEntity, DataUnitId>
