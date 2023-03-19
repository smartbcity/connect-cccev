package cccev.s2.request.domain.features.command

import cccev.s2.request.domain.RequestCommand
import cccev.s2.request.domain.RequestEvent
import cccev.s2.request.domain.RequestState
import cccev.s2.request.domain.model.RequestId
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable


@JsExport
@JsName("RequestSignCommandDTO")
interface RequestSignCommandDTO: RequestCommand {
	override val id: RequestId
}


@JsExport
@JsName("RequestSignedEventDto")
interface RequestSignedEventDTO: RequestEvent {
	override val id: RequestId
	override val type: RequestState
}

/**
 * Event sent when a supported Value a has been added to a request.
 * @D2 event
 */
@Serializable
class RequestSignCommand(
	override val id: RequestId,
): RequestSignCommandDTO

/**
 * Command to add a supported Value to a request.
 * @D2 command
 */
@Serializable
class RequestSignedEvent(
	override val id: RequestId,
	/**
	 * The current state of the request.
	 * @example "Signed"
	 */
	override val type: RequestState = RequestState.SIGNED,
): RequestSignedEventDTO
