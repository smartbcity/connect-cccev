package cccev.f2.requirement.domain.command

import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.evidence.domain.EvidenceTypeListId
import cccev.s2.requirement.domain.RequirementId
import cccev.s2.requirement.domain.command.RequirementCreatedEvent
import cccev.s2.requirement.domain.model.RequirementKind
import f2.dsl.fnc.F2Function
import kotlinx.serialization.Serializable
import kotlin.js.JsExport
import kotlin.js.JsName

typealias ConstraintCreateFunction = F2Function<ConstraintCreateCommandDTOBase, RequirementCreatedEvent>

@JsExport
@JsName("ConstraintCreateCommandDTO")
interface ConstraintCreateCommandDTO: RequirementCreateCommandDTO

@Serializable
data class ConstraintCreateCommandDTOBase(
    override val identifier: String?,
    override val name: String?,
    override val description: String?,
    override val hasRequirement: List<RequirementId>,
    override val hasConcept: List<InformationConceptId>,
    override val hasEvidenceTypeList: List<EvidenceTypeListId>,
    override var hasQualifiedRelation: List<RequirementId>?
): ConstraintCreateCommandDTO {
    override val kind: String = RequirementKind.CONSTRAINT.name
}

@JsExport
@JsName("ConstraintCreatedEventDTO")
interface ConstraintCreatedEventDTO: cccev.s2.requirement.domain.command.RequirementCreatedEventDTO
