package cccev.f2.concept.api.service

import cccev.commons.model.SimpleCache
import cccev.core.dsl.EvidenceTypeId
import cccev.core.dsl.InformationConceptBase
import cccev.core.dsl.Requirement
import cccev.core.dsl.RequirementId
import cccev.f2.concept.api.model.toDTO
import cccev.f2.concept.api.model.toRequestDTO
import cccev.f2.concept.domain.model.InformationConceptDTOBase
import cccev.f2.concept.domain.model.RequestInformationConceptDTO
import cccev.f2.concept.domain.model.RequestInformationConceptDTOBase
import cccev.f2.evidence.api.model.toDTOs
import cccev.f2.unit.api.service.DataUnitF2FinderService
import cccev.s2.concept.api.InformationConceptFinderService
import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.concept.domain.model.InformationConcept
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
class InformationConceptF2FinderService(
    private val dataUnitF2FinderService: DataUnitF2FinderService,
    private val informationConceptFinderService: InformationConceptFinderService,
    private val requestAggregateService: RequestAggregateService,
    private val requestFinderService: RequestFinderService,
    private val deprecatedRequirementFinderService: DeprecatedRequirementFinderService
) {
    private val logger by Logger()

    suspend fun getOrNull(id: InformationConceptId): InformationConceptDTOBase? {
        return informationConceptFinderService.getOrNull(id)?.toDTO()
    }

    suspend fun get(id: InformationConceptId): InformationConceptDTOBase {
        return informationConceptFinderService.get(id).toDTO()
    }

    // TODO move to request-f2 module?
    suspend fun getInformationConcepts(
        requestId: RequestId, requirementId: RequirementId, evidenceTypeId: EvidenceTypeId? = null
    ): List<RequestInformationConceptDTO> {
        val requirement = deprecatedRequirementFinderService.list(
            parent = requirementId,
            evidenceType = evidenceTypeId
        )

        try {
            RequestInitCommand(id = requestId, frameworkId = requirementId)
                .let { command -> requestAggregateService.init(command) }
                .let { event -> logger.info("Request [${event.id}] initialized") }
        } catch (e: DuplicateKeyException) {
            logger.info("Request exists")
        }

        val request = requestFinderService.get(requestId)!!
        return requirement.informationConcepts(request)
    }

    private fun List<Requirement>.informationConcepts(request: Request): List<RequestInformationConceptDTO> {
        return flatMap { requirement -> requirement.hasConcept.orEmpty().toDTOs(requirement, request) }
    }

    private fun List<InformationConceptBase>.toDTOs(parent: Requirement, request: Request): List<RequestInformationConceptDTOBase> {
        val evidenceTypes = parent.hasEvidenceTypeList?.toDTOs(request.evidences).orEmpty()
        return map { ic -> ic.toRequestDTO(evidenceTypes, request.supportedValues[ic.identifier]) }
    }

    private suspend fun Collection<InformationConcept>.toDTOs(cache: Cache = Cache()) = map { it.toDTO(cache) }
    private suspend fun InformationConcept.toDTO(cache: Cache = Cache()) = toDTO(
        getUnit = cache.units::get
    )

    private inner class Cache {
        val units = SimpleCache(dataUnitF2FinderService::get)
    }
}
