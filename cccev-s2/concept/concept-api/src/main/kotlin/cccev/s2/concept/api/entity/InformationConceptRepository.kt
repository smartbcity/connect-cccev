package cccev.s2.concept.api.entity

import cccev.s2.concept.domain.InformationConceptId
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface InformationConceptRepository: ReactiveMongoRepository<InformationConceptEntity, InformationConceptId>
