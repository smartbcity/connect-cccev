package cccev.projection.api.entity.certification

import cccev.projection.api.entity.SnapRepositoryBase
import cccev.s2.certification.domain.model.CertificationId
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Repository
interface CertificationRepository: ReactiveNeo4jRepository<CertificationEntity, CertificationId>

@Service
class CertificationSnapRepository(
    override val repository: CertificationRepository
): SnapRepositoryBase<CertificationEntity, CertificationId>()
