package cccev.test.s2.request.data

import cccev.dsl.model.Evidence
import cccev.dsl.model.EvidenceId
import cccev.dsl.model.FrameworkId
import cccev.dsl.model.SupportedValue
import cccev.dsl.model.SupportedValueId
import cccev.projection.api.entity.request.RequestEntity
import cccev.projection.api.entity.request.RequestRepository
import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.evidence.domain.EvidenceTypeListId
import cccev.s2.request.domain.RequestState
import cccev.s2.request.domain.model.RequestId
import s2.bdd.repository.AssertionCrudEntity
import s2.bdd.assertion.AssertionBdd
import org.assertj.core.api.Assertions

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
            frameworkId: FrameworkId? = request.frameworkId,
            evidences: List<EvidenceId>? = request.evidences.map { it.id },
//            supportedValues: List<SupportedValueId>? = request.supportedValues.values.map { it.identifier },
        ) = also {
            Assertions.assertThat(request.id).isEqualTo(id)
            Assertions.assertThat(request.status).isEqualTo(status)
            Assertions.assertThat(request.frameworkId).isEqualTo(frameworkId)
            Assertions.assertThat(request.evidences.map { it.identifier })
                .containsExactlyInAnyOrderElementsOf(evidences)
//            Assertions.assertThat(request.supportedValues.values.map { it.identifier })
//                .containsExactlyInAnyOrderElementsOf(supportedValues)
        }

        fun hasEvidences(ids: Collection<EvidenceId>) {
            Assertions.assertThat(request.evidences.map { it.identifier }).containsAll(ids)
        }

        fun hasSupportedValues(ids: Collection<SupportedValueId>) {
            TODO()
//            Assertions.assertThat(request.supportedValues.values.map { it.identifier }).containsAll(ids)
        }
    }
}
