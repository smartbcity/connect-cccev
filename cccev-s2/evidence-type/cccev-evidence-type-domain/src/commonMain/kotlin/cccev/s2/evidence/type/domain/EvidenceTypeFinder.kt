package cccev.s2.evidence.type.domain

import cccev.s2.evidence.type.domain.model.EvidenceType
import cccev.s2.evidence.type.domain.model.EvidenceTypeList

interface EvidenceTypeFinder {
    suspend fun getOrNull(id: EvidenceTypeId): EvidenceType?
    suspend fun getOrNullByIdentifier(id: EvidenceTypeIdentifier): EvidenceType?
    suspend fun get(id: EvidenceTypeId): EvidenceType

    suspend fun getListOrNull(id: EvidenceTypeListId): EvidenceTypeList?
    suspend fun getListOrNullByIdentifier(id: EvidenceTypeListIdentifier): EvidenceTypeList?
    suspend fun getList(id: EvidenceTypeListId): EvidenceTypeList

}
