package cccev.s2.requirement.api.entity

import cccev.projection.api.entity.requirement.RequirementEntity
import cccev.s2.requirement.domain.model.Requirement

fun RequirementEntity.toRequirement(): Requirement = Requirement(
    id = id,
    identifier = identifier,
    kind = kind,
    description = description,
    type = type,
    name = name,
    isDerivedFrom = isDerivedFrom.map { it.id },
    hasRequirement = hasRequirement.map(RequirementEntity::toRequirement),
    hasConcept = hasConcept.map { it.id },
    hasEvidenceTypeList = hasEvidenceTypeList.map { it.id },
    isRequirementOf = emptyList(),
    hasQualifiedRelation = hasQualifiedRelation.mapValues { (_, requirement) -> requirement.map { it.id } },
    state = status
)
