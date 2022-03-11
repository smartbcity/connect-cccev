package cccev.f2.evidence.api.domain.features.query

import cccev.core.dsl.EvidenceTypeId
import cccev.core.dsl.EvidenceTypeListId
import cccev.core.dsl.InformationConceptId
import cccev.core.dsl.RequirementId
import cccev.f2.evidence.api.domain.model.EvidenceTypeListChoicesDTO
import cccev.f2.evidence.api.domain.model.EvidenceTypeListChoicesDTOBase
import cccev.f2.evidence.api.domain.model.EvidenceTypeListDTO
import cccev.f2.evidence.api.domain.model.EvidenceTypeListDTOBase
import cccev.s2.request.domain.model.RequestId
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

typealias GetEvidenceTypeListsQueryFunction = F2Function<GetEvidenceTypeListsQuery, GetEvidenceTypeListsQueryResult>

@JsExport
@JsName("GetEvidenceTypeListsQueryDTO")
interface GetEvidenceTypeListsQueryDTO {
    val id: RequestId
    val requirement: RequirementId
    val concept: InformationConceptId?
    val evidenceType: EvidenceTypeId?
}

class GetEvidenceTypeListsQuery(
    override val id: RequestId,
    override val requirement: RequirementId,
    override val concept: InformationConceptId?,
    override val evidenceType: EvidenceTypeId?
): GetEvidenceTypeListsQueryDTO

@JsExport
@JsName("GetEvidenceTypeListsQueryResultDTO")
interface GetEvidenceTypeListsQueryResultDTO {
    val evidenceTypeListMap: Map<EvidenceTypeListId, EvidenceTypeListDTO>
    val evidenceTypeListsOfEvidenceTypes: Map<EvidenceTypeId, List<EvidenceTypeListId>>
    val evidenceTypeLists: List<EvidenceTypeListChoicesDTO>
}

class GetEvidenceTypeListsQueryResult(
    override val evidenceTypeListMap: Map<EvidenceTypeListId, EvidenceTypeListDTOBase>,
    override val evidenceTypeListsOfEvidenceTypes: Map<EvidenceTypeId, List<EvidenceTypeListId>>,
    override val evidenceTypeLists: List<EvidenceTypeListChoicesDTOBase>
): GetEvidenceTypeListsQueryResultDTO