package cccev.f2.requirement.domain.query

import cccev.f2.requirement.domain.model.RequirementDTO
import cccev.f2.requirement.domain.model.RequirementDTOBase
import cccev.s2.requirement.domain.RequirementId
import f2.dsl.fnc.F2Function
import kotlinx.serialization.Serializable
import kotlin.js.JsExport
import kotlin.js.JsName

typealias RequirementGetFunction = F2Function<RequirementGetQueryDTOBase, RequirementGetResultDTOBase>

@JsExport
@JsName("RequirementGetQueryDTO")
interface RequirementGetQueryDTO {
    val id: RequirementId
}

@Serializable
data class RequirementGetQueryDTOBase(
    override val id: RequirementId
): RequirementGetQueryDTO

@JsExport
@JsName("RequirementGetResultDTO")
interface RequirementGetResultDTO {
    val item: RequirementDTO?
}

@Serializable
data class RequirementGetResultDTOBase(
    override val item: RequirementDTOBase?
): RequirementGetResultDTO
