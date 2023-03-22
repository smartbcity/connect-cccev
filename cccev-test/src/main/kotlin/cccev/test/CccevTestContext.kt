package cccev.test

import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.evidence.domain.EvidenceTypeId
import cccev.s2.evidence.domain.EvidenceTypeListId
import cccev.s2.request.domain.model.EvidenceId
import cccev.s2.request.domain.model.RequestId
import cccev.s2.requirement.domain.RequirementId
import cccev.s2.requirement.domain.model.RequirementIdentifier
import cccev.s2.unit.domain.DataUnitId
import org.springframework.stereotype.Component
import s2.bdd.data.BddContext
import s2.bdd.data.TestContext
import s2.bdd.data.TestContextKey

@Component
class CccevTestContext(
    private val testContext: TestContext
): BddContext by testContext {

    val conceptIds = testContext.testEntities<TestContextKey, InformationConceptId>("InformationConcept")
    val conceptIdentifiers = testContext.testEntities<TestContextKey, String>("InformationConcept with identifier")
    val evidenceIds = testContext.testEntities<TestContextKey, EvidenceId>("Evidence")
    val evidenceTypeIds = testContext.testEntities<TestContextKey, EvidenceTypeId>("EvidenceType")
    val evidenceTypeIdentifiers = testContext.testEntities<TestContextKey, String>("EvidenceType with identifier")
    val evidenceTypeListIds = testContext.testEntities<TestContextKey, EvidenceTypeListId>("EvidenceTypeList")
    val evidenceTypeListIdentifiers = testContext.testEntities<TestContextKey, String>("EvidenceTypeList with identifier")
    val requestIds = testContext.testEntities<TestContextKey, RequestId>("Request")
    val requirementIds = testContext.testEntities<TestContextKey, RequirementId>("Requirement")
    val requirementIdentifiers = testContext.testEntities<TestContextKey, RequirementIdentifier>("Requirement with identifier")
    val unitIds = testContext.testEntities<TestContextKey, DataUnitId>("DataUnit")

    final var fetched = FetchContext()
        private set

    override fun resetEnv() {
        fetched = FetchContext()
    }

    class FetchContext {
//    lateinit var traces: List<TraceEntity>
    }
}
