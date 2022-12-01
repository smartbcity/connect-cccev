package cccev.f2.requirement.api.domain

import cccev.f2.requirement.api.domain.features.query.GetRequirementListQueryFunction
import cccev.f2.requirement.api.domain.features.query.GetRequirementQueryFunction

interface RequirementQueryApi {
    /**
     * Get Requirement
     */
    fun getRequirement(): GetRequirementQueryFunction
    /**
     * Get Requirement List
     */
    fun getRequirements(): GetRequirementListQueryFunction
}