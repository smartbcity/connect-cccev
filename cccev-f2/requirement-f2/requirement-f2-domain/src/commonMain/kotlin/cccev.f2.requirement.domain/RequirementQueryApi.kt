package cccev.f2.requirement.domain

import cccev.f2.requirement.domain.query.RequirementGetByIdentifierFunction
import cccev.f2.requirement.domain.query.RequirementListQueryFunction
import cccev.f2.requirement.domain.query.RequirementGetFunction
import cccev.f2.requirement.domain.query.RequirementListChildrenByTypeFunction

interface RequirementQueryApi {
    /** Get requirement **/
    fun requirementGet(): RequirementGetFunction
    fun requirementGetByIdentifier(): RequirementGetByIdentifierFunction

    /** Get Requirement List **/
    fun requirementsList(): RequirementListQueryFunction
    /** List requirement children filtered by type **/
    fun requirementListChildrenByType(): RequirementListChildrenByTypeFunction
}
