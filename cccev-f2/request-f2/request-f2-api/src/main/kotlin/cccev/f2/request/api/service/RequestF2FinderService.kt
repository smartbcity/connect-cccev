package cccev.f2.request.api.service

import cccev.f2.concept.api.service.InformationConceptF2FinderService
import cccev.s2.request.api.RequestFinderService
import cccev.s2.request.domain.model.Request
import cccev.s2.request.domain.model.RequestId
import org.springframework.stereotype.Service

@Service
class RequestF2FinderService(
    private val informationConceptF2FinderService: InformationConceptF2FinderService,
    private val requestFinderService: RequestFinderService,
) {

    suspend fun getOrNull(id: RequestId): Request? {
        return requestFinderService.getOrNull(id)
    }

    suspend fun get(id: RequestId): Request {
        return requestFinderService.get(id)
    }

//    object Score {
//        const val VALUE = 50
//        const val EVIDENCE = 50
//    }
//
//    suspend fun getRequestScore(requestId: RequestId): GetRequestScoreQueryResult {
//        val request = requestFinderService.get(requestId)!!
//        val evidenceTypeLists = request.evidenceTypes().associateBy(EvidenceTypeListDTOBase::identifier)
//        val informationConcepts = request.informationConcepts()
//
//        val scorePerInformationConcept = informationConcepts
//            .filter { informationConcept -> informationConcept.expressionOfExpectedValue == null }
//            .associateBy(RequestInformationConceptDTO::identifier)
//            .mapValues { (_, informationConcept) ->
//                if (informationConcept.hasValue()) {
//                    Score.VALUE + informationConcept.computeEvidenceScore(evidenceTypeLists)
//                } else {
//                    0.0
//                }
//            }
//
//        return GetRequestScoreQueryResult(
//            score = scorePerInformationConcept.values.average(),
//            scorePerInformationConcept = scorePerInformationConcept
//        )
//    }
//
//    private suspend fun Request.evidenceTypes(): List<EvidenceTypeListDTOBase> {
//        return evidenceApiFinderService.getEvidenceTypeLists(requestId = id, requirementId = frameworkId).flatten()
//    }
//
//    private suspend fun Request.informationConcepts(): List<RequestInformationConceptDTO> {
//        return informationConceptF2FinderService.getInformationConcepts(requestId = id, requirementId = frameworkId)
//    }
//
//    private fun EvidenceTypeDTOBase.hasEvidence() = evidence != null
//    private fun RequestInformationConceptDTO.hasValue() = supportedValue.value != null
//
//    private fun RequestInformationConceptDTO.computeEvidenceScore(
//        actualEvidenceTypeLists: Map<EvidenceTypeListId, EvidenceTypeListDTOBase>
//    ): Double {
//        val scoreRatio = evidenceTypeChoices.evidenceTypeLists.map { evidenceTypeListId ->
//            actualEvidenceTypeLists[evidenceTypeListId]!!.score()
//        }.maxOrNull() ?: 0.0
//        return Score.EVIDENCE * scoreRatio
//    }
//
//    private fun EvidenceTypeListDTOBase.score(): Double {
//        val fulfilledCount = specifiesEvidenceType.count { it.hasEvidence() }
//        return fulfilledCount.toDouble() / specifiesEvidenceType.size
//    }
}
