package cccev.f2.requirement.domain.model

import cccev.f2.concept.domain.model.InformationConceptDTO
import cccev.f2.concept.domain.model.InformationConceptDTOBase
import cccev.f2.evidence.type.domain.model.EvidenceTypeListDTO
import cccev.f2.evidence.type.domain.model.EvidenceTypeListDTOBase
import cccev.s2.requirement.domain.RequirementId
import kotlinx.serialization.Serializable
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
@JsName("RequirementDTO")
interface RequirementDTO {
    val id: RequirementId
    val identifier: String?
    val kind: String
    val description: String?
    val type: String?
    val name: String?
    val hasRequirement: List<RequirementDTO>
    val hasQualifiedRelation: Map<String, List<RequirementId>>
    val hasConcept: List<InformationConceptDTO>
    val hasEvidenceTypeList: List<EvidenceTypeListDTO>
}

@Serializable
data class RequirementDTOBase(
    override val id: RequirementId,
    override val identifier: String?,
    override val kind: String,
    override val description: String?,
    override val type: String?,
    override val name: String?,
    override val hasRequirement: List<RequirementDTOBase>,
    override val hasQualifiedRelation: Map<String, List<RequirementId>>,
    override val hasConcept: List<InformationConceptDTOBase>,
    override val hasEvidenceTypeList: List<EvidenceTypeListDTOBase>
): RequirementDTO
