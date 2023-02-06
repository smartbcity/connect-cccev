package cccev.s2.requirement.domain

import cccev.s2.requirement.domain.model.Requirement

interface RequirementFinder {
    suspend fun getOrNull(id: RequirementId): Requirement?
    suspend fun get(id: RequirementId): Requirement
}
