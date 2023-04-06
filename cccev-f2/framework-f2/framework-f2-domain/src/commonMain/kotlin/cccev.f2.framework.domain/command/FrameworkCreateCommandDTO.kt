package cccev.f2.framework.domain.command

import cccev.s2.framework.domain.command.FrameworkCreateCommand
import cccev.s2.framework.domain.command.FrameworkCreatedEvent
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

typealias FrameworkCreateFunction = F2Function<FrameworkCreateCommand, FrameworkCreatedEvent>

@JsExport
@JsName("FrameworkCreateCommandDTO")
interface FrameworkCreateCommandDTO: cccev.s2.framework.domain.command.FrameworkCreateCommandDTO

@JsExport
@JsName("FrameworkCreatedEventDTO")
interface FrameworkCreatedEventDTO: cccev.s2.framework.domain.command.FrameworkCreatedEventDTO
