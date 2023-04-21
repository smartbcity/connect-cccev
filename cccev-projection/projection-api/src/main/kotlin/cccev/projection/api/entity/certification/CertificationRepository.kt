package cccev.projection.api.entity.certification

import cccev.projection.api.entity.SnapRepositoryBase
import cccev.s2.certification.domain.model.CertificationId
import cccev.s2.certification.domain.model.CertificationIdentifier
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Repository
interface CertificationRepository: ReactiveNeo4jRepository<CertificationEntity, CertificationId> {
    fun findByIdentifier(identifier: CertificationIdentifier): Mono<CertificationEntity>
}

@Service
class CertificationSnapRepository(
    override val repository: CertificationRepository
): SnapRepositoryBase<CertificationEntity, CertificationId>()
