package cccev.s2.request.domain.features.command

import cccev.core.dsl.EvidenceTypeId
import cccev.s2.request.domain.RequestCommand
import cccev.s2.request.domain.RequestEvent
import cccev.s2.request.domain.RequestState
import cccev.s2.request.domain.model.RequestId
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Command to remove an evidence from a request.
 * @D2 command
 * @parent [RequestEvidenceRemoveCommandFunction]
 */
@JsExport
@JsName("RequestEvidenceRemoveCommandDTO")
interface RequestEvidenceRemoveCommandDTO: RequestCommand {
	/**
	 * The unique id of the request.
	 */
	override val id: RequestId

	/**
	 * Identifier of the evidence type to remove.
	 */
	val evidenceTypeId: EvidenceTypeId
}

/**
 * Event sent when an evidence has been added to a request.
 * @D2 event
 * @parent [RequestEvidenceRemoveCommandFunction]
 */
@JsExport
@JsName("RequestEvidenceRemovedEventDTO")
interface RequestEvidenceRemovedEventDTO: RequestEvent {
	/**
	 * The unique id of the request.
	 */
	override val id: RequestId

	/**
	 * The current state of the request.
	 * @example "Created"
	 */
	override val type: RequestState.Created

	/**
	 * Identifier of the removed evidence type.
	 */
	val evidenceTypeId: EvidenceTypeId
}

class RequestEvidenceRemoveCommand(
	override val id: RequestId,
	override val evidenceTypeId: EvidenceTypeId,
): RequestEvidenceRemoveCommandDTO

class RequestEvidenceRemovedEvent(
	override val id: RequestId,
	override val type: RequestState.Created = RequestState.Created,
	override val evidenceTypeId: EvidenceTypeId,
): RequestEvidenceRemovedEventDTO
