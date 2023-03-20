package cccev.s2.request.domain.features.command

import cccev.s2.request.domain.RequestCommand
import cccev.s2.request.domain.RequestEvent
import cccev.s2.request.domain.RequestState
import cccev.s2.request.domain.model.RequestId
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

@JsExport
@JsName("RequestRefuseCommandDTO")
interface RequestRefuseCommandDTO: RequestCommand {
	/**
	 * The unique id of the request.
	 */
	override val id: RequestId
}


@JsExport
@JsName("RequestRefusedEventDto")
interface RequestRefusedEventDTO: RequestEvent {
	override val id: RequestId
	override val type: RequestState
}

/**
 * Command to add a supported Value to a request.
 * @D2 command
 */
@Serializable
class RequestRefuseCommand(
	override val id: RequestId,
): RequestRefuseCommandDTO

/**
 * Event sent when a supported Value a has been added to a request.
 * @D2 event
 */
@Serializable
class RequestRefusedEvent(
	override val id: RequestId,
	/**
	 * The current state of the request.
	 * @example "Created"
	 */
	override val type: RequestState = RequestState.CREATED,
): RequestRefusedEventDTO
