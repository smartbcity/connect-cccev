package cccev.s2.request.domain

import cccev.s2.request.domain.features.command.RequestAuditCommand
import cccev.s2.request.domain.features.command.RequestAuditedEvent
import cccev.s2.request.domain.features.command.RequestEvidenceAddCommand
import cccev.s2.request.domain.features.command.RequestEvidenceAddedEvent
import cccev.s2.request.domain.features.command.RequestEvidenceRemoveCommand
import cccev.s2.request.domain.features.command.RequestEvidenceRemovedEvent
import cccev.s2.request.domain.features.command.RequestInitCommand
import cccev.s2.request.domain.features.command.RequestInitializedEvent
import cccev.s2.request.domain.features.command.RequestRefuseCommand
import cccev.s2.request.domain.features.command.RequestRefusedEvent
import cccev.s2.request.domain.features.command.RequestSendCommand
import cccev.s2.request.domain.features.command.RequestSentEvent
import cccev.s2.request.domain.features.command.RequestSignCommand
import cccev.s2.request.domain.features.command.RequestSignedEvent
import cccev.s2.request.domain.features.command.RequestSupportedValueAddCommand
import cccev.s2.request.domain.features.command.RequestSupportedValueAddedEvent

interface RequestAggregate {

	suspend fun init(cmd: RequestInitCommand): RequestInitializedEvent
	suspend fun addEvidence(cmd: RequestEvidenceAddCommand): RequestEvidenceAddedEvent
	suspend fun removeEvidence(cmd: RequestEvidenceRemoveCommand): RequestEvidenceRemovedEvent
	suspend fun addSupportedValue(cmd: RequestSupportedValueAddCommand): RequestSupportedValueAddedEvent
	suspend fun send(cmd: RequestSendCommand): RequestSentEvent
	suspend fun sign(cmd: RequestSignCommand): RequestSignedEvent
	suspend fun audit(cmd: RequestAuditCommand): RequestAuditedEvent
	suspend fun refuse(cmd: RequestRefuseCommand): RequestRefusedEvent
}
