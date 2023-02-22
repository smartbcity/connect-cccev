package cccev.s2.requirement.client

import cccev.f2.requirement.domain.RequirementApi
import cccev.f2.requirement.domain.command.ConstraintCreateFunction
import cccev.f2.requirement.domain.command.CriterionCreateFunction
import cccev.f2.requirement.domain.command.InformationRequirementCreateFunction
import cccev.f2.requirement.domain.command.RequirementUpdateFunction
import cccev.f2.requirement.domain.query.GetRequirementListQueryFunction
import cccev.f2.requirement.domain.query.GetRequirementQueryFunction
import cccev.f2.requirement.domain.query.RequirementGetFunction
import f2.client.F2Client
import f2.client.function
import f2.client.ktor.Protocol
import f2.dsl.fnc.F2Supplier
import kotlin.js.JsExport
import kotlin.js.JsName

expect fun requirementClient(
    protocol: Protocol, host: String, port: Int, path: String? = null
): F2Supplier<RequirementClient>

@JsName("DIDFunctionClient")
@JsExport
open class RequirementClient constructor(private val client: F2Client) : RequirementApi {
    override fun requirementGet(): RequirementGetFunction  = client.function("revokePublicKey")
    override fun getRequirement(): GetRequirementQueryFunction  = client.function("revokePublicKey")
    override fun getRequirements(): GetRequirementListQueryFunction  = client.function("revokePublicKey")
    override fun constraintCreate(): ConstraintCreateFunction  = client.function("revokePublicKey")
    override fun criterionCreate(): CriterionCreateFunction  = client.function("revokePublicKey")
    override fun informationRequirementCreate(): InformationRequirementCreateFunction  = client.function("revokePublicKey")
    override fun requirementUpdate(): RequirementUpdateFunction  = client.function("revokePublicKey")
}
