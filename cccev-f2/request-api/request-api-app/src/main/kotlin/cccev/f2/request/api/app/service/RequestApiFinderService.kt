package cccev.f2.request.api.app.service

import cccev.core.dsl.EvidenceTypeId
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
    private val requestFinderService: RequestFinderService
) {

    object Score {
        const val VALUE = 50
        const val EVIDENCE = 50
    }

    suspend fun getRequestScore(requestId: RequestId): GetRequestScoreQueryResult {
        val request = requestFinderService.get(requestId)!!
        val evidenceTypes = request.evidenceTypes()
        val informationConcepts = request.informationConcepts()

        val scorePerInformationConcept = informationConcepts
            .filter { informationConcept -> informationConcept.expressionOfExpectedValue == null }
            .associateBy(InformationConceptDTO::identifier)
            .mapValues { (_, informationConcept) ->
                if (informationConcept.hasValue()) {
                    Score.VALUE + informationConcept.computeEvidenceScore(evidenceTypes)
                } else {
                    0.0
                }
            }

        return GetRequestScoreQueryResult(
            score = scorePerInformationConcept.values.average(),
            scorePerInformationConcept = scorePerInformationConcept
        )
    }

    private suspend fun Request.evidenceTypes(): List<EvidenceTypeDTOBase> {
        return evidenceApiFinderService.getEvidenceTypeLists(requestId = id, requirementId = frameworkId)
            .flatMap { evidenceTypeLists -> evidenceTypeLists.flatMap(EvidenceTypeListDTOBase::specifiesEvidenceType) }
    }

    private suspend fun Request.informationConcepts(): List<InformationConceptDTO> {
        return conceptApiFinderService.getInformationConcepts(requestId = id, requirementId = frameworkId)
    }

    private fun EvidenceTypeDTOBase.hasEvidence() = evidence != null
    private fun InformationConceptDTO.hasValue() = supportedValue.value != null

    private fun InformationConceptDTO.computeEvidenceScore(actualEvidenceTypes: List<EvidenceTypeDTOBase>): Double {
        val scoreRatio = evidenceTypes.map { evidenceTypeIds ->
            val fulfilledCount = evidenceTypeIds.count { evidenceTypeId -> actualEvidenceTypes.isEvidenceTypeFulfilled(evidenceTypeId) }
            fulfilledCount.toDouble() / evidenceTypeIds.size
        }.maxOrNull() ?: 0.0
        return Score.EVIDENCE * scoreRatio
    }

    private fun List<EvidenceTypeDTOBase>.isEvidenceTypeFulfilled(evidenceTypeId: EvidenceTypeId) = any { evidenceType ->
        evidenceType.identifier == evidenceTypeId && evidenceType.hasEvidence()
    }
}
