package cccev.f2.requirement.domain.query

import cccev.f2.requirement.domain.model.RequirementDTO
import cccev.f2.requirement.domain.model.RequirementDTOBase
import cccev.s2.requirement.domain.RequirementId
import f2.dsl.fnc.F2Function
import kotlinx.serialization.Serializable
import kotlin.js.JsExport
import kotlin.js.JsName

typealias RequirementListByIdsAndTypeFunction
        = F2Function<RequirementListByIdsAndTypeQueryDTOBase, RequirementListByIdsAndTypeResultDTOBase>

@JsExport
@JsName("RequirementListByIdsAndTypeQueryDTO")
interface RequirementListByIdsAndTypeQueryDTO {
    val ids: List<RequirementId>
    val type: String
}

@Serializable
data class RequirementListByIdsAndTypeQueryDTOBase(
    override val ids: List<RequirementId>,
    override val type: String
): RequirementListByIdsAndTypeQueryDTO

@JsExport
@JsName("RequirementListByIdsAndTypeResultDTO")
interface RequirementListByIdsAndTypeResultDTO {
    val items: List<RequirementDTO>?
}

@Serializable
data class RequirementListByIdsAndTypeResultDTOBase(
    override val items: List<RequirementDTOBase>?
): RequirementListByIdsAndTypeResultDTO
