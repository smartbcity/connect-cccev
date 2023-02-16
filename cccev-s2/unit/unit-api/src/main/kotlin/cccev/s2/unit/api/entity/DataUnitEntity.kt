package cccev.s2.unit.api.entity

import cccev.s2.unit.domain.DataUnitId
import cccev.s2.unit.domain.DataUnitState
import cccev.s2.unit.domain.model.DataUnitType
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import s2.dsl.automate.model.WithS2Id
import s2.dsl.automate.model.WithS2State
import s2.spring.utils.data.EntityBase
import java.util.UUID

@Document("unit")
data class DataUnitEntity(
    @Id
    val id: DataUnitId = UUID.randomUUID().toString(),
    val name: String,
    val description: String,
    val notation: String?,
    val type: DataUnitType,
    val status: DataUnitState
): EntityBase(), WithS2Id<DataUnitId>, WithS2State<DataUnitState> {
    override fun s2Id() = id
    override fun s2State() = status
}
