package cccev.f2.request.domain.command

import cccev.s2.request.domain.command.RequestCreateCommand
import cccev.s2.request.domain.command.RequestCreatedEvent
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Create a request.
 * @d2 function
 * @parent [cccev.f2.request.domain.D2RequestApiPage]
 * @child [cccev.s2.request.domain.command.RequestCreateCommandDTO]
 * @child [cccev.s2.request.domain.command.RequestCreatedEventDTO]
 * @order 10
 */
typealias RequestCreateFunction = F2Function<RequestCreateCommand, RequestCreatedEvent>

@JsExport
@JsName("RequestCreateCommandDTO")
interface RequestCreateCommandDTO: cccev.s2.request.domain.command.RequestCreateCommandDTO

@JsExport
@JsName("RequestCreatedEventDTO")
interface RequestCreatedEventDTO: cccev.s2.request.domain.command.RequestCreatedEventDTO
