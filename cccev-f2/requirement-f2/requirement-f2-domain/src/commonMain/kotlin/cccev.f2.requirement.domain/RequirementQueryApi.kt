package cccev.f2.requirement.domain

import cccev.f2.requirement.domain.query.GetRequirementListQueryFunction
import cccev.f2.requirement.domain.query.GetRequirementQueryFunction
import cccev.f2.requirement.domain.query.RequirementGetFunction

interface RequirementQueryApi {
    /** Get requirement */
    fun requirementGet(): RequirementGetFunction

    @Deprecated("Use requirementGet instead")
    /** Get Requirement (deprecated) */
    fun getRequirement(): GetRequirementQueryFunction

    /** Get Requirement List (deprecated) */
    fun requirementsList(): GetRequirementListQueryFunction
}
