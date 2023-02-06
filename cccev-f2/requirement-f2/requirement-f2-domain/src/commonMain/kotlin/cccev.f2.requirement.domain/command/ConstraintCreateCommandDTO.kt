package cccev.f2.requirement.domain.command

import cccev.s2.requirement.domain.command.RequirementCreatedEvent
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

typealias ConstraintCreateFunction = F2Function<ConstraintCreateCommandDTOBase, RequirementCreatedEvent>

@JsExport
@JsName("ConstraintCreateCommandDTO")
interface ConstraintCreateCommandDTO {
    val name: String?
    val description: String?
    val type: String?
}

data class ConstraintCreateCommandDTOBase(
    override val name: String?,
    override val description: String?,
    override val type: String?
): ConstraintCreateCommandDTO

@JsExport
@JsName("ConstraintCreatedEventDTO")
interface ConstraintCreatedEventDTO: cccev.s2.requirement.domain.command.RequirementCreatedEventDTO
