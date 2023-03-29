package cccev.s2.requirement.client

import cccev.f2.requirement.domain.RequirementApi
import cccev.f2.requirement.domain.command.ConstraintCreateFunction
import cccev.f2.requirement.domain.command.CriterionCreateFunction
import cccev.f2.requirement.domain.command.InformationRequirementCreateFunction
import cccev.f2.requirement.domain.command.RequirementAddRequirementsFunction
import cccev.f2.requirement.domain.command.RequirementCreateFunction
import cccev.f2.requirement.domain.command.RequirementUpdateFunction
import cccev.f2.requirement.domain.query.GetRequirementListQueryFunction
import cccev.f2.requirement.domain.query.GetRequirementQueryFunction
import cccev.f2.requirement.domain.query.RequirementGetFunction
import cccev.f2.requirement.domain.query.RequirementListChildrenByTypeFunction
import f2.client.F2Client
import f2.client.function
import f2.dsl.fnc.F2SupplierSingle
import kotlin.js.JsExport
import kotlin.js.JsName

expect fun F2Client.requirementClient(): F2SupplierSingle<RequirementClient>
expect fun requirementClient(urlBase: String): F2SupplierSingle<RequirementClient>

@JsExport
@JsName("RequirementClient")
open class RequirementClient constructor(private val client: F2Client) : RequirementApi {
    override fun requirementGet(): RequirementGetFunction  = client.function(this::requirementGet.name)
    @Deprecated("Use requirementGet instead", ReplaceWith("requirementGet()"))
    override fun getRequirement(): GetRequirementQueryFunction  = client.function(this::getRequirement.name)
    override fun requirementsList(): GetRequirementListQueryFunction = client.function(this::requirementsList.name)
    override fun requirementListChildrenByType(): RequirementListChildrenByTypeFunction = client.function(this::requirementsList.name)

    override fun constraintCreate(): ConstraintCreateFunction  = client.function(this::constraintCreate.name)
    override fun criterionCreate(): CriterionCreateFunction  = client.function(this::criterionCreate.name)
    override fun informationRequirementCreate(): InformationRequirementCreateFunction
        = client.function(this::informationRequirementCreate.name)
    override fun requirementCreate(): RequirementCreateFunction  = client.function(this::requirementCreate.name)
    override fun requirementUpdate(): RequirementUpdateFunction  = client.function(this::requirementUpdate.name)
    override fun requirementAddRequirements(): RequirementAddRequirementsFunction  = client.function(this::requirementAddRequirements.name)
}
