package cccev.f2.requirement.domain.command

import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.evidence.domain.EvidenceTypeListId
import cccev.s2.requirement.domain.RequirementId
import cccev.s2.requirement.domain.command.RequirementCreatedEvent
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

typealias InformationRequirementCreateFunction = F2Function<InformationRequirementCreateCommandDTOBase, RequirementCreatedEvent>

@JsExport
@JsName("InformationRequirementCreateCommandDTO")
interface InformationRequirementCreateCommandDTO {
    val name: String?
    val description: String?
    val hasRequirement: List<RequirementId>
    val hasConcept: List<InformationConceptId>
    val hasEvidenceTypeList: List<EvidenceTypeListId>
}

data class InformationRequirementCreateCommandDTOBase(
    override val name: String?,
    override val description: String?,
    override val hasRequirement: List<RequirementId>,
    override val hasConcept: List<InformationConceptId>,
    override val hasEvidenceTypeList: List<EvidenceTypeListId>,
): InformationRequirementCreateCommandDTO

@JsExport
@JsName("InformationRequirementCreatedEventDTO")
interface InformationRequirementCreatedEventDTO: cccev.s2.requirement.domain.command.RequirementCreatedEventDTO
