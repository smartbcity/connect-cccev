package cccev.s2.requirement.domain

import cccev.s2.requirement.domain.model.Requirement
import cccev.s2.requirement.domain.model.RequirementIdentifier

interface RequirementFinder {
    suspend fun getOrNull(id: RequirementId): Requirement?
    suspend fun get(id: RequirementId): Requirement
    suspend fun getByIdentifierOrNull(identifier: RequirementIdentifier): Requirement?
    suspend fun getByIdentifier(identifier: RequirementIdentifier): Requirement
}
