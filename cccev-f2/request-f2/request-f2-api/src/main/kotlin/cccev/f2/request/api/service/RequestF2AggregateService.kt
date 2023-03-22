package cccev.f2.request.api.service

import cccev.s2.request.api.RequestAggregateService
import cccev.s2.request.domain.command.RequestAddEvidenceCommand
import cccev.s2.request.domain.command.RequestAddRequirementsCommand
import cccev.s2.request.domain.command.RequestAddValuesCommand
import cccev.s2.request.domain.command.RequestAddedEvidenceEvent
import cccev.s2.request.domain.command.RequestAddedRequirementsEvent
import cccev.s2.request.domain.command.RequestAddedValuesEvent
import cccev.s2.request.domain.command.RequestCreateCommand
import cccev.s2.request.domain.command.RequestCreatedEvent
import cccev.s2.request.domain.command.RequestRemoveEvidenceCommand
import cccev.s2.request.domain.command.RequestRemoveRequirementsCommand
import cccev.s2.request.domain.command.RequestRemovedEvidenceEvent
import cccev.s2.request.domain.command.RequestRemovedRequirementsEvent
import org.springframework.stereotype.Service

@Service
class RequestF2AggregateService(
    private val requestAggregateService: RequestAggregateService
) {
    suspend fun create(command: RequestCreateCommand): RequestCreatedEvent {
        return requestAggregateService.create(command)
    }

    suspend fun addRequirements(command: RequestAddRequirementsCommand): RequestAddedRequirementsEvent {
        return requestAggregateService.addRequirements(command)
    }

    suspend fun removeRequirements(command: RequestRemoveRequirementsCommand): RequestRemovedRequirementsEvent {
        return requestAggregateService.removeRequirements(command)
    }

    suspend fun addValues(command: RequestAddValuesCommand): RequestAddedValuesEvent {
        return requestAggregateService.addValues(command)
    }

    suspend fun addEvidence(command: RequestAddEvidenceCommand): RequestAddedEvidenceEvent {
        return requestAggregateService.addEvidence(command)
    }

    suspend fun removeEvidence(command: RequestRemoveEvidenceCommand): RequestRemovedEvidenceEvent {
        return requestAggregateService.removeEvidence(command)
    }
}
