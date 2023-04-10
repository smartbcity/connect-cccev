package cccev.s2.request.domain.command

import cccev.s2.request.domain.RequestCommand
import cccev.s2.request.domain.RequestEvent
import cccev.s2.request.domain.model.RequestId
import cccev.s2.requirement.domain.RequirementId
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

/**
 * @d2 command
 */
@JsExport
@JsName("RequestRemoveRequirementsCommandDTO")
interface RequestRemoveRequirementsCommandDTO: RequestCommand {
    /**
     * Id of the request to remove the requirements from.
     */
    override val id: RequestId

    /**
     * Ids of the requirements to remove from the request.
     */
    val requirementIds: List<RequirementId>
}

/**
 * @d2 inherit
 */
data class RequestRemoveRequirementsCommand(
    override val id: RequestId,
    override val requirementIds: List<RequirementId>
): RequestRemoveRequirementsCommandDTO

/**
 * @d2 event
 */
@JsExport
@JsName("RequestRemovedRequirementsEventDTO")
interface RequestRemovedRequirementsEventDTO: RequestEvent {
    /**
     * Id of the request the requirements have been removed from.
     */
    override val id: RequestId

    /**
     * Ids of the removed requirements
     */
    val requirementIds: List<RequirementId>
}

/**
 * @d2 inherit
 */
@Serializable
data class RequestRemovedRequirementsEvent(
    override val id: RequestId,
    override val requirementIds: List<RequirementId>,
): RequestRemovedRequirementsEventDTO
