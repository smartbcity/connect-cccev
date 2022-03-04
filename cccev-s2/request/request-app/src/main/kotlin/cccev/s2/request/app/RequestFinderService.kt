package cccev.s2.request.app

import cccev.s2.request.app.entity.RequestRepository
import cccev.s2.request.app.entity.toRequest
import cccev.s2.request.domain.model.Request
import cccev.s2.request.domain.model.RequestId
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Service

@Service
class RequestFinderService(
    private val requestRepository: RequestRepository
) {
    suspend fun get(id: RequestId): Request? {
        return requestRepository.findById(id)
            .awaitSingle()
            ?.toRequest()
    }
}
