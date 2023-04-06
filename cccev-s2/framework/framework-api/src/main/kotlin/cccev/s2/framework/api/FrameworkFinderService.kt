package cccev.s2.framework.api

import cccev.projection.api.entity.framework.FrameworkRepository
import cccev.s2.framework.api.entity.toFramework
import cccev.s2.framework.domain.FrameworkFinder
import cccev.s2.framework.domain.FrameworkId
import cccev.s2.framework.domain.model.Framework
import f2.spring.exception.NotFoundException
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.stereotype.Service

@Service
class FrameworkFinderService(
    private val frameworkRepository: FrameworkRepository
): FrameworkFinder {
    override suspend fun getOrNull(id: FrameworkId): Framework? {
        return frameworkRepository.findById(id)
            .awaitSingleOrNull()
            ?.toFramework()
    }

    override suspend fun get(id: FrameworkId): Framework {
        return getOrNull(id) ?: throw NotFoundException("Framework", id)
    }
}
