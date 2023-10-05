package cccev.s2.framework.domain

import cccev.s2.framework.domain.model.Framework

interface FrameworkFinder {
    suspend fun getOrNull(id: FrameworkId): Framework?
    suspend fun getOrNullByIdentifier(id: FrameworkIdentifier): Framework?
    suspend fun get(id: FrameworkId): Framework
}
