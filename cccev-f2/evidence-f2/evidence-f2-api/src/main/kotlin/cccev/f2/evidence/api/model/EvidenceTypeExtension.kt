package cccev.f2.evidence.api.model

import cccev.dsl.model.Evidence
import cccev.dsl.model.EvidenceTypeBase
import cccev.dsl.model.EvidenceTypeId
import cccev.dsl.model.EvidenceTypeList
import cccev.dsl.model.EvidenceTypeListBase
import cccev.f2.evidence.domain.model.EvidenceTypeDTOBase
import cccev.f2.evidence.domain.model.EvidenceTypeListChoicesDTOBase
import cccev.f2.evidence.domain.model.EvidenceTypeListDTO
import cccev.f2.evidence.domain.model.EvidenceTypeListDTOBase

fun List<EvidenceTypeListBase>.toDTOs(evidences: List<Evidence>): List<EvidenceTypeListDTOBase> {
    val evidenceMap = evidences.associateBy { it.isConformantTo.first() }
    return map { it.toDTO(evidenceMap) }
}

fun EvidenceTypeListBase.toDTO(evidences: Map<EvidenceTypeId, Evidence?>) = EvidenceTypeListDTOBase(
    identifier = identifier,
    name = name,
    description = description,
    specifiesEvidenceType = specifiesEvidenceType.map { it.toDTO(evidences[it.identifier]) }
)

fun EvidenceTypeBase.toDTO(evidence: Evidence?) = EvidenceTypeDTOBase(
    identifier = identifier,
    name = name,
    evidenceTypeClassification = evidenceTypeClassification,
    validityPeriodConstraint = validityPeriodConstraint,
    issuingPlace = issuingPlace,
    evidence = evidence
)

fun List<EvidenceTypeListDTO>.toEvidenceTypeListChoices() = EvidenceTypeListChoicesDTOBase(
    evidenceTypeLists = map(EvidenceTypeList::identifier),
    isFilled = anyFilled()
)

fun List<EvidenceTypeListDTO>.anyFilled() = any(EvidenceTypeListDTO::isFilled)
fun EvidenceTypeListDTO.isFilled() = specifiesEvidenceType.all { it.evidence != null }
