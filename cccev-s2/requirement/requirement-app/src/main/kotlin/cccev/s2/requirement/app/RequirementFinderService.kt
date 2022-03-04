package cccev.s2.requirement.app

import cccev.core.dsl.Requirement
import cccev.core.dsl.RequirementId
import org.springframework.stereotype.Service

@Service
class RequirementFinderService {
    companion object {
        val AVAILABLE_REQUIREMENTS = mutableMapOf<RequirementId, Requirement>() // will be removed when requirements are stored in db
    }

    fun get(id: RequirementId) = AVAILABLE_REQUIREMENTS[id]
}
