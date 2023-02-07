package cccev.f2.requirement.api.service

import cccev.commons.model.SimpleCache
import cccev.f2.concept.api.service.InformationConceptF2FinderService
import cccev.f2.evidence.type.api.service.EvidenceTypeF2FinderService
import cccev.f2.requirement.api.model.toDTO
import cccev.f2.requirement.domain.model.RequirementDTOBase
import cccev.s2.requirement.api.RequirementFinderService
import cccev.s2.requirement.domain.RequirementId
import cccev.s2.requirement.domain.model.Requirement
import org.springframework.stereotype.Service

@Service
class RequirementF2FinderService(
    private val evidenceTypeF2FinderService: EvidenceTypeF2FinderService,
    private val informationConceptF2FinderService: InformationConceptF2FinderService,
    private val requirementFinderService: RequirementFinderService
) {
    suspend fun getOrNull(id: RequirementId): RequirementDTOBase? {
        return requirementFinderService.getOrNull(id)?.toDTO()
    }

    suspend fun get(id: RequirementId): RequirementDTOBase {
        return requirementFinderService.get(id).toDTO()
    }

    private suspend fun Collection<Requirement>.toDTOs(cache: Cache = Cache()) = map { it.toDTO() }
    private suspend fun Requirement.toDTO(cache: Cache = Cache()): RequirementDTOBase = toDTO(
        getConcept = cache.concepts::get,
        getEvidenceTypeList = cache.evidenceTypeLists::get,
        getRequirement = cache.requirements::get,
    )

    private inner class Cache {
        val concepts = SimpleCache(informationConceptF2FinderService::get)
        val evidenceTypeLists = SimpleCache(evidenceTypeF2FinderService::getList)
        val requirements = SimpleCache<RequirementId, RequirementDTOBase> { id -> requirementFinderService.get(id).toDTO(this)}
    }
}
