package cccev.f2.evidence.type.api.model

import cccev.f2.evidence.type.domain.model.EvidenceTypeDTOBase
import cccev.s2.evidence.domain.model.EvidenceType

fun EvidenceType.toDTO() = EvidenceTypeDTOBase(
    id = id,
    name = name,
    description = description,
    validityPeriodConstraint = validityPeriodConstraint,
)
