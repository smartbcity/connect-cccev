package cccev.s2.requirement.domain

import cccev.dsl.model.EvidenceTypeId
import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.requirement.domain.model.Requirement
import kotlinx.coroutines.flow.Flow

interface RequirementFinder {
    suspend fun getOrNull(id: RequirementId): Requirement?
    suspend fun get(id: RequirementId): Requirement
    suspend fun listByIdWithChildrenOfType(ids: List<RequirementId>, type: String): List<Requirement>
    suspend fun list(
        isRequirementOf: RequirementId? = null,
        concept: InformationConceptId? = null,
        evidenceType: EvidenceTypeId? = null
    ): Flow<Requirement>
}
