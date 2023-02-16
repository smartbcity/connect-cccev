package cccev.s2.evidence.domain

import cccev.s2.evidence.domain.model.EvidenceType
import cccev.s2.evidence.domain.model.EvidenceTypeList

interface EvidenceTypeFinder {
    suspend fun getOrNull(id: EvidenceTypeId): EvidenceType?
    suspend fun get(id: EvidenceTypeId): EvidenceType

    suspend fun getListOrNull(id: EvidenceTypeListId): EvidenceTypeList?
    suspend fun getList(id: EvidenceTypeListId): EvidenceTypeList
}
