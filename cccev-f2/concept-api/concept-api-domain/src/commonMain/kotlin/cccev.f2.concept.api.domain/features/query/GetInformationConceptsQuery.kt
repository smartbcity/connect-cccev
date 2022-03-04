package cccev.f2.concept.api.domain.features.query

import cccev.core.dsl.RequirementId
import cccev.f2.concept.api.domain.model.InformationConceptDTO
import cccev.s2.request.domain.model.RequestId
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

typealias GetInformationConceptsQueryFunction = F2Function<GetInformationConceptsQuery, GetInformationConceptsQueryResult>

@JsExport
@JsName("GetInformationConceptsQueryDTO")
interface GetInformationConceptsQueryDTO {
    val id: RequestId
    val requirement: RequirementId
}

class GetInformationConceptsQuery(
    override val id: RequestId,
    override val requirement: RequirementId
): GetInformationConceptsQueryDTO

@JsExport
@JsName("GetInformationConceptsQueryResultDTO")
interface GetInformationConceptsQueryResultDTO {
    val informationConcepts: List<InformationConceptDTO>
}

class GetInformationConceptsQueryResult(
    override val informationConcepts: List<InformationConceptDTO>
): GetInformationConceptsQueryResultDTO
