package cccev.test

import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.evidence.domain.EvidenceTypeId
import cccev.s2.evidence.domain.EvidenceTypeListId
import cccev.s2.framework.domain.FrameworkId
import cccev.s2.request.domain.model.EvidenceId
import cccev.s2.request.domain.model.Request
import cccev.s2.request.domain.model.RequestId
import cccev.s2.requirement.domain.RequirementId
import cccev.s2.unit.domain.DataUnitId
import org.springframework.stereotype.Component
import s2.bdd.data.TestContext
import s2.bdd.data.TestContextKey

@Component
class CccevTestContext: TestContext() {

    val conceptIds = testEntities<TestContextKey, InformationConceptId>("InformationConcept")
    val frameworkIds = testEntities<TestContextKey, FrameworkId>("Framework")
    val evidenceIds = testEntities<TestContextKey, EvidenceId>("Evidence")
    val evidenceTypeIds = testEntities<TestContextKey, EvidenceTypeId>("EvidenceType")
    val evidenceTypeListIds = testEntities<TestContextKey, EvidenceTypeListId>("EvidenceTypeList")
    val requestIds = testEntities<TestContextKey, RequestId>("Request")
    val requirementIds = testEntities<TestContextKey, RequirementId>("Requirement")
    val unitIds = testEntities<TestContextKey, DataUnitId>("DataUnit")

    final var fetched = FetchContext()
        private set

    override fun resetEnv() {
        fetched = FetchContext()
    }

    class FetchContext {
        lateinit var request: Request
    }
}
