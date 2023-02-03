package cccev.f2.evidence.domain

import cccev.f2.evidence.domain.features.query.GetEvidenceTypeListsQueryFunction

interface EvidenceQueryApi {

    /**
     * Get Evidence Type List
     */
    fun getEvidenceTypeLists(): GetEvidenceTypeListsQueryFunction
}
