package cccev.projection.api.entity.evidencetype

import cccev.projection.api.entity.SnapRepositoryBase
import cccev.s2.evidence.type.domain.EvidenceTypeId
import cccev.s2.evidence.type.domain.EvidenceTypeIdentifier
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface EvidenceTypeRepository: ReactiveNeo4jRepository<EvidenceTypeEntity, EvidenceTypeId> {
    fun findByIdIn(ids: Collection<EvidenceTypeId>): Flux<EvidenceTypeEntity>
    fun findByIdentifier(identifier: EvidenceTypeIdentifier): Mono<EvidenceTypeEntity>
}

@Service
class EvidenceTypeSnapRepository(
    override val repository: EvidenceTypeRepository
): SnapRepositoryBase<EvidenceTypeEntity, EvidenceTypeId>()
