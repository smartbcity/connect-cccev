package cccev.projection.api.entity.requirement

import cccev.projection.api.entity.SnapRepositoryBase
import cccev.s2.requirement.domain.RequirementId
import cccev.s2.requirement.domain.model.RequirementIdentifier
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
interface RequirementRepository: ReactiveNeo4jRepository<RequirementEntity, RequirementId> {
    fun findByIdentifier(id: RequirementIdentifier): Mono<RequirementEntity>
    fun findByIdentifierIn(ids: Collection<RequirementIdentifier>): Flux<RequirementEntity>
//    fun findAllByIsRequirementOf(id: RequirementId): Mono<RequirementEntity>
}

@Service
class RequirementSnapRepository(
    override val repository: RequirementRepository
): SnapRepositoryBase<RequirementEntity, RequirementId>()
