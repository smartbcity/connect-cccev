package cccev.s2.requirement.api.entity

import cccev.s2.requirement.domain.model.Requirement

fun RequirementEntity.toRequirement() = Requirement(
    id = id,
    kind = kind,
    description = description,
    name = name,
    type = type,
    hasRequirement = hasRequirement,
    hasConcept = hasConcept,
    hasEvidenceTypeList = hasEvidenceTypeList,
)
