package cccev.f2.requirement.api.model

import cccev.f2.concept.domain.model.InformationConceptDTOBase
import cccev.f2.evidence.type.domain.model.EvidenceTypeListDTOBase
import cccev.f2.requirement.domain.model.RequirementDTOBase
import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.evidence.domain.EvidenceTypeListId
import cccev.s2.requirement.domain.model.Requirement

suspend fun Requirement.toDTO(
    getConcept: suspend (InformationConceptId) -> InformationConceptDTOBase,
    getEvidenceTypeList: suspend (EvidenceTypeListId) -> EvidenceTypeListDTOBase
): RequirementDTOBase = RequirementDTOBase(
    id = id,
    identifier = identifier,
    kind = kind.name,
    description = description,
    type = type,
    name = name,
    hasRequirement = hasRequirement.map { it.toDTO(getConcept, getEvidenceTypeList) },
    hasConcept = hasConcept.map { getConcept(it) },
    hasEvidenceTypeList = hasEvidenceTypeList.map { getEvidenceTypeList(it) },
)
