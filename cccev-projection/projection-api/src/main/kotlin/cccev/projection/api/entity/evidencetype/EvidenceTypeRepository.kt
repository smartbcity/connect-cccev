package cccev.projection.api.entity.evidencetype

import cccev.projection.api.entity.SnapRepositoryBase
import cccev.s2.evidence.domain.EvidenceTypeId
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

interface EvidenceTypeRepository: ReactiveNeo4jRepository<EvidenceTypeEntity, EvidenceTypeId> {
    fun findByIdIn(ids: Collection<EvidenceTypeId>): Flux<EvidenceTypeEntity>
}

@Service
class EvidenceTypeSnapRepository(
    override val repository: EvidenceTypeRepository
): SnapRepositoryBase<EvidenceTypeEntity, EvidenceTypeId>()
