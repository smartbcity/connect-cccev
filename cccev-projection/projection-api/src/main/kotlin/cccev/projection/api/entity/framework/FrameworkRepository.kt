package cccev.projection.api.entity.framework

import cccev.projection.api.entity.SnapRepositoryBase
import cccev.s2.framework.domain.FrameworkId
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

interface FrameworkRepository: ReactiveNeo4jRepository<FrameworkEntity, FrameworkId> {
    fun findByIdentifier(identifier: String): Mono<FrameworkEntity>
}

@Service
class FrameworkSnapRepository(
    override val repository: FrameworkRepository
): SnapRepositoryBase<FrameworkEntity, FrameworkId>() {
    suspend fun findByIdentifier(identifier: String): FrameworkEntity? {
        return repository.findByIdentifier(identifier).awaitSingleOrNull()
    }
}
