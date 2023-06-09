package cccev.f2.certification.api.service

import cccev.f2.concept.api.service.InformationConceptF2FinderService
import cccev.s2.certification.api.CertificationFinderService
import cccev.s2.certification.domain.model.Certification
import cccev.s2.certification.domain.model.CertificationId
import cccev.s2.certification.domain.model.CertificationIdentifier
import org.springframework.stereotype.Service

@Service
class CertificationF2FinderService(
    private val informationConceptF2FinderService: InformationConceptF2FinderService,
    private val certificationFinderService: CertificationFinderService,
) {

    suspend fun getOrNull(id: CertificationId): Certification? {
        return certificationFinderService.getOrNull(id)
    }

    suspend fun get(id: CertificationId): Certification {
        return certificationFinderService.get(id)
    }

    suspend fun getOrNullByIdentifier(identifier: CertificationIdentifier): Certification? {
        return certificationFinderService.getOrNullByIdentifier(identifier)
    }

    suspend fun getByIdentifier(identifier: CertificationIdentifier): Certification {
        return certificationFinderService.getByIdentifier(identifier)
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
