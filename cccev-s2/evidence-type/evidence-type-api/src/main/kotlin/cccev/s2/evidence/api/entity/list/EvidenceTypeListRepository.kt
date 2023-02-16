package cccev.s2.evidence.api.entity.list

import cccev.s2.evidence.domain.EvidenceTypeListId
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface EvidenceTypeListRepository: ReactiveMongoRepository<EvidenceTypeListEntity, EvidenceTypeListId>
