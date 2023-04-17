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
@JsName("CertificationAddRequirementsCommandDTO")
interface CertificationAddRequirementsCommandDTO: CertificationCommand {
    /**
     * Id of the certification to add the requirements to.
     */
    override val id: CertificationId

    /**
     * Ids of the requirement that the certifications will have to fulfill.
     */
    val requirementIds: List<RequirementId>
}

/**
 * @d2 inherit
 */
data class CertificationAddRequirementsCommand(
    override val id: CertificationId,
    override val requirementIds: List<RequirementId>
): CertificationAddRequirementsCommandDTO

/**
 * @d2 event
 */
@JsExport
@JsName("CertificationAddedRequirementsEventDTO")
interface CertificationAddedRequirementsEventDTO: CertificationEvent {
    /**
     * Id of the certification the requirements have been added to.
     */
    override val id: CertificationId

    /**
     * Ids of the requirements added to the certification.
     */
    val requirementIds: List<RequirementId>
}

/**
 * @d2 inherit
 */
@Serializable
data class CertificationAddedRequirementsEvent(
    override val id: CertificationId,
    override val requirementIds: List<RequirementId>
): CertificationAddedRequirementsEventDTO
