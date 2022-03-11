package cccev.s2.request.domain.features.command

import cccev.s2.request.domain.RequestCommand
import cccev.s2.request.domain.RequestEvent
import cccev.s2.request.domain.RequestState
import cccev.s2.request.domain.model.RequestId
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Command to add an supported Value to a request.
 * @D2 command
 * @parent [RequestSendCommandFunction]
 */
@JsExport
@JsName("RequestSendCommandDTO")
interface RequestSendCommandDTO: RequestCommand {
	/**
	 * The unique id of the request.
	 */
	override val id: RequestId
}

/**
 * Event sent when an supported Value has been add to a request.
 * @D2 event
 * @parent [RequestSendCommandFunction]
 */
@JsExport
@JsName("RequestSentEventDto")
interface RequestSentEventDTO: RequestEvent {
	/**
	 * The unique id of the request.
	 */
	override val id: RequestId

	/**
	 * The current state of the request.
	 * @example "Sent"
	 */
	override val type: RequestState.Sent
}

class RequestSendCommand(
	override val id: RequestId,
): RequestSendCommandDTO

class RequestSentEvent(
	override val id: RequestId,
	override val type: RequestState.Sent = RequestState.Sent,
): RequestSentEventDTO
