package cccev.f2.request.domain.command

import cccev.s2.request.domain.command.RequestAddRequirementsCommand
import cccev.s2.request.domain.command.RequestAddedRequirementsEvent
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Add requirements to fulfill in a request.
 * @d2 function
 * @parent [cccev.f2.request.domain.D2RequestApiPage]
 * @child [cccev.s2.request.domain.command.RequestAddRequirementsCommandDTO]
 * @child [cccev.s2.request.domain.command.RequestAddedRequirementsEventDTO]
 * @order 20
 */
typealias RequestAddRequirementsFunction = F2Function<RequestAddRequirementsCommand, RequestAddedRequirementsEvent>

@JsExport
@JsName("RequestAddRequirementsCommandDTO")
interface RequestAddRequirementsCommandDTO: cccev.s2.request.domain.command.RequestAddRequirementsCommandDTO

@JsExport
@JsName("RequestAddedRequirementsEventDTO")
interface RequestAddedRequirementsEventDTO: cccev.s2.request.domain.command.RequestAddedRequirementsEventDTO
