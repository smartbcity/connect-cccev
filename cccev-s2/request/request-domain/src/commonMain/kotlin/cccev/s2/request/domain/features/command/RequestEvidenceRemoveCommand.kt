package cccev.s2.request.domain.features.command

import cccev.dsl.model.EvidenceTypeId
import cccev.s2.request.domain.RequestCommand
import cccev.s2.request.domain.RequestEvent
import cccev.s2.request.domain.RequestState
import cccev.s2.request.domain.model.RequestId
import kotlin.js.JsExport
import kotlin.js.JsName


@JsExport
@JsName("RequestEvidenceRemoveCommandDTO")
interface RequestEvidenceRemoveCommandDTO: RequestCommand {
	override val id: RequestId
	val evidenceTypeId: EvidenceTypeId
}


@JsExport
@JsName("RequestEvidenceRemovedEventDTO")
interface RequestEvidenceRemovedEventDTO: RequestEvent {
	override val id: RequestId
	override val type: RequestState.Created
	val evidenceTypeId: EvidenceTypeId
}

/**
 * Command to remove an evidence from a request.
 * @D2 command
 */
class RequestEvidenceRemoveCommand(
    override val id: RequestId,
    override val evidenceTypeId: EvidenceTypeId,
): RequestEvidenceRemoveCommandDTO

/**
 * Event sent when an evidence has been added to a request.
 * @D2 event
 */
class RequestEvidenceRemovedEvent(
    override val id: RequestId,
    /**
	 * The current state of the request.
	 * @example "Created"
	 */
	override val type: RequestState.Created = RequestState.Created,
    /**
	 * Identifier of the removed evidence type.
	 * @example "082f9b5b-4ffa-4e95-8288-2de2972cade5"
	 */
	override val evidenceTypeId: EvidenceTypeId,
): RequestEvidenceRemovedEventDTO
