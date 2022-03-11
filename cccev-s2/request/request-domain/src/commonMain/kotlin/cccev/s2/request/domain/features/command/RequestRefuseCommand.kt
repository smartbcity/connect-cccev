package cccev.s2.request.domain.features.command

import cccev.s2.request.domain.RequestCommand
import cccev.s2.request.domain.RequestEvent
import cccev.s2.request.domain.RequestState
import cccev.s2.request.domain.model.RequestId
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Command to add a supported Value to a request.
 * @D2 command
 * @parent [RequestRefuseCommandFunction]
 */
@JsExport
@JsName("RequestRefuseCommandDTO")
interface RequestRefuseCommandDTO: RequestCommand {
	/**
	 * The unique id of the request.
	 */
	override val id: RequestId
}

/**
 * Event sent when an supported Value has been add to a request.
 * @D2 event
 * @parent [RequestRefuseCommandFunction]
 */
@JsExport
@JsName("RequestRefusedEventDto")
interface RequestRefusedEventDTO: RequestEvent {
	/**
	 * The unique id of the request.
	 */
	override val id: RequestId

	/**
	 * The current state of the request.
	 * @example "Created"
	 */
	override val type: RequestState.Created
}

class RequestRefuseCommand(
	override val id: RequestId,
): RequestRefuseCommandDTO

class RequestRefusedEvent(
	override val id: RequestId,
	override val type: RequestState.Created = RequestState.Created,
): RequestRefusedEventDTO
