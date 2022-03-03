package cccev.dsl.dto.query

import cccev.s2.request.domain.model.RequestId
import ccev.dsl.core.InformationConceptId
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

typealias GetRequestScoreQueryFunction = F2Function<GetRequestScoreQuery, GetRequestScoreQueryResult>

@JsExport
@JsName("GetRequestScoreQueryDTO")
interface GetRequestScoreQueryDTO {
    val requestId: RequestId
}

class GetRequestScoreQuery(
    override val requestId: RequestId
): GetRequestScoreQueryDTO

@JsExport
@JsName("GetRequestScoreQueryResultDTO")
interface GetRequestScoreQueryResultDTO {
    val score: Double
    val scorePerInformationConcept: Map<InformationConceptId, Double>
}

class GetRequestScoreQueryResult(
    override val score: Double,
    override val scorePerInformationConcept: Map<InformationConceptId, Double>
): GetRequestScoreQueryResultDTO
