package cccev.s2.requirement.api.entity

import cccev.s2.requirement.domain.model.Requirement

fun RequirementEntity.toRequirement() = Requirement(
    id = id,
    identifier = identifier,
    kind = kind,
    description = description,
    name = name,
    hasRequirement = hasRequirement,
    hasConcept = hasConcept,
    hasEvidenceTypeList = hasEvidenceTypeList,
    isRequirementOf = isRequirementOf,
    hasQualifiedRelation = hasQualifiedRelation
)
