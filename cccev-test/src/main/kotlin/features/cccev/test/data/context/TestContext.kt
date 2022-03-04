package features.cccev.test.data.context

import cccev.core.dsl.EvidenceTypeBase
import cccev.core.dsl.EvidenceTypeId
import cccev.core.dsl.EvidenceTypeListBase
import cccev.core.dsl.EvidenceTypeListId
import cccev.core.dsl.InformationConceptBase
import cccev.core.dsl.InformationConceptId
import cccev.core.dsl.Requirement
import cccev.core.dsl.RequirementId
import cccev.s2.request.domain.model.RequestId
import org.springframework.stereotype.Component

@Component
class TestContext {
    var evidenceTypes = TestEntities<EvidenceTypeId, EvidenceTypeBase>()
    var evidenceTypeLists = TestEntities<EvidenceTypeListId, EvidenceTypeListBase>()
    var informationConcepts = TestEntities<InformationConceptId, InformationConceptBase>()
    var requirements = TestEntities<RequirementId, Requirement>()

    var requests = TestEntityIds<RequestId>()
}
