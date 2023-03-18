package features.cccev.test

import cccev.dsl.model.EvidenceTypeBase
import cccev.dsl.model.EvidenceTypeListBase
import cccev.dsl.model.InformationConceptBase
import cccev.dsl.model.Requirement
import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.evidence.domain.EvidenceTypeId
import cccev.s2.evidence.domain.EvidenceTypeListId
import cccev.s2.request.domain.model.RequestId
import cccev.s2.requirement.domain.RequirementId
import cccev.s2.requirement.domain.model.RequirementIdentifier
import cccev.s2.unit.domain.DataUnitId
import fixers.bdd.data.BddContext
import fixers.bdd.data.TestContext
import fixers.bdd.data.TestContextKey
import fixers.bdd.data.TestEntityIds
import org.springframework.stereotype.Component

@Component
class CccevTestContext(
    private val testContext: TestContext
): BddContext by testContext {

    var evidenceTypes = testContext.testEntities<EvidenceTypeId, EvidenceTypeBase>("EvidenceTypeBase")
    var evidenceTypeLists = testContext.testEntities<EvidenceTypeListId, EvidenceTypeListBase>("EvidenceTypeListBase")
    var informationConcepts = testContext.testEntities<InformationConceptId, InformationConceptBase>("InformationConceptBase")
    var requirements = testContext.testEntities<RequirementId, Requirement>("Requirements")

    var requests = TestEntityIds<RequestId>()

    final var fetched = FetchContext()
        private set

    override fun resetEnv() {
        fetched = FetchContext()
    }

    class FetchContext {
//    lateinit var traces: List<TraceEntity>
    }
}
