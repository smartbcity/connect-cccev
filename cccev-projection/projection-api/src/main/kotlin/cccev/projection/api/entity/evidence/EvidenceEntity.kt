package cccev.projection.api.entity.evidence

import cccev.dsl.model.PeriodOfTime
import cccev.projection.api.entity.EntityBase
import cccev.s2.request.domain.RequestState
import org.springframework.data.neo4j.core.schema.Node


typealias EvidenceId = String
@Node("Evidence")
class EvidenceEntity: EntityBase<EvidenceId, RequestState>() {
    var identifier: String? = null
    lateinit var name: String
//    val isConformantTo: List<EvidenceTypeId>,
//    val supportsValue: List<SupportedValueId> = emptyList(),
//    val supportsConcept: List<InformationConceptId> = emptyList(),
//    val supportsRequirement: List<RequirementId> = emptyList(),
//    val validityPeriod: PeriodOfTime? = null
    val file: String? = null
}
