package cccev.f2.requirement.domain.query

import cccev.f2.requirement.domain.model.RequirementDTO
import cccev.f2.requirement.domain.model.RequirementDTOBase
import cccev.s2.requirement.domain.RequirementId
import cccev.s2.requirement.domain.model.RequirementIdentifier
import f2.dsl.fnc.F2Function
import kotlinx.serialization.Serializable
import kotlin.js.JsExport
import kotlin.js.JsName

typealias RequirementListChildrenByTypeFunction
        = F2Function<RequirementChildrenByTypeQueryDTOBase, RequirementChildrenByTypeResultDTOBase>

@JsExport
@JsName("RequirementListChildrenByTypeQueryDTO")
interface RequirementListChildrenByTypeQueryDTO {
    val identifiers: List<RequirementIdentifier>
    val type: String
}

@Serializable
data class RequirementChildrenByTypeQueryDTOBase(
    override val identifiers: List<RequirementId>,
    override val type: String
): RequirementListChildrenByTypeQueryDTO

@JsExport
@JsName("RequirementChildrenByTypeResultDTO")
interface RequirementChildrenByTypeResultDTO {
    val items: List<RequirementDTO>?
}

@Serializable
data class RequirementChildrenByTypeResultDTOBase(
    override val items: List<RequirementDTOBase>?
): RequirementChildrenByTypeResultDTO
