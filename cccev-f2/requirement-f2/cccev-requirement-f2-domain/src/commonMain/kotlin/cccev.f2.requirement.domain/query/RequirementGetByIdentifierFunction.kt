package cccev.f2.requirement.domain.query

import cccev.f2.requirement.domain.model.RequirementDTO
import cccev.f2.requirement.domain.model.RequirementDTOBase
import cccev.s2.requirement.domain.model.RequirementIdentifier
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

typealias RequirementGetByIdentifierFunction = F2Function<RequirementGetByIdentifierQueryDTOBase, RequirementGetByIdentifierResultDTOBase>

@JsExport
@JsName("RequirementGetByIdentifierQueryDTO")
interface RequirementGetByIdentifierQueryDTO {
    val identifier: RequirementIdentifier
}

@Serializable
data class RequirementGetByIdentifierQueryDTOBase(
    override val identifier: RequirementIdentifier
): RequirementGetByIdentifierQueryDTO

@JsExport
@JsName("RequirementGetByIdentifierResultDTO")
interface RequirementGetByIdentifierResultDTO {
    val item: RequirementDTO?
}

@Serializable
data class RequirementGetByIdentifierResultDTOBase(
    override val item: RequirementDTOBase? = null
): RequirementGetByIdentifierResultDTO
