package cccev.f2.evidence.api.domain

import cccev.f2.evidence.api.domain.features.query.GetEvidenceTypeListsQueryFunction

interface EvidenceQueryApi {

    /**
     * Get Evidence Type List
     */
    fun getEvidenceTypeLists(): GetEvidenceTypeListsQueryFunction
}
