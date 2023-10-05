package cccev.f2.evidence.type.api.model

import cccev.f2.evidence.type.domain.model.EvidenceTypeListDTOBase
import cccev.s2.evidence.type.domain.model.EvidenceType
import cccev.s2.evidence.type.domain.model.EvidenceTypeList

fun EvidenceTypeList.toDTO() = EvidenceTypeListDTOBase(
    id = id,
    name = name,
    description = description,
    specifiesEvidenceType = specifiesEvidenceType.map(cccev.s2.evidence.type.domain.model.EvidenceType::toDTO),
)
