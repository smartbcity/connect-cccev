package cccev.s2.request.api

import cccev.s2.request.api.config.RequestDecider
import cccev.s2.request.domain.RequestAggregate
import cccev.s2.request.domain.RequestState
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
import org.springframework.stereotype.Service

@Service
class RequestAggregateService(
	private val aggregate: RequestDecider,
): RequestAggregate {

	override suspend fun init(cmd: RequestInitCommand) = aggregate.init(cmd) {
		RequestInitializedEvent(
			id = cmd.id,
			type = RequestState.Created,
			frameworkId = cmd.frameworkId,
		)
	}

	override suspend fun addEvidence(
		cmd: RequestEvidenceAddCommand
	) = aggregate.transition(cmd) { entity ->
		RequestEvidenceAddedEvent(
			id = entity.id,
			evidence = cmd.evidence
		)
	}

	override suspend fun removeEvidence(
		cmd: RequestEvidenceRemoveCommand
	) = aggregate.transition(cmd) { entity ->
		RequestEvidenceRemovedEvent(
			id = entity.id,
			evidenceTypeId = cmd.evidenceTypeId
		)
	}

	override suspend fun addSupportedValue(
		cmd: RequestSupportedValueAddCommand
	) = aggregate.transition(cmd) { entity ->
		RequestSupportedValueAddedEvent(
			id = entity.id,
			supportedValue = cmd.supportedValue
		)
	}

	override suspend fun send(cmd: RequestSendCommand) = aggregate.transition(cmd) { entity ->
		RequestSentEvent(id = entity.id)
	}

	override suspend fun sign(cmd: RequestSignCommand) = aggregate.transition(cmd) { entity ->
		RequestSignedEvent(id = entity.id)
	}

	override suspend fun audit(cmd: RequestAuditCommand) = aggregate.transition(cmd) { entity ->
		RequestAuditedEvent(id = entity.id)
	}

	override suspend fun refuse(cmd: RequestRefuseCommand) = aggregate.transition(cmd) { entity ->
		RequestRefusedEvent(id = entity.id)
	}


}
