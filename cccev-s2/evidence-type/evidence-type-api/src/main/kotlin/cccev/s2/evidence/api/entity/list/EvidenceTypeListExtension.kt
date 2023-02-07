package cccev.s2.evidence.api.entity.list

import cccev.s2.evidence.domain.model.EvidenceType
import cccev.s2.evidence.domain.model.EvidenceTypeList

fun EvidenceTypeListEntity.toEvidenceTypeList(
    evidenceTypes: List<EvidenceType>
) = EvidenceTypeList(
    id = id,
    name = name,
    description = description,
    specifiesEvidenceType = evidenceTypes
)
