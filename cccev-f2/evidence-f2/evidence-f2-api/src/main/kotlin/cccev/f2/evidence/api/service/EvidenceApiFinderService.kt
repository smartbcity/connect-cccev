package cccev.f2.evidence.api.service

import cccev.core.dsl.EvidenceTypeId
import cccev.core.dsl.InformationConceptId
import cccev.core.dsl.Requirement
import cccev.core.dsl.RequirementId
import cccev.f2.evidence.api.model.toDTOs
import cccev.f2.evidence.domain.model.EvidenceTypeListDTOBase
import cccev.s2.request.api.RequestAggregateService
import cccev.s2.request.api.RequestFinderService
import cccev.s2.request.domain.features.command.RequestInitCommand
import cccev.s2.request.domain.model.Request
import cccev.s2.request.domain.model.RequestId
import cccev.s2.requirement.api.DeprecatedRequirementFinderService
import org.springframework.dao.DuplicateKeyException
import org.springframework.stereotype.Service
import s2.spring.utils.logger.Logger

@Service
class EvidenceApiFinderService(
    private val requestAggregateService: RequestAggregateService,
    private val requestFinderService: RequestFinderService,
    private val deprecatedRequirementFinderService: DeprecatedRequirementFinderService
) {
    private val logger by Logger()

    suspend fun getEvidenceTypeLists(
        requestId: RequestId, requirementId: RequirementId, conceptId: InformationConceptId? = null, evidenceTypeId: EvidenceTypeId? = null
    ): List<List<EvidenceTypeListDTOBase>> {
        val requirements = deprecatedRequirementFinderService.list(
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

    private fun List<Requirement>.evidenceTypeLists(request: Request) = mapNotNull { requirement ->
        requirement.hasEvidenceTypeList?.toDTOs(request.evidences)
    }
}
