package cccev.s2.requirement.domain.model

import cccev.core.dsl.EvidenceTypeListId
import cccev.core.dsl.InformationConceptId
import cccev.s2.requirement.domain.D2RequirementPage
import cccev.s2.requirement.domain.RequirementId

/**
 * @d2 model
 * @parent [D2RequirementPage]
 * @order 10
 */
data class Requirement(
    /**
     * Identifier of the requirement.
     */
    val id: RequirementId,

    /**
     * Subtype used for the requirement.
     * @example "CONSTRAINT"
     */
    val kind: RequirementKind,

    /**
     * Name of the requirement.
     * @example "High clouds altitude"
     */
    val name: String?,

    /**
     * Description of the requirement. <br/>
     * If the requirement is a constraint, this field must contain an expression returning a boolean.
     * For now, this expression will be evaluated using a Kotlin engine. <br />
     * The expression may contain known information concepts, identified by their id. They must be declared in the `hasConcept` field.
     * @example "altitudeInMeters >= 6000"
     */
    val description: String?,

    /**
     * Sub-requirements that must be fulfilled for the requirement to be validated.
     * @example [[]]
     */
    val hasRequirement: List<RequirementId>,

    /**
     * Concepts used by the requirement
     * @example [["altitudeInMeters"]]
     */
    val hasConcept: List<InformationConceptId>,

    /**
     * Evidences that must be provided for the requirement to be validated. <br/>
     * This list represents an OR-relation, i.e. only one of the specified evidence lists has to be fully provided.
     * @example [[]]
     */
    val hasEvidenceTypeList: List<EvidenceTypeListId>
)
