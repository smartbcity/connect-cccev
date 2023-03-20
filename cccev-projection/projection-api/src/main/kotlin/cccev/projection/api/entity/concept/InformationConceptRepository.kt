package cccev.projection.api.entity.concept

import cccev.projection.api.entity.SnapRepositoryBase
import cccev.s2.concept.domain.InformationConceptId
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

interface InformationConceptRepository: ReactiveNeo4jRepository<InformationConceptEntity, InformationConceptId> {
    fun findByIdIn(ids: Collection<InformationConceptId>): Flux<InformationConceptEntity>
}

@Service
class InformationConceptSnapRepository(
    override val repository: InformationConceptRepository
): SnapRepositoryBase<InformationConceptEntity, InformationConceptId>()
