package cccev.s2.certification.domain.command

import cccev.s2.certification.domain.CertificationCommand
import cccev.s2.certification.domain.CertificationEvent
import cccev.s2.certification.domain.model.CertificationId
import cccev.s2.requirement.domain.RequirementId
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

/**
 * @d2 command
 */
@JsExport
@JsName("CertificationRemoveRequirementsCommandDTO")
interface CertificationRemoveRequirementsCommandDTO: CertificationCommand {
    /**
     * Id of the request to remove the requirements from.
     */
    override val id: CertificationId

    /**
     * Ids of the requirements to remove from the request.
     */
    val requirementIds: List<RequirementId>
}

/**
 * @d2 inherit
 */
data class CertificationRemoveRequirementsCommand(
    override val id: CertificationId,
    override val requirementIds: List<RequirementId>
): CertificationRemoveRequirementsCommandDTO

/**
 * @d2 event
 */
@JsExport
@JsName("CertificationRemovedRequirementsEventDTO")
interface CertificationRemovedRequirementsEventDTO: CertificationEvent {
    /**
     * Id of the request the requirements have been removed from.
     */
    override val id: CertificationId

    /**
     * Ids of the removed requirements
     */
    val requirementIds: List<RequirementId>
}

/**
 * @d2 inherit
 */
@Serializable
data class CertificationRemovedRequirementsEvent(
    override val id: CertificationId,
    override val requirementIds: List<RequirementId> = emptyList(),
): CertificationRemovedRequirementsEventDTO
