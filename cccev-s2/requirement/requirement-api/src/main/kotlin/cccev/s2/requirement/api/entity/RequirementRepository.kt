package cccev.s2.requirement.api.entity

import cccev.s2.requirement.domain.RequirementId
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface RequirementRepository: ReactiveMongoRepository<RequirementEntity, RequirementId>
