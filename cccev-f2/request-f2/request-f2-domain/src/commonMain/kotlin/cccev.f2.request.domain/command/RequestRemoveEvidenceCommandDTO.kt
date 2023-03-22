package cccev.f2.request.domain.command

import cccev.s2.request.domain.command.RequestRemoveEvidenceCommand
import cccev.s2.request.domain.command.RequestRemovedEvidenceEvent
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Remove an evidence from a request.
 * @d2 function
 * @parent [cccev.f2.request.domain.D2RequestApiPage]
 * @child [cccev.s2.request.domain.command.RequestRemoveEvidenceCommandDTO]
 * @child [cccev.s2.request.domain.command.RequestRemovedEvidenceEventDTO]
 * @order 41
 */
typealias RequestRemoveEvidenceFunction = F2Function<RequestRemoveEvidenceCommand, RequestRemovedEvidenceEvent>

@JsExport
@JsName("RequestRemoveEvidenceCommandDTO")
interface RequestRemoveEvidenceCommandDTO: cccev.s2.request.domain.command.RequestRemoveEvidenceCommandDTO

@JsExport
@JsName("RequestRemovedEvidenceEventDTO")
interface RequestRemovedEvidenceEventDTO: cccev.s2.request.domain.command.RequestRemovedEvidenceEventDTO
