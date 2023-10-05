package cccev.f2.requirement.domain

import cccev.f2.requirement.domain.command.ConstraintCreateFunction
import cccev.f2.requirement.domain.command.CriterionCreateFunction
import cccev.f2.requirement.domain.command.InformationRequirementCreateFunction
import cccev.f2.requirement.domain.command.RequirementAddRequirementsFunction
import cccev.f2.requirement.domain.command.RequirementCreateFunction
import cccev.f2.requirement.domain.command.RequirementUpdateFunction

interface RequirementCommandApi {
    /** Create a constraint */
    fun constraintCreate(): ConstraintCreateFunction

    /** Create a criterion */
    fun criterionCreate(): CriterionCreateFunction

    /** Create an information requirement */
    fun informationRequirementCreate(): InformationRequirementCreateFunction

    /** Create a requirement */
    fun requirementCreate(): RequirementCreateFunction

    /** Update a requirement */
    fun requirementUpdate(): RequirementUpdateFunction

    /** Add sub-requirements to a requirement */
    fun requirementAddRequirements(): RequirementAddRequirementsFunction
}
