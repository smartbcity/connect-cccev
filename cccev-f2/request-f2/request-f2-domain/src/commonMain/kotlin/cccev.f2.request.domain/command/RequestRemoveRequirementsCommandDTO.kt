package cccev.f2.request.domain.command

import cccev.s2.request.domain.command.RequestRemoveRequirementsCommand
import cccev.s2.request.domain.command.RequestRemovedRequirementsEvent
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Remove requirements to fulfill from a request.
 * @d2 function
 * @parent [cccev.f2.request.domain.D2RequestApiPage]
 * @child [cccev.s2.request.domain.command.RequestRemoveRequirementsCommandDTO]
 * @child [cccev.s2.request.domain.command.RequestRemovedRequirementsEventDTO]
 * @order 21
 */
typealias RequestRemoveRequirementsFunction = F2Function<RequestRemoveRequirementsCommand, RequestRemovedRequirementsEvent>

@JsExport
@JsName("RequestRemoveRequirementsCommandDTO")
interface RequestRemoveRequirementsCommandDTO: cccev.s2.request.domain.command.RequestRemoveRequirementsCommandDTO

@JsExport
@JsName("RequestRemovedRequirementsEventDTO")
interface RequestRemovedRequirementsEventDTO: cccev.s2.request.domain.command.RequestRemovedRequirementsEventDTO
