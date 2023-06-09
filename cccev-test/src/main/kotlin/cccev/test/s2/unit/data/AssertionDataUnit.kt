package cccev.test.s2.unit.data

import cccev.projection.api.entity.unit.DataUnitEntity
import cccev.projection.api.entity.unit.DataUnitRepository
import cccev.s2.unit.domain.DataUnitId
import cccev.s2.unit.domain.DataUnitState
import cccev.s2.unit.domain.model.DataUnitType
import org.assertj.core.api.Assertions
import s2.bdd.assertion.AssertionBdd
import s2.bdd.repository.AssertionCrudEntity

fun AssertionBdd.dataUnit(unitRepository: DataUnitRepository) = AssertionDataUnit(unitRepository)

class AssertionDataUnit(
    override val repository: DataUnitRepository
): AssertionCrudEntity<DataUnitEntity, DataUnitId, AssertionDataUnit.DataUnitAssert>() {

    override suspend fun assertThat(entity: DataUnitEntity) = DataUnitAssert(entity)

    inner class DataUnitAssert(
        private val unit: DataUnitEntity
    ) {
        fun hasFields(
            id: DataUnitId = unit.id,
            status: DataUnitState = unit.status,
            name: String = unit.name,
            description: String = unit.description,
            notation: String? = unit.notation,
            type: DataUnitType = unit.type
        ) = also {
            Assertions.assertThat(unit.id).isEqualTo(id)
            Assertions.assertThat(unit.status).isEqualTo(status)
            Assertions.assertThat(unit.name).isEqualTo(name)
            Assertions.assertThat(unit.description).isEqualTo(description)
            Assertions.assertThat(unit.notation).isEqualTo(notation)
            Assertions.assertThat(unit.type).isEqualTo(type)
        }
    }
}
