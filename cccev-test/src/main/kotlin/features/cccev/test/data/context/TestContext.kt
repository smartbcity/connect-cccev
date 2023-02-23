package features.cccev.test.data.context

import cccev.dsl.model.EvidenceTypeBase
import cccev.dsl.model.EvidenceTypeId
import cccev.dsl.model.EvidenceTypeListBase
import cccev.dsl.model.EvidenceTypeListId
import cccev.dsl.model.InformationConceptBase
import cccev.dsl.model.InformationConceptId
import cccev.dsl.model.Requirement
import cccev.dsl.model.RequirementId
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
