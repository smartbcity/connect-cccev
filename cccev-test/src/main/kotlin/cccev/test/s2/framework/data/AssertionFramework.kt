package cccev.test.s2.framework.data

import cccev.projection.api.entity.framework.FrameworkEntity
import cccev.projection.api.entity.framework.FrameworkRepository
import cccev.s2.framework.domain.FrameworkId
import cccev.s2.framework.domain.FrameworkState
import org.assertj.core.api.Assertions
import s2.bdd.assertion.AssertionBdd
import s2.bdd.repository.AssertionCrudEntity

fun AssertionBdd.framework(conceptRepository: FrameworkRepository) = AssertionFramework(conceptRepository)

class AssertionFramework(
    override val repository: FrameworkRepository
): AssertionCrudEntity<FrameworkEntity, FrameworkId, AssertionFramework.FrameworkAssert>() {

    override suspend fun assertThat(entity: FrameworkEntity) = FrameworkAssert(entity)

    inner class FrameworkAssert(
        private val framework: FrameworkEntity
    ) {
        fun hasFields(
            id: FrameworkId = framework.id,
            status: FrameworkState = framework.status,
            identifier: String? = framework.identifier,
            name: String = framework.name,
        ) = also {
            Assertions.assertThat(framework.id).isEqualTo(id)
            Assertions.assertThat(framework.status).isEqualTo(status)
            Assertions.assertThat(framework.identifier).isEqualTo(identifier)
            Assertions.assertThat(framework.name).isEqualTo(name)
        }
    }
}
