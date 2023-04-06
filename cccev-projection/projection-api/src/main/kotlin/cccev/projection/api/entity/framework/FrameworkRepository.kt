package cccev.projection.api.entity.framework

import cccev.projection.api.entity.SnapRepositoryBase
import cccev.s2.framework.domain.FrameworkId
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import org.springframework.stereotype.Service

interface FrameworkRepository: ReactiveNeo4jRepository<FrameworkEntity, FrameworkId>

@Service
class FrameworkSnapRepository(
    override val repository: FrameworkRepository
): SnapRepositoryBase<FrameworkEntity, FrameworkId>()
