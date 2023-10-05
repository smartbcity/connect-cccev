package cccev.f2.requirement.domain.query

import cccev.dsl.model.EvidenceTypeId
import cccev.dsl.model.InformationConceptId
import cccev.dsl.model.RequirementId
import cccev.f2.requirement.domain.model.RequirementDTO
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

/**
 * Get a list of requirements.
 * @parent [cccev.f2.requirement.domain.D2RequirementApiPage]
 * @child [RequirementListQueryDTO]
 * @child [RequirementListResultDTO]
 * @d2 function
 */
typealias RequirementListQueryFunction = F2Function<RequirementListQuery, RequirementListResult>

/**
 * Requirement List Query
 * @d2 query
 */
@JsExport
@JsName("RequirementListQueryDTO")
interface RequirementListQueryDTO {
    val parentId: RequirementId?
    val conceptId: InformationConceptId?
    val evidenceTypeId: EvidenceTypeId?
}

/**
 * Requirement List Result
 * @d2 result
 */
@JsExport
@JsName("RequirementListResultDTO")
interface RequirementListResultDTO {
    val requirements: List<RequirementDTO>
}

/**
 * @d2 inherit
 */
@Serializable
class RequirementListQuery(
    override val parentId: RequirementId? = null,
    override val conceptId: InformationConceptId? = null,
    override val evidenceTypeId: EvidenceTypeId? = null
): RequirementListQueryDTO

/**
 * @d2 inherit
 */
class RequirementListResult(
    override val requirements: List<RequirementDTO>
): RequirementListResultDTO
