package cccev.f2.evidence.domain.features.query

import cccev.core.dsl.EvidenceTypeId
import cccev.core.dsl.EvidenceTypeListId
import cccev.core.dsl.InformationConceptId
import cccev.core.dsl.RequirementId
import cccev.f2.evidence.domain.model.EvidenceTypeListChoicesDTO
import cccev.f2.evidence.domain.model.EvidenceTypeListChoicesDTOBase
import cccev.f2.evidence.domain.model.EvidenceTypeListDTO
import cccev.f2.evidence.domain.model.EvidenceTypeListDTOBase
import cccev.s2.request.domain.model.RequestId
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Get evidence type lists
 *
 * @parent [cccev.f2.evidence.domain.D2EvidenceApiPage]
 * @child [GetEvidenceTypeListsQueryDTO]
 * @child [GetEvidenceTypeListsQueryResultDTO]
 * @d2 function
 */
typealias GetEvidenceTypeListsQueryFunction = F2Function<GetEvidenceTypeListsQuery, GetEvidenceTypeListsQueryResult>

/**
 * Evidence type lists Query
 * @d2 query
 */
@JsExport
@JsName("GetEvidenceTypeListsQueryDTO")
interface GetEvidenceTypeListsQueryDTO {
    val id: RequestId
    val requirement: RequirementId
    val concept: InformationConceptId?
    val evidenceType: EvidenceTypeId?
}

/**
 * Information concepts result
 * @d2 result
 */
@JsExport
@JsName("GetEvidenceTypeListsQueryResultDTO")
interface GetEvidenceTypeListsQueryResultDTO {
    val evidenceTypeListMap: Map<EvidenceTypeListId, EvidenceTypeListDTO>
    val evidenceTypeListsOfEvidenceTypes: Map<EvidenceTypeId, List<EvidenceTypeListId>>
    val evidenceTypeLists: List<EvidenceTypeListChoicesDTO>
}

/**
 * @d2 inherit
 */
class GetEvidenceTypeListsQuery(
    override val id: RequestId,
    override val requirement: RequirementId,
    override val concept: InformationConceptId?,
    override val evidenceType: EvidenceTypeId?
): GetEvidenceTypeListsQueryDTO

/**
 * @d2 inherit
 */
class GetEvidenceTypeListsQueryResult(
    override val evidenceTypeListMap: Map<EvidenceTypeListId, EvidenceTypeListDTOBase>,
    override val evidenceTypeListsOfEvidenceTypes: Map<EvidenceTypeId, List<EvidenceTypeListId>>,
    override val evidenceTypeLists: List<EvidenceTypeListChoicesDTOBase>
): GetEvidenceTypeListsQueryResultDTO
