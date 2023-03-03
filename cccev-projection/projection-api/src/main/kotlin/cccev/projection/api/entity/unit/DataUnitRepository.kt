package cccev.projection.api.entity.unit

import cccev.s2.unit.domain.DataUnitId
import org.springframework.data.neo4j.repository.Neo4jRepository

interface DataUnitRepository: Neo4jRepository<DataUnitEntity, DataUnitId>
