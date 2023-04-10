package cccev.s2.request.domain.command

import cccev.s2.request.domain.RequestEvent
import cccev.s2.request.domain.RequestInitCommand
import cccev.s2.request.domain.model.RequestId
import cccev.s2.requirement.domain.RequirementId
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

/**
 * @d2 command
 */
@JsExport
@JsName("RequestCreateCommandDTO")
interface RequestCreateCommandDTO: RequestInitCommand {
    /**
     * @ref [cccev.s2.request.domain.model.RequestDTO.name]
     */
    val name: String

    /**
     * @ref [cccev.s2.request.domain.model.RequestDTO.description]
     */
    val description: String?

    /**
     * @ref [cccev.s2.request.domain.model.RequestDTO.requirements]
     */
    val requirements: List<RequirementId>
}

/**
 * @d2 inherit
 */
@Serializable
data class RequestCreateCommand(
    override val name: String,
    override val description: String?,
    override val requirements: List<RequirementId>
): RequestCreateCommandDTO

/**
 * @d2 event
 */
@JsExport
@JsName("RequestCreatedEventDTO")
interface RequestCreatedEventDTO: RequestEvent {
    /**
     * @ref [cccev.s2.request.domain.model.RequestDTO.id]
     */
    override val id: RequestId

    /**
     * @ref [cccev.s2.request.domain.model.RequestDTO.name]
     */
    val name: String

    /**
     * @ref [cccev.s2.request.domain.model.RequestDTO.description]
     */
    val description: String?

    /**
     * @ref [cccev.s2.request.domain.model.RequestDTO.requirements]
     */
    val requirements: List<RequirementId>
}

/**
 * @d2 inherit
 */
@Serializable
data class RequestCreatedEvent(
    override val id: RequestId,
    override val name: String,
    override val description: String?,
    override val requirements: List<RequirementId>
): RequestCreatedEventDTO
