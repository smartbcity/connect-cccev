package cccev.s2.requirement.domain.command

import cccev.dsl.model.EvidenceTypeListId
import cccev.dsl.model.FrameworkId
import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.requirement.domain.D2RequirementPage
import cccev.s2.requirement.domain.RequirementEvent
import cccev.s2.requirement.domain.RequirementId
import cccev.s2.requirement.domain.RequirementInitCommand
import cccev.s2.requirement.domain.RequirementState
import cccev.s2.requirement.domain.model.RequirementIdentifier
import cccev.s2.requirement.domain.model.RequirementKind
import kotlinx.serialization.Serializable
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
@Serializable
data class RequirementCreateCommand(
    /**
     * A custom identifier for the requirement
     * @example [cccev.s2.requirement.domain.model.Requirement.identifier]
     */
    val identifier: String?,

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
     * @ref [cccev.s2.requirement.domain.model.Requirement.type]
     */
    val type: String?,

    /**
     * @ref [cccev.s2.requirement.domain.model.Requirement.isDerivedFrom]
     */
    val isDerivedFrom: List<FrameworkId>,

    /**
     * Sub-requirements that must be fulfilled for the requirement to be validated.
     * @example [cccev.s2.requirement.domain.model.Requirement.hasRequirement]
     */
    val hasRequirement: List<RequirementId>,

    /**
     * @ref [cccev.s2.requirement.domain.model.Requirement.hasQualifiedRelation]
     */
    var hasQualifiedRelation: Map<String, List<RequirementId>>,

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
     * Identifier of the created requirement
     */
    override val id: RequirementId

    /**
     * @ref [RequirementCreateCommand.identifier]
     */
    val identifier: RequirementIdentifier?

    /**
     * @ref [RequirementCreateCommand.kind]
     */
    val kind: RequirementKind

    /**
     * @ref [RequirementCreateCommand.name]
     */
    val name: String?

    /**
     * @ref [RequirementCreateCommand.description]
     */
    val description: String?

    /**
     * @ref [cccev.s2.requirement.domain.model.Requirement.type]
     */
    val type: String?

    /**
     * @ref [RequirementCreateCommand.isDerivedFrom]
     */
    val isDerivedFrom: List<FrameworkId>

    /**
     * @ref [RequirementCreateCommand.hasRequirement]
     */
    val hasRequirement: List<RequirementId>

    /**
     * @ref [RequirementCreateCommand.hasQualifiedRelation]
     */
    val hasQualifiedRelation: Map<String, List<RequirementId>>

    /**
     * @ref [RequirementCreateCommand.hasConcept]
     */
    val hasConcept: List<InformationConceptId>

    /**
     * @ref [RequirementCreateCommand.hasEvidenceTypeList]
     */
    val hasEvidenceTypeList: List<EvidenceTypeListId>

    /**
     * State of the created requirement
     * @example "CREATED"
     */
    val status: RequirementState
}

/**
 * @d2 event
 * @parent [RequirementCreateFunction]
 */
@Serializable
data class RequirementCreatedEvent(
    override val id: RequirementId,
    override val identifier: RequirementIdentifier?,
    override val kind: RequirementKind,
    override val name: String?,
    override val description: String?,
    override val type: String?,
    override val isDerivedFrom: List<FrameworkId>,
    override val hasRequirement: List<RequirementId>,
    override val hasQualifiedRelation: Map<String, List<RequirementId>>,
    override val hasConcept: List<InformationConceptId>,
    override val hasEvidenceTypeList: List<EvidenceTypeListId>,
    override val status: RequirementState
): RequirementCreatedEventDTO
