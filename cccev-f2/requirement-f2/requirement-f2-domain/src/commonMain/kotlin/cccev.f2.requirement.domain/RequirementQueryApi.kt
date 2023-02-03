package cccev.f2.requirement.domain

import cccev.f2.requirement.domain.features.query.GetRequirementListQueryFunction
import cccev.f2.requirement.domain.features.query.GetRequirementQueryFunction

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
