package cccev.f2.evidence.type.api.service

import cccev.f2.evidence.type.api.model.toDTO
import cccev.f2.evidence.type.domain.model.EvidenceTypeDTOBase
import cccev.f2.evidence.type.domain.model.EvidenceTypeListDTOBase
import cccev.s2.evidence.api.EvidenceTypeFinderService
import cccev.s2.evidence.domain.EvidenceTypeId
import org.springframework.stereotype.Service

@Service
class EvidenceTypeF2FinderService(
    private val evidenceTypeFinderService: EvidenceTypeFinderService
) {
    suspend fun getOrNull(id: EvidenceTypeId): EvidenceTypeDTOBase? {
        return evidenceTypeFinderService.getOrNull(id)?.toDTO()
    }

    suspend fun get(id: EvidenceTypeId): EvidenceTypeDTOBase {
        return evidenceTypeFinderService.get(id).toDTO()
    }

    suspend fun getListOrNull(id: EvidenceTypeId): EvidenceTypeListDTOBase? {
        return evidenceTypeFinderService.getListOrNull(id)?.toDTO()
    }

    suspend fun getList(id: EvidenceTypeId): EvidenceTypeListDTOBase {
        return evidenceTypeFinderService.getList(id).toDTO()
    }
}
