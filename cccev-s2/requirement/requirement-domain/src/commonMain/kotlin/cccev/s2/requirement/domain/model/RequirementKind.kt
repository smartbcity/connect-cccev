package cccev.s2.requirement.domain.model

/**
 * Indicate which subtype of requirement is being used. <br/>
 * Can be either of: CONSTRAINT, CRITERION, INFORMATION
 * @d2 model
 * @order 20
 * @visual json "CONSTRAINT"
 */
enum class RequirementKind {
    CONSTRAINT,
    CRITERION,
    INFORMATION
}
