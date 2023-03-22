package cccev.s2.request.domain.command

import cccev.s2.request.domain.RequestCommand
import cccev.s2.request.domain.RequestEvent
import cccev.s2.request.domain.model.RequestId
import cccev.s2.requirement.domain.RequirementId
import kotlinx.serialization.Serializable
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * @d2 command
 */
@JsExport
@JsName("RequestAddRequirementsCommandDTO")
interface RequestAddRequirementsCommandDTO: RequestCommand {
    /**
     * Id of the request to add the requirements to.
     */
    override val id: RequestId

    /**
     * Ids of the requirement that the requests will have to fulfill.
     */
    val requirementIds: List<RequirementId>
}

/**
 * @d2 inherit
 */
data class RequestAddRequirementsCommand(
    override val id: RequestId,
    override val requirementIds: List<RequirementId>
): RequestAddRequirementsCommandDTO

/**
 * @d2 event
 */
@JsExport
@JsName("RequestAddedRequirementsEventDTO")
interface RequestAddedRequirementsEventDTO: RequestEvent {
    /**
     * Id of the request the requirements have been added to.
     */
    override val id: RequestId

    /**
     * Ids of the requirements added to the request.
     */
    val requirementIds: List<RequirementId>
}

/**
 * @d2 inherit
 */
@Serializable
data class RequestAddedRequirementsEvent(
    override val id: RequestId,
    override val requirementIds: List<RequirementId>
): RequestAddedRequirementsEventDTO
