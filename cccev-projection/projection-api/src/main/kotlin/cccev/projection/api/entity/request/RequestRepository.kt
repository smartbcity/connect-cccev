package cccev.projection.api.entity.request

import cccev.projection.api.entity.SnapRepositoryBase
import cccev.s2.request.domain.model.RequestId
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Repository
interface RequestRepository: ReactiveNeo4jRepository<RequestEntity, RequestId>

@Service
class RequestSnapRepository(
    override val repository: RequestRepository
): SnapRepositoryBase<RequestEntity, RequestId>()
