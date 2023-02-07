package cccev.s2.requirement.domain.command

import cccev.core.dsl.EvidenceTypeListId
import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.requirement.domain.D2RequirementPage
import cccev.s2.requirement.domain.RequirementEvent
import cccev.s2.requirement.domain.RequirementId
import cccev.s2.requirement.domain.RequirementInitCommand
import cccev.s2.requirement.domain.model.RequirementKind
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Create a new requirement.
 * @d2 function
 * @parent [D2RequirementPage]
 * @order 10
 */
interface RequirementCreateFunction

/**
 * @d2 command
 * @parent [RequirementCreateFunction]
 */
data class RequirementCreateCommand(
    /**
     * Subtype used for the requirement.
     * @example [cccev.s2.requirement.domain.model.Requirement.kind]
     */
    val kind: RequirementKind,

    /**
     * Name of the requirement.
     * @example [cccev.s2.requirement.domain.model.Requirement.name]
     */
    val name: String?,

    /**
     * Description of the requirement. <br/>
     * If the requirement is a constraint, this field must contain an expression returning a boolean.
     * For now, this expression will be evaluated using a Kotlin engine. <br />
     * The expression may contain known information concepts, identified by their id. They must be declared in the `hasConcept` field.
     * @example [cccev.s2.requirement.domain.model.Requirement.description]
     */
    val description: String?,

    /**
     * Sub-requirements that must be fulfilled for the requirement to be validated.
     * @example [cccev.s2.requirement.domain.model.Requirement.hasRequirement]
     */
    val hasRequirement: List<RequirementId>,

    /**
     * Concepts used by the requirement
     * @example [cccev.s2.requirement.domain.model.Requirement.hasConcept]
     */
    val hasConcept: List<InformationConceptId>,

    /**
     * Evidences that must be provided for the requirement to be validated. <br/>
     * This list represents an OR-relation, i.e. only one of the specified evidence lists has to be fully provided.
     * @example [cccev.s2.requirement.domain.model.Requirement.hasEvidenceTypeList]
     */
    val hasEvidenceTypeList: List<EvidenceTypeListId>
): RequirementInitCommand

@JsExport
@JsName("RequirementCreatedEventDTO")
interface RequirementCreatedEventDTO: RequirementEvent {
    /**
     * Identifier of the created requirement.
     */
    override val id: RequirementId
}

/**
 * @d2 event
 * @parent [RequirementCreateFunction]
 */
data class RequirementCreatedEvent(
    override val id: RequirementId,
): RequirementCreatedEventDTO
