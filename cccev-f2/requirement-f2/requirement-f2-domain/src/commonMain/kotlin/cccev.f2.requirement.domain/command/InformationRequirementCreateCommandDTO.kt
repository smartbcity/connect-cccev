package cccev.f2.requirement.domain.command

import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.evidence.domain.EvidenceTypeListId
import cccev.s2.framework.domain.FrameworkId
import cccev.s2.requirement.domain.RequirementId
import cccev.s2.requirement.domain.command.RequirementCreatedEvent
import cccev.s2.requirement.domain.model.RequirementKind
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

typealias InformationRequirementCreateFunction = F2Function<InformationRequirementCreateCommandDTOBase, RequirementCreatedEvent>

@JsExport
@JsName("InformationRequirementCreateCommandDTO")
interface InformationRequirementCreateCommandDTO: RequirementCreateCommandDTO

@Serializable
data class InformationRequirementCreateCommandDTOBase(
    override val identifier: String?,
    override val name: String?,
    override val description: String?,
    override val type: String?,
    override val isDerivedFrom: List<FrameworkId>,
    override val hasRequirement: List<RequirementId>,
    override val hasConcept: List<InformationConceptId>,
    override val hasEvidenceTypeList: List<EvidenceTypeListId>,
    override var hasQualifiedRelation: Map<String, List<RequirementId>>,
): InformationRequirementCreateCommandDTO{
    override val kind: String = RequirementKind.INFORMATION.name
}

@JsExport
@JsName("InformationRequirementCreatedEventDTO")
interface InformationRequirementCreatedEventDTO: cccev.s2.requirement.domain.command.RequirementCreatedEventDTO
