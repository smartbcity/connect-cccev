package cccev.projection.api.entity

import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import s2.sourcing.dsl.snap.SnapRepository

abstract class SnapRepositoryBase<ENTITY, ID>: SnapRepository<ENTITY, ID> {
    protected abstract val repository: ReactiveNeo4jRepository<ENTITY, ID>

    override suspend fun get(id: ID): ENTITY? {
        return repository.findById(id).awaitSingleOrNull()
    }

    override suspend fun remove(id: ID): Boolean {
        repository.deleteById(id)
        return true
    }

    override suspend fun save(entity: ENTITY): ENTITY {
        return repository.save(entity).awaitSingle()
    }
}
