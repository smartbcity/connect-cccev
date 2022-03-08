package cccev.f2.requirement.api.domain.features.query

import cccev.core.dsl.EvidenceTypeId
import cccev.core.dsl.InformationConceptId
import cccev.core.dsl.Requirement
import cccev.core.dsl.RequirementId
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

typealias GetRequirementListQueryFunction = F2Function<GetRequirementListQuery, GetRequirementListQueryResult>

@JsExport
@JsName("GetRequirementListQueryDTO")
interface GetRequirementListQueryDTO {
    val parentId: RequirementId?
    val conceptId: InformationConceptId?
    val evidenceTypeId: EvidenceTypeId?
}

class GetRequirementListQuery(
    override val parentId: RequirementId?,
    override val conceptId: InformationConceptId?,
    override val evidenceTypeId: EvidenceTypeId?
): GetRequirementListQueryDTO

@JsExport
@JsName("GetRequirementListQueryResultDTO")
interface GetRequirementListQueryResultDTO {
    val requirements: List<Requirement>
}

class GetRequirementListQueryResult(
    override val requirements: List<Requirement>
): GetRequirementListQueryResultDTO
