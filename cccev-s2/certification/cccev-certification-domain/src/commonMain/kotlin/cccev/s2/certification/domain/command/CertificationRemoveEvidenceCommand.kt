package cccev.s2.certification.domain.command

import cccev.s2.certification.domain.CertificationCommand
import cccev.s2.certification.domain.CertificationEvent
import cccev.s2.certification.domain.model.EvidenceId
import cccev.s2.certification.domain.model.CertificationId
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

/**
 * @d2 command
 */
@JsExport
@JsName("CertificationRemoveEvidenceCommandDTO")
interface CertificationRemoveEvidenceCommandDTO: CertificationCommand {
    /**
     * Id of the request to remove the evidence from.
     */
    override val id: CertificationId

    /**
     * Id of the evidence to remove from the request.
     */
    val evidenceId: EvidenceId
}

/**
 * @d2 inherit
 */
data class CertificationRemoveEvidenceCommand(
    override val id: CertificationId,
    override val evidenceId: EvidenceId
): CertificationRemoveEvidenceCommandDTO

/**
 * @d2 event
 */
@JsExport
@JsName("CertificationRemovedEvidenceEventDTO")
interface CertificationRemovedEvidenceEventDTO: CertificationEvent {
    /**
     * Id of the request the evidence has been removed from.
     */
    override val id: CertificationId

    /**
     * Id of the removed evidence.
     */
    val evidenceId: EvidenceId
}

/**
 * @d2 inherit
 */
@Serializable
data class CertificationRemovedEvidenceEvent(
    override val id: CertificationId,
    override val evidenceId: EvidenceId
): CertificationRemovedEvidenceEventDTO
