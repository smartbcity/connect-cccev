package cccev.f2.evidence.type.api.model

import cccev.f2.evidence.type.domain.model.EvidenceTypeListDTOBase
import cccev.s2.evidence.domain.model.EvidenceType
import cccev.s2.evidence.domain.model.EvidenceTypeList

fun EvidenceTypeList.toDTO() = EvidenceTypeListDTOBase(
    id = id,
    name = name,
    description = description,
    specifiesEvidenceType = specifiesEvidenceType.map(EvidenceType::toDTO),
)
