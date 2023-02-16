package cccev.test

import kotlinx.coroutines.reactor.awaitSingle
import org.assertj.core.api.Assertions
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import s2.spring.utils.data.EntityBase

abstract class AssertionMongoEntity<Entity: EntityBase, ID: Any, Asserter> {
    protected abstract val repository: ReactiveMongoRepository<Entity, ID>

    suspend fun exists(id: ID) {
        Assertions.assertThat(existsById(id)).isTrue
    }

    suspend fun notExists(id: ID) {
        Assertions.assertThat(existsById(id)).isFalse
    }

    private suspend fun existsById(id: ID): Boolean {
        return repository.existsById(id).awaitSingle()
    }

    suspend fun assertThat(id: ID): Asserter {
        exists(id)
        val entity = repository.findById(id).awaitSingle()
        return assertThat(entity)
    }

    abstract suspend fun assertThat(entity: Entity): Asserter
}
