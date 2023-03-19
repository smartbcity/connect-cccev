package cccev.test

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
import s2.bdd.data.BddContext
import s2.bdd.data.TestContext
import s2.bdd.data.TestContextKey
import s2.bdd.data.TestEntityIds
import org.springframework.stereotype.Component

@Component
class CccevTestContext(
    private val testContext: TestContext
): BddContext by testContext {

    val conceptIds = testContext.testEntities<TestContextKey, InformationConceptId>("InformationConcept")
    val conceptIdentifiers = testContext.testEntities<TestContextKey, String>("InformationConcept with identifier")
    val evidenceTypeIds = testContext.testEntities<TestContextKey, EvidenceTypeId>("EvidenceType")
    val evidenceTypeIdentifiers = testContext.testEntities<TestContextKey, String>("EvidenceType with identifier")
    val evidenceTypeListIds = testContext.testEntities<TestContextKey, EvidenceTypeListId>("EvidenceTypeList")
    val evidenceTypeListIdentifiers = testContext.testEntities<TestContextKey, String>("EvidenceTypeList with identifier")
    val requirementIds = testContext.testEntities<TestContextKey, RequirementId>("Requirement")
    val requirementIdentifiers = testContext.testEntities<TestContextKey, RequirementIdentifier>("Requirement with identifier")
    val unitIds = testContext.testEntities<TestContextKey, DataUnitId>("DataUnit")

    val requestIds = testContext.testEntities<TestContextKey, RequestId>("Request")

    final var fetched = FetchContext()
        private set

    override fun resetEnv() {
        fetched = FetchContext()
    }

    class FetchContext {
//    lateinit var traces: List<TraceEntity>
    }
}
