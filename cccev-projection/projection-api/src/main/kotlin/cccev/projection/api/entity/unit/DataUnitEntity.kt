package cccev.projection.api.entity.unit

import cccev.projection.api.entity.NodeLabel
import cccev.s2.unit.domain.DataUnitId
import cccev.s2.unit.domain.DataUnitState
import cccev.s2.unit.domain.model.DataUnitType
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import org.springframework.data.neo4j.core.schema.Node
import s2.dsl.automate.model.WithS2Id
import s2.dsl.automate.model.WithS2State

@Node(NodeLabel.DATA_UNIT)
data class DataUnitEntity(
    @Id
    val id: DataUnitId,
    @Version
    var version: Long = 0,
    @CreatedDate
    var creationDate: Long = 0,
    @LastModifiedDate
    var lastModificationDate: Long = 0,
    val status: DataUnitState,
    val name: String,
    val description: String,
    val notation: String? = null,
    val type: DataUnitType
): WithS2Id<DataUnitId>, WithS2State<DataUnitState> {

    override fun s2Id() = id
    override fun s2State() = status
}
