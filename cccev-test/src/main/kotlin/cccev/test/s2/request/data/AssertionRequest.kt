package cccev.test.s2.request.data

import cccev.projection.api.entity.request.EvidenceEntity
import cccev.projection.api.entity.request.RequestEntity
import cccev.projection.api.entity.request.RequestRepository
import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.evidence.domain.EvidenceTypeId
import cccev.s2.request.domain.RequestState
import cccev.s2.request.domain.model.EvidenceId
import cccev.s2.request.domain.model.RequestId
import cccev.s2.requirement.domain.RequirementId
import city.smartb.fs.s2.file.domain.model.FilePath
import org.assertj.core.api.Assertions
import s2.bdd.assertion.AssertionBdd
import s2.bdd.repository.AssertionCrudEntity

fun AssertionBdd.request(conceptRepository: RequestRepository) = AssertionRequest(conceptRepository)

class AssertionRequest(
    override val repository: RequestRepository
): AssertionCrudEntity<RequestEntity, RequestId, AssertionRequest.RequestAssert>() {

    override suspend fun assertThat(entity: RequestEntity) = RequestAssert(entity)

    inner class RequestAssert(
        private val request: RequestEntity
    ) {
        fun hasFields(
            id: RequestId = request.id,
            status: RequestState = request.status,
            name: String? = request.name,
            description: String? = request.description,
            startDate: Long? = request.startDate,
            endDate: Long? = request.endDate,
            estimatedEndDate: Long? = request.estimatedEndDate,
            creator: String? = request.creator,
            executor: String? = request.executor,
            validator: String? = request.validator,
            isPublic: Boolean = request.isPublic,
            issuable: Boolean = request.issuable,
            verifiable: Boolean = request.verifiable,
            verifier: String? = request.verifier,
            verificationDate: Long? = request.verificationDate,
            requirements: Collection<RequirementId> = request.requirements.map { it.id },
            evidences: Collection<EvidenceId> = request.evidences.map { it.id },
            supportedValues: Map<InformationConceptId, String?> = request.supportedValues.associate { it.providesValueFor.id to it.value }
        ) = also {
            Assertions.assertThat(request.id).isEqualTo(id)
            Assertions.assertThat(request.status).isEqualTo(status)
            Assertions.assertThat(request.name).isEqualTo(name)
            Assertions.assertThat(request.description).isEqualTo(description)
            Assertions.assertThat(request.startDate).isEqualTo(startDate)
            Assertions.assertThat(request.endDate).isEqualTo(endDate)
            Assertions.assertThat(request.estimatedEndDate).isEqualTo(estimatedEndDate)
            Assertions.assertThat(request.creator).isEqualTo(creator)
            Assertions.assertThat(request.executor).isEqualTo(executor)
            Assertions.assertThat(request.validator).isEqualTo(validator)
            Assertions.assertThat(request.isPublic).isEqualTo(isPublic)
            Assertions.assertThat(request.issuable).isEqualTo(issuable)
            Assertions.assertThat(request.verifiable).isEqualTo(verifiable)
            Assertions.assertThat(request.verifier).isEqualTo(verifier)
            Assertions.assertThat(request.verificationDate).isEqualTo(verificationDate)
            Assertions.assertThat(request.requirements.map { it.id }).containsExactlyInAnyOrderElementsOf(requirements)
            Assertions.assertThat(request.evidences.map { it.id }).containsExactlyInAnyOrderElementsOf(evidences)
            Assertions.assertThat(request.supportedValues.associate { it.providesValueFor.id to it.value })
                .containsExactlyInAnyOrderEntriesOf(supportedValues)
        }

        fun hasRequirements(ids: Collection<RequirementId>) {
            Assertions.assertThat(request.requirements.map { it.id }).containsAll(ids)
        }

        fun doesNotHaveRequirements(ids: Collection<RequirementId>) {
            Assertions.assertThat(request.requirements.map { it.id }).doesNotContainAnyElementsOf(ids)
        }

        fun hasEvidences(ids: Collection<EvidenceId>) {
            Assertions.assertThat(request.evidences.map { it.id }).containsAll(ids)
        }

        fun doesNotHaveEvidences(ids: Collection<EvidenceId>) {
            Assertions.assertThat(request.evidences.map { it.id }).doesNotContainAnyElementsOf(ids)
        }

        fun assertThatEvidence(id: EvidenceId): EvidenceAssert {
            hasEvidences(listOf(id))
            return EvidenceAssert(request.evidences.first { it.id == id})
        }

        fun hasSupportedValues(values: Map<InformationConceptId, String?>) {
            val requestValues = request.supportedValues.associateBy { it.providesValueFor.id }
            values.forEach { (conceptId, value) ->
                Assertions.assertThat(requestValues.keys).contains(conceptId)
                val supportedValue = requestValues[conceptId]!!
                Assertions.assertThat(supportedValue.value).isEqualTo(value)
            }
        }
    }

    inner class EvidenceAssert(
        private val evidence: EvidenceEntity
    ) {
        fun hasFields(
            id: EvidenceId = evidence.id,
            name: String = evidence.name,
            file: FilePath? = evidence.file,
            url: String? = evidence.url,
            isConformantTo: List<EvidenceTypeId> = evidence.isConformantTo.map { it.id }
        ) {
            Assertions.assertThat(evidence.id).isEqualTo(id)
            Assertions.assertThat(evidence.name).isEqualTo(name)
            Assertions.assertThat(evidence.file).isEqualTo(file)
            Assertions.assertThat(evidence.url).isEqualTo(url)
            Assertions.assertThat(evidence.isConformantTo.map { it.id }).containsExactlyInAnyOrderElementsOf(isConformantTo)
        }
    }
}
