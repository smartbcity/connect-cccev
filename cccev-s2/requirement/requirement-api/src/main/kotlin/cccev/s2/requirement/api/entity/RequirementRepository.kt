package cccev.s2.requirement.api.entity

import cccev.s2.requirement.domain.RequirementId
import cccev.s2.requirement.domain.model.RequirementIdentifier
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface RequirementRepository: ReactiveMongoRepository<RequirementEntity, RequirementId> {
    fun findByIdentifier(identifier: RequirementIdentifier): Mono<RequirementEntity>
}
