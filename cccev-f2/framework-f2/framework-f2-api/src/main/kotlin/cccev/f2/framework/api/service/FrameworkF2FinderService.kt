package cccev.f2.framework.api.service

import cccev.s2.framework.api.FrameworkFinderService
import cccev.s2.framework.domain.FrameworkId
import cccev.s2.framework.domain.model.Framework
import org.springframework.stereotype.Service

@Service
class FrameworkF2FinderService(
    private val frameworkFinderService: FrameworkFinderService
) {
    suspend fun getOrNull(id: FrameworkId): Framework? {
        return frameworkFinderService.getOrNull(id)
    }

    suspend fun get(id: FrameworkId): Framework {
        return frameworkFinderService.get(id)
    }
}
