package cccev.f2.request.domain.command

import cccev.s2.request.domain.command.RequestAddEvidenceCommand
import cccev.s2.request.domain.command.RequestAddedEvidenceEvent
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Add an evidence to a request.
 * @d2 function
 * @parent [cccev.f2.request.domain.D2RequestApiPage]
 * @child [cccev.s2.request.domain.command.RequestAddEvidenceCommandDTO]
 * @child [cccev.s2.request.domain.command.RequestAddedEvidenceEventDTO]
 * @order 40
 */
typealias RequestAddEvidenceFunction = F2Function<RequestAddEvidenceCommand, RequestAddedEvidenceEvent>

@JsExport
@JsName("RequestAddEvidenceCommandDTO")
interface RequestAddEvidenceCommandDTO: cccev.s2.request.domain.command.RequestAddEvidenceCommandDTO

@JsExport
@JsName("RequestAddedEvidenceEventDTO")
interface RequestAddedEvidenceEventDTO: cccev.s2.request.domain.command.RequestAddedEvidenceEventDTO
