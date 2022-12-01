package cccev.f2.request.api.domain.features.query

import cccev.core.dsl.InformationConceptId
import cccev.s2.request.domain.model.RequestId
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Refuse to a request.
 * @parent [cccev.f2.request.api.domain.features.D2RequestApiPage]
 * @child [GetRequestScoreQueryDTO]
 * @child [GetRequestScoreQueryResultDTO]
 * @d2 function
 */
typealias GetRequestScoreQueryFunction = F2Function<GetRequestScoreQuery, GetRequestScoreQueryResult>

/**
 * Get Request Core.
 * @d2 query
 */
@JsExport
@JsName("GetRequestScoreQueryDTO")
interface GetRequestScoreQueryDTO {
    val requestId: RequestId
}

/**
 * Get Request Core
 * @d2 result
 */
@JsExport
@JsName("GetRequestScoreQueryResultDTO")
interface GetRequestScoreQueryResultDTO {
    val score: Double
    val scorePerInformationConcept: Map<InformationConceptId, Double>
}

/**
 * @d2 inherit
 */
class GetRequestScoreQuery(
    override val requestId: RequestId
): GetRequestScoreQueryDTO

/**
 * @d2 inherit
 */
class GetRequestScoreQueryResult(
    override val score: Double,
    override val scorePerInformationConcept: Map<InformationConceptId, Double>
): GetRequestScoreQueryResultDTO
