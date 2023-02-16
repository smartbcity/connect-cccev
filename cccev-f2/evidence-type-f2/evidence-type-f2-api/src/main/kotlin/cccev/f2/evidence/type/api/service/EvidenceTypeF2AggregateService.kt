package cccev.f2.evidence.type.api.service

import cccev.s2.evidence.api.EvidenceTypeAggregateService
import cccev.s2.evidence.domain.command.list.EvidenceTypeListCreateCommand
import cccev.s2.evidence.domain.command.list.EvidenceTypeListCreatedEvent
import cccev.s2.evidence.domain.command.list.EvidenceTypeListUpdateCommand
import cccev.s2.evidence.domain.command.list.EvidenceTypeListUpdatedEvent
import cccev.s2.evidence.domain.command.type.EvidenceTypeCreateCommand
import cccev.s2.evidence.domain.command.type.EvidenceTypeCreatedEvent
import org.springframework.stereotype.Service

@Service
class EvidenceTypeF2AggregateService(
    private val evidenceTypeAggregateService: EvidenceTypeAggregateService
) {
    suspend fun create(command: EvidenceTypeCreateCommand): EvidenceTypeCreatedEvent {
        return evidenceTypeAggregateService.create(command)
    }

    suspend fun createList(command: EvidenceTypeListCreateCommand): EvidenceTypeListCreatedEvent {
        return evidenceTypeAggregateService.createList(command)
    }

    suspend fun updateList(command: EvidenceTypeListUpdateCommand): EvidenceTypeListUpdatedEvent {
        return evidenceTypeAggregateService.updateList(command)
    }
}
