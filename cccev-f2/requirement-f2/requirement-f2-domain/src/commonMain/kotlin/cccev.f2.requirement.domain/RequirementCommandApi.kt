package cccev.f2.requirement.domain

import cccev.f2.requirement.domain.command.ConstraintCreateFunction
import cccev.f2.requirement.domain.command.CriterionCreateFunction
import cccev.f2.requirement.domain.command.InformationRequirementCreateFunction

interface RequirementCommandApi {
    /**
     * Create a constraint
     */
    fun constraintCreate(): ConstraintCreateFunction

    /**
     * Create a criterion
     */
    fun criterionCreate(): CriterionCreateFunction

    /**
     * Create an information requirement
     */
    fun informationRequirementCreate(): InformationRequirementCreateFunction
}
