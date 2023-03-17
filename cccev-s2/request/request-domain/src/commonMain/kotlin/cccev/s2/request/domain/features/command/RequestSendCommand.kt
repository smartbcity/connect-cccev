package cccev.s2.request.domain.features.command

import cccev.s2.request.domain.RequestCommand
import cccev.s2.request.domain.RequestEvent
import cccev.s2.request.domain.RequestState
import cccev.s2.request.domain.model.RequestId
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

@JsExport
@JsName("RequestSendCommandDTO")
interface RequestSendCommandDTO: RequestCommand {
	override val id: RequestId
}


@JsExport
@JsName("RequestSentEventDto")
interface RequestSentEventDTO: RequestEvent {
	override val id: RequestId
	override val type: RequestState.Sent
}

/**
 * Command to add a supported Value to a request.
 * @D2 command
 */
@Serializable
class RequestSendCommand(
	override val id: RequestId,
): RequestSendCommandDTO

/**
 * Event sent when a supported Value a has been added to a request.
 * @D2 event
 */
@Serializable
class RequestSentEvent(
	override val id: RequestId,
	/**
	 * The current state of the request.
	 * @example "Sent"
	 */
	override val type: RequestState.Sent = RequestState.Sent,
): RequestSentEventDTO
