package cccev.f2.requirement.domain

import cccev.f2.requirement.domain.query.GetRequirementListQueryFunction
import cccev.f2.requirement.domain.query.GetRequirementQueryFunction

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
