package cccev.f2.evidence.api.app.model

import cccev.core.dsl.Evidence
import cccev.core.dsl.EvidenceTypeBase
import cccev.core.dsl.EvidenceTypeId
import cccev.core.dsl.EvidenceTypeListBase
import cccev.f2.evidence.api.domain.model.EvidenceTypeDTOBase
import cccev.f2.evidence.api.domain.model.EvidenceTypeListDTOBase

fun EvidenceTypeListBase.toDTO(evidences: Map<EvidenceTypeId, Evidence?>) = EvidenceTypeListDTOBase(
    identifier = identifier,
    name = name,
    description = description,
    specifiesEvidenceType = specifiesEvidenceType.map { it.toDTO(evidences) }
)

fun EvidenceTypeBase.toDTO(evidences: Map<EvidenceTypeId, Evidence?>) = EvidenceTypeDTOBase(
    identifier = identifier,
    name = name,
    evidenceTypeClassification = evidenceTypeClassification,
    validityPeriodConstraint = validityPeriodConstraint,
    issuingPlace = issuingPlace,
    evidence = evidences[identifier]
)
