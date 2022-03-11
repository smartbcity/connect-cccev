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

/**
 * - fun init(): [RequestInitCommandFunction][cccev.f2.request.api.domain.features.command.RequestInitCommandFunction]
 * - fun addEvidence(): [RequestEvidenceAddCommandFunction][cccev.f2.request.api.domain.features.command.RequestEvidenceAddCommandFunction]
 * - fun removeEvidence(): [RequestEvidenceRemoveCommandFunction][cccev.f2.request.api.domain.features.command.RequestEvidenceRemoveCommandFunction]
 * - fun addSupportedValue(): [RequestSupportedValueAddCommandFunction][cccev.f2.request.api.domain.features.command.RequestSupportedValueAddCommandFunction]
 * - fun send(): [RequestSendCommandFunction][cccev.f2.request.api.domain.features.command.RequestSendCommandFunction]
 * - fun sign(): [RequestSignCommandFunction][cccev.f2.request.api.domain.features.command.RequestSignCommandFunction]
 * - fun audit(): [RequestAuditCommandFunction][cccev.f2.request.api.domain.features.command.RequestAuditCommandFunction]
 * - fun refuse(): [RequestRefuseCommandFunction][cccev.f2.request.api.domain.features.command.RequestRefuseCommandFunction]
 * @d2 model
 * @title Entrypoints
 * @page
 * Handle cccev request.
 * @@title Core Resources/Request
 */
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
