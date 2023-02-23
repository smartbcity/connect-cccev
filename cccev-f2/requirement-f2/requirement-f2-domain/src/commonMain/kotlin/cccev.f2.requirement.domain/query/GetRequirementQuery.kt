package cccev.f2.requirement.domain.query

import cccev.dsl.model.Requirement
import cccev.dsl.model.RequirementId
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Get a requirement.
 * @parent [cccev.f2.requirement.domain.D2RequirementApiPage]
 * @child [GetRequirementQueryDTO]
 * @child [GetRequirementQueryResultDTO]
 * @d2 function
 */
typealias GetRequirementQueryFunction = F2Function<GetRequirementQuery, GetRequirementQueryResult>

/**
 * Requirement Query
 * @d2 query
 */
@JsExport
@JsName("GetRequirementQueryDTO")
interface GetRequirementQueryDTO {
    val requirementId: RequirementId
}

/**
 * Requirement Result
 * @d2 result
 */
@JsExport
@JsName("GetRequirementQueryResultDTO")
interface GetRequirementQueryResultDTO {
    val requirement: Requirement?
}

/**
 * @d2 inherit
 */
class GetRequirementQuery(
    override val requirementId: RequirementId
): GetRequirementQueryDTO

/**
 * @d2 inherit
 */
class GetRequirementQueryResult(
    override val requirement: Requirement?
): GetRequirementQueryResultDTO
