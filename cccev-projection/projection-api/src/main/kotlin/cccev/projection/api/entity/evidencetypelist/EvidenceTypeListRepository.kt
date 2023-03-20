package cccev.projection.api.entity.evidencetypelist

import cccev.projection.api.entity.SnapRepositoryBase
import cccev.s2.evidence.domain.EvidenceTypeListId
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

interface EvidenceTypeListRepository: ReactiveNeo4jRepository<EvidenceTypeListEntity, EvidenceTypeListId> {
    fun findByIdIn(ids: Collection<String>): Flux<EvidenceTypeListEntity>
}

@Service
class EvidenceTypeListSnapRepository(
    override val repository: EvidenceTypeListRepository
): SnapRepositoryBase<EvidenceTypeListEntity, EvidenceTypeListId>()
