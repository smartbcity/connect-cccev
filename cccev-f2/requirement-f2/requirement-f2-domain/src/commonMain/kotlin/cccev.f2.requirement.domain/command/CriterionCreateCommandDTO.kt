package cccev.f2.requirement.domain.command

import cccev.s2.requirement.domain.command.RequirementCreatedEvent
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

typealias CriterionCreateFunction = F2Function<CriterionCreateCommandDTOBase, RequirementCreatedEvent>

@JsExport
@JsName("CriterionCreateCommandDTO")
interface CriterionCreateCommandDTO {
    val name: String?
    val description: String?
    val type: String?
}

data class CriterionCreateCommandDTOBase(
    override val name: String?,
    override val description: String?,
    override val type: String?
): CriterionCreateCommandDTO

@JsExport
@JsName("CriterionCreatedEventDTO")
interface CriterionCreatedEventDTO: cccev.s2.requirement.domain.command.RequirementCreatedEventDTO
