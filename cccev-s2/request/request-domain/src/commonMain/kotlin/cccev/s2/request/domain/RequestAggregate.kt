package cccev.s2.request.domain

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

interface RequestAggregate {
	suspend fun create(command: RequestCreateCommand): RequestCreatedEvent
	suspend fun addValues(command: RequestAddValuesCommand): RequestAddedValuesEvent
	suspend fun addEvidence(command: RequestAddEvidenceCommand): RequestAddedEvidenceEvent
	suspend fun removeEvidence(command: RequestRemoveEvidenceCommand): RequestRemovedEvidenceEvent
	suspend fun addRequirements(command: RequestAddRequirementsCommand): RequestAddedRequirementsEvent
	suspend fun removeRequirements(command: RequestRemoveRequirementsCommand): RequestRemovedRequirementsEvent
}
