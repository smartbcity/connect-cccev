package cccev.s2.request.domain.features.command

import cccev.core.dsl.Evidence
import cccev.core.dsl.EvidenceDTO
import cccev.core.dsl.EvidenceId
import cccev.s2.request.domain.RequestCommand
import cccev.s2.request.domain.RequestEvent
import cccev.s2.request.domain.RequestState
import cccev.s2.request.domain.model.RequestId
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Command to add an evidence to a request.
 * @D2 command
 * @parent [RequestEvidenceAddCommandFunction]
 */
@JsExport
@JsName("RequestEvidenceAddCommandDTO")
interface RequestEvidenceAddCommandDTO: RequestCommand {
	/**
	 * The unique id of the request.
	 */
	override val id: RequestId

	/**
	 * The evidence to add.
	 */
	val evidence: EvidenceDTO
}

/**
 * Event sent when an evidence has been added to a request.
 * @D2 event
 * @parent [RequestEvidenceAddCommandFunction]
 */
@JsExport
@JsName("RequestEvidenceAddedEventDTO")
interface RequestEvidenceAddedEventDTO: RequestEvent {
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
	 * Identifier of the newly added evidence.
	 */
	val evidenceId: EvidenceId
}

class RequestEvidenceAddCommand(
	override val id: RequestId,
	override val evidence: Evidence,
): RequestEvidenceAddCommandDTO

class RequestEvidenceAddedEvent(
	override val id: RequestId,
	override val type: RequestState.Created = RequestState.Created,
	override val evidenceId: EvidenceId,
): RequestEvidenceAddedEventDTO
