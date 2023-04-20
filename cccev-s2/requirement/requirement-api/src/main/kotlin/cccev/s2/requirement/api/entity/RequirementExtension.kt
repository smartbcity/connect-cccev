package cccev.s2.requirement.api.entity

import cccev.projection.api.entity.Relation
import cccev.projection.api.entity.requirement.RequirementEntity
import cccev.s2.requirement.domain.model.Requirement

fun RequirementEntity.toRequirement(): Requirement {
    val children = hasQualifiedRelation[Relation.HAS_REQUIREMENT].orEmpty()
    val relatedRequirements = hasQualifiedRelation.filterKeys { it != Relation.HAS_REQUIREMENT }

    return Requirement(
        id = id,
        identifier = identifier,
        kind = kind,
        description = description,
        type = type,
        name = name,
        isDerivedFrom = isDerivedFrom.map { it.id },
        hasRequirement = children.map(RequirementEntity::toRequirement),
        hasConcept = hasConcept.map { it.id },
        hasEvidenceTypeList = hasEvidenceTypeList.map { it.id },
        isRequirementOf = emptyList(),
        hasQualifiedRelation = relatedRequirements.mapValues { (_, requirement) -> requirement.map { it.id } },
        state = status
    )
}
