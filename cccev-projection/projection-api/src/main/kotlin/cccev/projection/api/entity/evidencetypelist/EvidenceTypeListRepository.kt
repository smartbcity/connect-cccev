package cccev.projection.api.entity.evidencetypelist

import cccev.projection.api.entity.SnapRepositoryBase
import cccev.s2.evidence.domain.EvidenceTypeListId
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import org.springframework.stereotype.Service

interface EvidenceTypeListRepository: ReactiveNeo4jRepository<EvidenceTypeListEntity, EvidenceTypeListId>

@Service
class EvidenceTypeListSnapRepository(
    override val repository: EvidenceTypeListRepository
): SnapRepositoryBase<EvidenceTypeListEntity, EvidenceTypeListId>()
