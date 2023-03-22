package cccev.s2.request.domain.command

import cccev.s2.request.domain.RequestCommand
import cccev.s2.request.domain.RequestEvent
import cccev.s2.request.domain.model.EvidenceId
import cccev.s2.request.domain.model.RequestId
import kotlinx.serialization.Serializable
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * @d2 command
 */
@JsExport
@JsName("RequestRemoveEvidenceCommandDTO")
interface RequestRemoveEvidenceCommandDTO: RequestCommand {
    /**
     * Id of the request to remove the evidence from.
     */
    override val id: RequestId

    /**
     * Id of the evidence to remove from the request.
     */
    val evidenceId: EvidenceId
}

/**
 * @d2 inherit
 */
data class RequestRemoveEvidenceCommand(
    override val id: RequestId,
    override val evidenceId: EvidenceId
): RequestRemoveEvidenceCommandDTO

/**
 * @d2 event
 */
@JsExport
@JsName("RequestRemovedEvidenceEventDTO")
interface RequestRemovedEvidenceEventDTO: RequestEvent {
    /**
     * Id of the request the evidence has been removed from.
     */
    override val id: RequestId

    /**
     * Id of the removed evidence.
     */
    val evidenceId: EvidenceId
}

/**
 * @d2 inherit
 */
@Serializable
data class RequestRemovedEvidenceEvent(
    override val id: RequestId,
    override val evidenceId: EvidenceId
): RequestRemovedEvidenceEventDTO
