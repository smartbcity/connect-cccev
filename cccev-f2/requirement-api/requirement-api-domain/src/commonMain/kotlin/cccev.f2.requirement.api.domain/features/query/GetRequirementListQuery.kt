package cccev.f2.requirement.api.domain.features.query

import cccev.core.dsl.EvidenceTypeId
import cccev.core.dsl.InformationConceptId
import cccev.core.dsl.Requirement
import cccev.core.dsl.RequirementId
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Get a list of requirements.
 * @parent [cccev.f2.requirement.api.domain.D2RequirementApiPage]
 * @child [GetRequirementListQueryDTO]
 * @child [GetRequirementListQueryResultDTO]
 * @d2 function
 */
typealias GetRequirementListQueryFunction = F2Function<GetRequirementListQuery, GetRequirementListQueryResult>

/**
 * Requirement List Query
 * @d2 query
 */
@JsExport
@JsName("GetRequirementListQueryDTO")
interface GetRequirementListQueryDTO {
    val parentId: RequirementId?
    val conceptId: InformationConceptId?
    val evidenceTypeId: EvidenceTypeId?
}

/**
 * Requirement List Result
 * @d2 result
 */
@JsExport
@JsName("GetRequirementListQueryResultDTO")
interface GetRequirementListQueryResultDTO {
    val requirements: List<Requirement>
}

/**
 * @d2 inherit
 */
class GetRequirementListQuery(
    override val parentId: RequirementId?,
    override val conceptId: InformationConceptId?,
    override val evidenceTypeId: EvidenceTypeId?
): GetRequirementListQueryDTO

/**
 * @d2 inherit
 */
class GetRequirementListQueryResult(
    override val requirements: List<Requirement>
): GetRequirementListQueryResultDTO
