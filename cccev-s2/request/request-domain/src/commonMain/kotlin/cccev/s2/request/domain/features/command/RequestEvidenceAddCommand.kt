package cccev.s2.request.domain.features.command

import cccev.dsl.model.Evidence
import cccev.dsl.model.EvidenceDTO
import cccev.dsl.model.EvidenceId
import cccev.s2.request.domain.RequestCommand
import cccev.s2.request.domain.RequestEvent
import cccev.s2.request.domain.RequestState
import cccev.s2.request.domain.model.RequestId
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

/**
 * Command to add an evidence to a request.
 * @d2 command
 */
@JsExport
@JsName("RequestEvidenceAddCommandDTO")
interface RequestEvidenceAddCommandDTO: RequestCommand {
	override val id: RequestId
	/**
	 * The evidence to add.
	 */
	val evidence: EvidenceDTO
}

/**
 * Event sent when an evidence has been added to a request.
 * @d2 event
 */
@JsExport
@JsName("RequestEvidenceAddedEventDTO")
interface RequestEvidenceAddedEventDTO: RequestEvent {
	override val id: RequestId
	/**
	 * The current state of the request.
	 * @example "Created"
	 */
	override val type: RequestState
	val evidence: EvidenceDTO
}

/**
 * @d2 inherit
 */
@Serializable
class RequestEvidenceAddCommand(
    override val id: RequestId,
    override val evidence: Evidence,
): RequestEvidenceAddCommandDTO

/**
 * @d2 inherit
 */
@Serializable
class RequestEvidenceAddedEvent(
	override val id: RequestId,
	override val type: RequestState = RequestState.CREATED,
	override val evidence: Evidence
): RequestEvidenceAddedEventDTO
