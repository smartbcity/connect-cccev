package cccev.projection.api.entity.concept

import cccev.projection.api.entity.SnapRepositoryBase
import cccev.s2.concept.domain.InformationConceptId
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

interface InformationConceptRepository: ReactiveNeo4jRepository<InformationConceptEntity, InformationConceptId> {
    fun findByIdentifier(identifier: String): Mono<InformationConceptEntity>
}

@Service
class InformationConceptSnapRepository(
    override val repository: InformationConceptRepository
): SnapRepositoryBase<InformationConceptEntity, InformationConceptId>()
