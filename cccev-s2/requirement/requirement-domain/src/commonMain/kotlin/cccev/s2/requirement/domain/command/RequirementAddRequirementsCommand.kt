package cccev.s2.requirement.domain.command

import cccev.s2.requirement.domain.D2RequirementPage
import cccev.s2.requirement.domain.RequirementCommand
import cccev.s2.requirement.domain.RequirementEvent
import cccev.s2.requirement.domain.RequirementId
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

/**
 * Add a list of sub-requirement to a requirement.
 * @d2 function
 * @parent [D2RequirementPage]
 * @order 30
 */
interface RequirementAddRequirementsFunction

@JsExport
@JsName("RequirementAddRequirementsCommandDTO")
interface RequirementAddRequirementsCommandDTO: RequirementCommand {
    /**
     * Id of the requirement to add sub-requirements to.
     */
    override val id: RequirementId

    /**
     * Ids of the sub-requirements to add.
     * @example [["8e411870-9a8c-4d7a-91b6-496148c6f5c5", "f31cf8df-44f2-4fef-bc20-09a173032bb2"]]
     */
    val requirementIds: List<RequirementId>
}

/**
 * @d2 command
 * @parent [RequirementAddRequirementsFunction]
 */
@Serializable
data class RequirementAddRequirementsCommand(
    override val id: RequirementId,
    override val requirementIds: List<RequirementId>
): RequirementAddRequirementsCommandDTO

@JsExport
@JsName("RequirementAddedRequirementsEventDTO")
interface RequirementAddedRequirementsEventDTO: RequirementEvent {
    /** @ref [RequirementAddRequirementsCommand.id] */
    override val id: RequirementId

    /** @ref [RequirementAddRequirementsCommand.requirementIds] */
    val requirementIds: List<RequirementId>
}

/**
 * @d2 event
 * @parent [RequirementAddRequirementsFunction]
 */
@Serializable
data class RequirementAddedRequirementsEvent(
    override val id: RequirementId,
    override val requirementIds: List<RequirementId>
): RequirementAddedRequirementsEventDTO
