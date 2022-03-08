package cccev.f2.evidence.api.app.service

import cccev.core.dsl.Evidence
import cccev.core.dsl.EvidenceTypeId
import cccev.core.dsl.EvidenceTypeListBase
import cccev.core.dsl.InformationConceptId
import cccev.core.dsl.Requirement
import cccev.core.dsl.RequirementId
import cccev.f2.evidence.api.app.model.toDTO
import cccev.f2.evidence.api.domain.model.EvidenceTypeListDTOBase
import cccev.s2.request.app.RequestAggregateService
import cccev.s2.request.app.RequestFinderService
import cccev.s2.request.domain.features.command.RequestInitCommand
import cccev.s2.request.domain.model.Request
import cccev.s2.request.domain.model.RequestId
import cccev.s2.requirement.app.RequirementFinderService
import org.springframework.dao.DuplicateKeyException
import org.springframework.stereotype.Service
import s2.spring.utils.logger.Logger

@Service
class EvidenceApiFinderService(
    private val requestAggregateService: RequestAggregateService,
    private val requestFinderService: RequestFinderService,
    private val requirementFinderService: RequirementFinderService
) {
    private val logger by Logger()

    suspend fun getEvidenceTypeLists(
        requestId: RequestId, requirementId: RequirementId, conceptId: InformationConceptId? = null, evidenceTypeId: EvidenceTypeId? = null
    ): List<List<EvidenceTypeListDTOBase>> {
        val requirements = requirementFinderService.list(
            parent = requirementId,
            concept = conceptId,
            evidenceType = evidenceTypeId
        )

        try {
            RequestInitCommand(id = requestId, frameworkId = requirementId)
                .let { command -> requestAggregateService.init(command) }
                .let { event -> logger.info("Request [${event.id}]") }
        } catch (e: DuplicateKeyException) {
            logger.info("Request exists")
        }

        val request = requestFinderService.get(requestId)!!

        return requirements.evidenceTypeLists(request).distinctBy { evidenceTypeLists ->
            evidenceTypeLists.flatMap { it.specifiesEvidenceType }.joinToString { it.identifier }
        }
    }

    private fun List<Requirement>.evidenceTypeLists(request: Request): List<List<EvidenceTypeListDTOBase>> {
        val evidences = request.evidences.associateBy { it.isConformantTo.first() }
        return mapNotNull { requirement -> requirement.hasEvidenceTypeList?.toDTOs(evidences) }
    }

    private fun List<EvidenceTypeListBase>.toDTOs(evidences: Map<EvidenceTypeId, Evidence?>) = map { it.toDTO(evidences) }
}
