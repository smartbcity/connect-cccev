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
 * @parent [RequestSignCommandFunction]
 */
@JsExport
@JsName("RequestSignCommandDTO")
interface RequestSignCommandDTO: RequestCommand {
	/**
	 * The unique id of the request.
	 */
	override val id: RequestId
}

/**
 * Event sent when an supported Value has been add to a request.
 * @D2 event
 * @parent [RequestSignCommandFunction]
 */
@JsExport
@JsName("RequestSignedEventDto")
interface RequestSignedEventDTO: RequestEvent {
	/**
	 * The unique id of the request.
	 */
	override val id: RequestId

	/**
	 * The current state of the request.
	 * @example "Signed"
	 */
	override val type: RequestState.Signed
}

class RequestSignCommand(
	override val id: RequestId,
): RequestSignCommandDTO

class RequestSignedEvent(
	override val id: RequestId,
	override val type: RequestState.Signed = RequestState.Signed,
): RequestSignedEventDTO
