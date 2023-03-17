package cccev.projection.api.entity.request

import cccev.s2.request.domain.model.RequestId
import kotlin.jvm.optionals.getOrNull
import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import s2.sourcing.dsl.snap.SnapRepository

@Repository
interface RequestRepository : ReactiveNeo4jRepository<RequestEntity, RequestId>

@Service
class RequestSnapRepository(
    private val repository: RequestRepository
): SnapRepository<RequestEntity, RequestId> {
    override suspend fun get(id: RequestId): RequestEntity? {
        return repository.findById(id).awaitSingleOrNull()
    }

    override suspend fun remove(id: RequestId): Boolean {
        repository.deleteById(id)
        return true
    }

    override suspend fun save(entity: RequestEntity): RequestEntity {
        return repository.save(entity).awaitSingle()
    }
}
