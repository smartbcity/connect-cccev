package cccev.f2.evidence.type.domain

import cccev.f2.evidence.type.domain.query.EvidenceTypeGetByIdentifierFunction
import cccev.f2.evidence.type.domain.query.EvidenceTypeGetFunction
import cccev.f2.evidence.type.domain.query.EvidenceTypeListGetByIdentifierFunction
import cccev.f2.evidence.type.domain.query.EvidenceTypeListGetFunction

interface EvidenceTypeQueryApi {

    fun evidenceTypeGet(): EvidenceTypeGetFunction
    fun evidenceTypeGetByIdentifier(): EvidenceTypeGetByIdentifierFunction
    fun evidenceTypeListGet(): EvidenceTypeListGetFunction
    fun evidenceTypeListGetByIdentifier(): EvidenceTypeListGetByIdentifierFunction
}
