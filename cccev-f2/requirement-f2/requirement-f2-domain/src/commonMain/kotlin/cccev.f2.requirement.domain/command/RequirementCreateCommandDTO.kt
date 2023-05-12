package cccev.f2.requirement.domain.command

import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.evidence.domain.EvidenceTypeListId
import cccev.s2.framework.domain.FrameworkId
import cccev.s2.requirement.domain.RequirementId
import cccev.s2.requirement.domain.command.RequirementCreatedEvent
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

typealias RequirementCreateFunction = F2Function<RequirementCreateCommandDTOBase, RequirementCreatedEvent>

@JsExport
@JsName("RequirementCreateCommandDTO")
interface RequirementCreateCommandDTO {
    val identifier: String?
    val kind: String
    val name: String?
    val description: String?
    val type: String?
    val isDerivedFrom: List<FrameworkId>
    val hasConcept: List<InformationConceptId>
    val hasEvidenceTypeList: List<EvidenceTypeListId>
    val hasRequirement: List<RequirementId>
    var hasQualifiedRelation: Map<String, List<RequirementId>>
}

@Serializable
data class RequirementCreateCommandDTOBase(
    override val identifier: String? = null,
    override val kind: String,
    override val name: String? = null,
    override val description: String? = null,
    override val type: String? = null,
    override val isDerivedFrom: List<FrameworkId> = emptyList(),
    override val hasRequirement: List<RequirementId> = emptyList(),
    override val hasConcept: List<InformationConceptId> = emptyList(),
    override val hasEvidenceTypeList: List<EvidenceTypeListId> = emptyList(),
    override var hasQualifiedRelation: Map<String, List<RequirementId>> = emptyMap()
): RequirementCreateCommandDTO

@JsExport
@JsName("RequirementCreatedEventDTO")
interface RequirementCreatedEventDTO: cccev.s2.requirement.domain.command.RequirementCreatedEventDTO
