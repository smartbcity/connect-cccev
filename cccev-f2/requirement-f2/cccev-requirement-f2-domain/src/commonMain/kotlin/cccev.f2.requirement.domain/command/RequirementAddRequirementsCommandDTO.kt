package cccev.f2.requirement.domain.command

import cccev.s2.requirement.domain.command.RequirementAddRequirementsCommand
import cccev.s2.requirement.domain.command.RequirementAddedRequirementsEvent
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

typealias RequirementAddRequirementsFunction = F2Function<RequirementAddRequirementsCommand, RequirementAddedRequirementsEvent>

@JsExport
@JsName("RequirementAddRequirementsCommandDTO")
interface RequirementAddRequirementsCommandDTO: cccev.s2.requirement.domain.command.RequirementAddRequirementsCommandDTO

@JsExport
@JsName("RequirementAddedRequirementsEventDTO")
interface RequirementAddedRequirementsEventDTO: cccev.s2.requirement.domain.command.RequirementAddedRequirementsEventDTO
