package cccev.f2.request.api.app.service

import cccev.core.dsl.EvidenceTypeListId
import cccev.f2.concept.api.app.service.ConceptApiFinderService
import cccev.f2.concept.api.domain.model.InformationConceptDTO
import cccev.f2.evidence.api.app.service.EvidenceApiFinderService
import cccev.f2.evidence.api.domain.model.EvidenceTypeDTOBase
import cccev.f2.evidence.api.domain.model.EvidenceTypeListDTOBase
import cccev.f2.request.api.domain.features.query.GetRequestScoreQueryResult
import cccev.s2.request.app.RequestFinderService
import cccev.s2.request.domain.model.Request
import cccev.s2.request.domain.model.RequestId
import org.springframework.stereotype.Service

@Service
class RequestApiFinderService(
    private val conceptApiFinderService: ConceptApiFinderService,
    private val evidenceApiFinderService: EvidenceApiFinderService,
    private val requestFinderService: RequestFinderService,
) {

    object Score {
        const val VALUE = 50
        const val EVIDENCE = 50
    }

    suspend fun getRequestScore(requestId: RequestId): GetRequestScoreQueryResult {
        val request = requestFinderService.get(requestId)!!
        val evidenceTypeLists = request.evidenceTypes().associateBy(EvidenceTypeListDTOBase::identifier)
        val informationConcepts = request.informationConcepts()

        val scorePerInformationConcept = informationConcepts
            .filter { informationConcept -> informationConcept.expressionOfExpectedValue == null }
            .associateBy(InformationConceptDTO::identifier)
            .mapValues { (_, informationConcept) ->
                if (informationConcept.hasValue()) {
                    Score.VALUE + informationConcept.computeEvidenceScore(evidenceTypeLists)
                } else {
                    0.0
                }
            }

        return GetRequestScoreQueryResult(
            score = scorePerInformationConcept.values.average(),
            scorePerInformationConcept = scorePerInformationConcept
        )
    }

    private suspend fun Request.evidenceTypes(): List<EvidenceTypeListDTOBase> {
        return evidenceApiFinderService.getEvidenceTypeLists(requestId = id, requirementId = frameworkId).flatten()
    }

    private suspend fun Request.informationConcepts(): List<InformationConceptDTO> {
        return conceptApiFinderService.getInformationConcepts(requestId = id, requirementId = frameworkId)
    }

    private fun EvidenceTypeDTOBase.hasEvidence() = evidence != null
    private fun InformationConceptDTO.hasValue() = supportedValue.value != null

    private fun InformationConceptDTO.computeEvidenceScore(
        actualEvidenceTypeLists: Map<EvidenceTypeListId, EvidenceTypeListDTOBase>
    ): Double {
        val scoreRatio = evidenceTypeChoices.evidenceTypeLists.map { evidenceTypeListId ->
            actualEvidenceTypeLists[evidenceTypeListId]!!.score()
        }.maxOrNull() ?: 0.0
        return Score.EVIDENCE * scoreRatio
    }

    private fun EvidenceTypeListDTOBase.score(): Double {
        val fulfilledCount = specifiesEvidenceType.count { it.hasEvidence() }
        return fulfilledCount.toDouble() / specifiesEvidenceType.size
    }
}
