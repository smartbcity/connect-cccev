package cccev.s2.evidence.api.entity.type

import cccev.s2.evidence.domain.EvidenceTypeId
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface EvidenceTypeRepository: ReactiveMongoRepository<EvidenceTypeEntity, EvidenceTypeId>
