package cccev.projection.api.entity.evidencetypelist

import cccev.projection.api.entity.SnapRepositoryBase
import cccev.s2.evidence.type.domain.EvidenceTypeIdentifier
import cccev.s2.evidence.type.domain.EvidenceTypeListId
import cccev.s2.evidence.type.domain.EvidenceTypeListIdentifier
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

interface EvidenceTypeListRepository: ReactiveNeo4jRepository<EvidenceTypeListEntity, EvidenceTypeListId> {
    fun findByIdentifier(identifier: EvidenceTypeListIdentifier): Mono<EvidenceTypeListEntity>
}

@Service
class EvidenceTypeListSnapRepository(
    override val repository: EvidenceTypeListRepository
): SnapRepositoryBase<EvidenceTypeListEntity, EvidenceTypeListId>()
