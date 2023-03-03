package cccev.projection.api.entity.unit

import cccev.s2.unit.domain.DataUnitId
import cccev.s2.unit.domain.DataUnitState
import cccev.s2.unit.domain.model.DataUnitType
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import java.util.UUID

@Node("DataUnit")
class DataUnitEntity {
    @Id
    val id: DataUnitId = UUID.randomUUID().toString()

    lateinit var name: String

    lateinit var description: String

    var notation: String? = null

    lateinit var type: DataUnitType

    lateinit var status: DataUnitState
}
