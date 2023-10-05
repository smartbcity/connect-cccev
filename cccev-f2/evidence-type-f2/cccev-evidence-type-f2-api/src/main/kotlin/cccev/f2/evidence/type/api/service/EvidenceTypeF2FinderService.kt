package cccev.f2.evidence.type.api.service

import cccev.f2.evidence.type.api.model.toDTO
import cccev.f2.evidence.type.domain.model.EvidenceTypeDTOBase
import cccev.f2.evidence.type.domain.model.EvidenceTypeListDTOBase
import cccev.s2.evidence.type.api.EvidenceTypeFinderService
import cccev.s2.evidence.type.domain.EvidenceTypeId
import cccev.s2.evidence.type.domain.EvidenceTypeIdentifier
import cccev.s2.evidence.type.domain.EvidenceTypeListId
import cccev.s2.evidence.type.domain.EvidenceTypeListIdentifier
import org.springframework.stereotype.Service

@Service
class EvidenceTypeF2FinderService(
    private val evidenceTypeFinderService: EvidenceTypeFinderService
) {
    suspend fun getOrNull(id: EvidenceTypeId): EvidenceTypeDTOBase? {
        return evidenceTypeFinderService.getOrNull(id)?.toDTO()
    }
    suspend fun getOrNullByIdentifier(id: EvidenceTypeIdentifier): EvidenceTypeDTOBase? {
        return evidenceTypeFinderService.getOrNullByIdentifier(id)?.toDTO()
    }

    suspend fun get(id: EvidenceTypeId): EvidenceTypeDTOBase {
        return evidenceTypeFinderService.get(id).toDTO()
    }

    suspend fun getListOrNull(id: EvidenceTypeListId): EvidenceTypeListDTOBase? {
        return evidenceTypeFinderService.getListOrNull(id)?.toDTO()
    }
    suspend fun getListOrNullByIdentifier(id: EvidenceTypeListIdentifier): EvidenceTypeListDTOBase? {
        return evidenceTypeFinderService.getListOrNullByIdentifier(id)?.toDTO()
    }

    suspend fun getList(id: EvidenceTypeId): EvidenceTypeListDTOBase {
        return evidenceTypeFinderService.getList(id).toDTO()
    }
}
