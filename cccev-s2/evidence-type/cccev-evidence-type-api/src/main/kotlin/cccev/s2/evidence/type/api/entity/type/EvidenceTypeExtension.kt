package cccev.s2.evidence.type.api.entity.type

import cccev.projection.api.entity.evidencetype.EvidenceTypeEntity
import cccev.s2.evidence.type.domain.model.EvidenceType

fun EvidenceTypeEntity.toEvidenceType() = EvidenceType(
    id = id,
    identifier = identifier,
    name = name,
    description = description,
    validityPeriodConstraint = validityPeriodConstraint
)
