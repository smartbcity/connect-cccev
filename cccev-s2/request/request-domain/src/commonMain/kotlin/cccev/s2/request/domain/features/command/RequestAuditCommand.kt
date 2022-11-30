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
 */
@JsExport
@JsName("RequestAuditCommandDTO")
interface RequestAuditCommandDTO: RequestCommand {
	override val id: RequestId
}

/**
 * Event sent when a supported Value has been added to a request.
 * @D2 event
 */
@JsExport
@JsName("RequestAuditedEventDTO")
interface RequestAuditedEventDTO: RequestEvent {
	override val id: RequestId

	/**
	 * The current state of the request.
	 * @example "Audited"
	 */
	override val type: RequestState.Audited
}

/**
 * @d2 inherit
 */
class RequestAuditCommand(
	override val id: RequestId,
): RequestAuditCommandDTO

/**
 * @d2 inherit
 */
class RequestAuditedEvent(
	override val id: RequestId,
	override val type: RequestState.Audited = RequestState.Audited,
): RequestAuditedEventDTO
