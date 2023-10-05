package cccev.f2.requirement.domain.command

import cccev.s2.requirement.domain.command.RequirementUpdateCommand
import cccev.s2.requirement.domain.command.RequirementUpdatedEvent
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

typealias RequirementUpdateFunction = F2Function<RequirementUpdateCommand, RequirementUpdatedEvent>

@JsExport
@JsName("RequirementUpdateCommandDTO")
interface RequirementUpdateCommandDTO: cccev.s2.requirement.domain.command.RequirementUpdateCommandDTO

@JsExport
@JsName("RequirementUpdatedEventDTO")
interface RequirementUpdatedEventDTO: cccev.s2.requirement.domain.command.RequirementUpdatedEventDTO
