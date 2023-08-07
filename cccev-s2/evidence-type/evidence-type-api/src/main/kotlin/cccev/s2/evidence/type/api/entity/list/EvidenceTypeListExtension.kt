package cccev.s2.evidence.type.api.entity.list

import cccev.projection.api.entity.evidencetype.EvidenceTypeEntity
import cccev.projection.api.entity.evidencetypelist.EvidenceTypeListEntity
import cccev.s2.evidence.type.api.entity.type.toEvidenceType
import cccev.s2.evidence.type.domain.model.EvidenceTypeList

fun EvidenceTypeListEntity.toEvidenceTypeList() = EvidenceTypeList(
    id = id,
    name = name,
    description = description,
    specifiesEvidenceType = specifiesEvidenceType.map(EvidenceTypeEntity::toEvidenceType)
)
