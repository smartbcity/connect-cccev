package cccev.s2.requirement.domain.model

import cccev.core.dsl.EvidenceTypeListId
import cccev.core.dsl.InformationConceptId
import cccev.s2.requirement.domain.RequirementId

data class Requirement(
    val id: RequirementId,
    val kind: RequirementKind,
    val description: String?,
    val name: String?,
    val type: String?,
    val hasRequirement: List<RequirementId>,
    val hasConcept: List<InformationConceptId>,
    val hasEvidenceTypeList: List<EvidenceTypeListId>
)
