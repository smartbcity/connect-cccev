package cccev.s2.requirement.domain.model

import cccev.s2.requirement.domain.D2RequirementPage

/**
 * Indicate which subtype of requirement is being used. <br/>
 * Can be either of: CONSTRAINT, CRITERION, INFORMATION
 * @d2 model
 * @order 20
 * @parent [D2RequirementPage]
 * @visual json "CONSTRAINT"
 */
enum class RequirementKind {
    CONSTRAINT,
    CRITERION,
    INFORMATION
}
