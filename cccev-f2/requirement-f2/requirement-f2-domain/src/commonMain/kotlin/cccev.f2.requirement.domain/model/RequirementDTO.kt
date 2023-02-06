package cccev.f2.requirement.domain.model

import cccev.core.dsl.EvidenceTypeList
import cccev.core.dsl.InformationConcept
import cccev.s2.requirement.domain.RequirementId
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
@JsName("RequirementDTO")
interface RequirementDTO {
    val id: RequirementId
    val kind: String
    val description: String?
    val name: String?
    val type: String?
    val hasRequirement: List<RequirementDTO>
    val hasConcept: List<InformationConcept>
    val hasEvidenceTypeList: List<EvidenceTypeList>
}

data class RequirementDTOBase(
    override val id: RequirementId,
    override val kind: String,
    override val description: String?,
    override val name: String?,
    override val type: String?,
    override val hasRequirement: List<RequirementDTOBase>,
    override val hasConcept: List<InformationConcept>,
    override val hasEvidenceTypeList: List<EvidenceTypeList>
): RequirementDTO
