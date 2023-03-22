package cccev.f2.request.domain.command

import cccev.s2.request.domain.command.RequestAddValuesCommand
import cccev.s2.request.domain.command.RequestAddedValuesEvent
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Provide data for the information concepts specified in the requirements a request has to fulfill.
 * @d2 function
 * @parent [cccev.f2.request.domain.D2RequestApiPage]
 * @child [cccev.s2.request.domain.command.RequestAddValuesCommandDTO]
 * @child [cccev.s2.request.domain.command.RequestAddedValuesEventDTO]
 * @order 30
 */
typealias RequestAddValuesFunction = F2Function<RequestAddValuesCommand, RequestAddedValuesEvent>

@JsExport
@JsName("RequestAddValuesCommandDTO")
interface RequestAddValuesCommandDTO: cccev.s2.request.domain.command.RequestAddValuesCommandDTO

@JsExport
@JsName("RequestAddedValuesEventDTO")
interface RequestAddedValuesEventDTO: cccev.s2.request.domain.command.RequestAddedValuesEventDTO
