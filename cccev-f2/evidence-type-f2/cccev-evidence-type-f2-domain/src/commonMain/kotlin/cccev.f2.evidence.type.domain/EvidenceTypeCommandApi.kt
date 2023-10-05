package cccev.f2.evidence.type.domain

import cccev.f2.evidence.type.domain.command.list.EvidenceTypeListCreateFunction
import cccev.f2.evidence.type.domain.command.list.EvidenceTypeListUpdateFunction
import cccev.f2.evidence.type.domain.command.type.EvidenceTypeCreateFunction

interface EvidenceTypeCommandApi {
    fun evidenceTypeCreate(): EvidenceTypeCreateFunction
    fun evidenceTypeListCreate(): EvidenceTypeListCreateFunction
    fun evidenceTypeListUpdate(): EvidenceTypeListUpdateFunction
}
