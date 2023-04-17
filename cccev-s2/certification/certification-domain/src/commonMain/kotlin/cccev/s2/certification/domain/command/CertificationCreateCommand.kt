package cccev.s2.certification.domain.command

import cccev.s2.certification.domain.CertificationEvent
import cccev.s2.certification.domain.CertificationInitCommand
import cccev.s2.certification.domain.model.CertificationId
import cccev.s2.requirement.domain.RequirementId
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

/**
 * @d2 command
 */
@JsExport
@JsName("CertificationCreateCommandDTO")
interface CertificationCreateCommandDTO: CertificationInitCommand {
    /**
     * @ref [cccev.s2.certification.domain.model.CertificationDTO.name]
     */
    val name: String

    /**
     * @ref [cccev.s2.certification.domain.model.CertificationDTO.description]
     */
    val description: String?

    /**
     * @ref [cccev.s2.certification.domain.model.CertificationDTO.requirements]
     */
    val requirements: List<RequirementId>
}

/**
 * @d2 inherit
 */
@Serializable
data class CertificationCreateCommand(
    override val name: String,
    override val description: String?,
    override val requirements: List<RequirementId>
): CertificationCreateCommandDTO

/**
 * @d2 event
 */
@JsExport
@JsName("CertificationCreatedEventDTO")
interface CertificationCreatedEventDTO: CertificationEvent {
    /**
     * @ref [cccev.s2.certification.domain.model.CertificationDTO.id]
     */
    override val id: CertificationId

    /**
     * @ref [cccev.s2.certification.domain.model.CertificationDTO.name]
     */
    val name: String

    /**
     * @ref [cccev.s2.certification.domain.model.CertificationDTO.description]
     */
    val description: String?

    /**
     * @ref [cccev.s2.certification.domain.model.CertificationDTO.requirements]
     */
    val requirements: List<RequirementId>
}

/**
 * @d2 inherit
 */
@Serializable
data class CertificationCreatedEvent(
    override val id: CertificationId,
    override val name: String,
    override val description: String?,
    override val requirements: List<RequirementId>
): CertificationCreatedEventDTO
