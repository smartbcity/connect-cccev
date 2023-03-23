package cccev.f2.requirement.domain.command

import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.evidence.domain.EvidenceTypeListId
import cccev.s2.requirement.domain.RequirementId
import cccev.s2.requirement.domain.command.RequirementCreatedEvent
import f2.dsl.fnc.F2Function
import kotlinx.serialization.Serializable
import kotlin.js.JsExport
import kotlin.js.JsName

typealias RequirementCreateFunction = F2Function<RequirementCreateCommandDTOBase, RequirementCreatedEvent>

@JsExport
@JsName("RequirementCreateCommandDTO")
interface RequirementCreateCommandDTO {
    val identifier: String?
    val kind: String
    val name: String?
    val description: String?
    val type: String?
    val hasConcept: List<InformationConceptId>
    val hasEvidenceTypeList: List<EvidenceTypeListId>
    val hasRequirement: List<RequirementId>
    var hasQualifiedRelation: List<RequirementId>?
}

@Serializable
data class RequirementCreateCommandDTOBase(
    override val identifier: String?,
    override val kind: String,
    override val name: String?,
    override val description: String?,
    override val type: String?,
    override val hasRequirement: List<RequirementId>,
    override val hasConcept: List<InformationConceptId>,
    override val hasEvidenceTypeList: List<EvidenceTypeListId>,
    override var hasQualifiedRelation: List<RequirementId>?
): RequirementCreateCommandDTO

@JsExport
@JsName("RequirementCreatedEventDTO")
interface RequirementCreatedEventDTO: cccev.s2.requirement.domain.command.RequirementCreatedEventDTO
