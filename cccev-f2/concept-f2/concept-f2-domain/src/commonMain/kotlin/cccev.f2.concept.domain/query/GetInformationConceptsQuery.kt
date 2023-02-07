package cccev.f2.concept.domain.query

import cccev.core.dsl.EvidenceTypeId
import cccev.core.dsl.RequirementId
import cccev.f2.concept.domain.model.RequestInformationConceptDTO
import cccev.s2.request.domain.model.RequestId
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Get information concepts
 *
 * @parent [cccev.f2.concept.domain.D2InformationConceptF2Page]
 * @child [GetInformationConceptsQueryDTO]
 * @child [GetInformationConceptsQueryResultDTO]
 * @d2 function
 */
typealias GetInformationConceptsQueryFunction = F2Function<GetInformationConceptsQuery, GetInformationConceptsQueryResult>

/**
 * Information Concepts Query
 * @d2 query
 */
@JsExport
@JsName("GetInformationConceptsQueryDTO")
interface GetInformationConceptsQueryDTO {
    val id: RequestId
    val requirement: RequirementId
    val evidenceType: EvidenceTypeId?
}

/**
 * Information concepts result
 * @d2 result
 */
@JsExport
@JsName("GetInformationConceptsQueryResultDTO")
interface GetInformationConceptsQueryResultDTO {
    val informationConcepts: List<RequestInformationConceptDTO>
}

/**
 * @d2 inherit
 */
class GetInformationConceptsQuery(
    override val id: RequestId,
    override val requirement: RequirementId,
    override val evidenceType: EvidenceTypeId? = null
): GetInformationConceptsQueryDTO

/**
 * @d2 inherit
 */
class GetInformationConceptsQueryResult(
    override val informationConcepts: List<RequestInformationConceptDTO>
): GetInformationConceptsQueryResultDTO
