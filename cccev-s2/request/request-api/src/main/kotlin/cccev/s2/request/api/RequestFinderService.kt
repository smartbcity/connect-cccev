package cccev.s2.request.api

import cccev.projection.api.entity.request.RequestRepository
import cccev.s2.request.api.entity.toRequest
import cccev.s2.request.domain.model.Request
import cccev.s2.request.domain.model.RequestId
import kotlin.jvm.optionals.getOrNull
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.stereotype.Service

@Service
class RequestFinderService(
    private val requestRepository: RequestRepository
) {
    suspend fun get(id: RequestId): Request? {
        return requestRepository.findById(id)
            .awaitSingleOrNull()
            ?.toRequest()
    }
}
