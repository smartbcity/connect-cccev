package cccev.f2.requirement.api.model

import cccev.f2.concept.domain.model.InformationConceptDTOBase
import cccev.f2.evidence.type.domain.model.EvidenceTypeListDTOBase
import cccev.f2.requirement.domain.model.RequirementDTOBase
import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.evidence.domain.EvidenceTypeListId
import cccev.s2.requirement.domain.RequirementId
import cccev.s2.requirement.domain.model.Requirement

suspend fun Requirement.toDTO(
    getConcept: suspend (InformationConceptId) -> InformationConceptDTOBase,
    getEvidenceTypeList: suspend (EvidenceTypeListId) -> EvidenceTypeListDTOBase,
    getRequirement: suspend (RequirementId) -> RequirementDTOBase
) = RequirementDTOBase(
    id = id,
    kind = kind.name,
    description = description,
    name = name,
    hasRequirement = hasRequirement.map { getRequirement(it) },
    hasConcept = hasConcept.map { getConcept(it) },
    hasEvidenceTypeList = hasEvidenceTypeList.map { getEvidenceTypeList(it) },
)
