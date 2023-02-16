package cccev.s2.request.api

import cccev.s2.request.api.config.RequestS2Aggregate
import cccev.s2.request.api.entity.RequestEntity
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
import cccev.s2.request.domain.model.RequestId
import org.springframework.stereotype.Service
import s2.dsl.automate.S2Event

@Service
class RequestAggregateService(
	private val aggregate: RequestS2Aggregate,
): RequestAggregate {

	override suspend fun init(cmd: RequestInitCommand) = aggregate.createWithEvent(cmd, { RequestInitializedEvent(id) }) {
		RequestEntity(
			id = cmd.id,
			status = RequestState.Created,
			frameworkId = cmd.frameworkId,
			evidences = mutableListOf(),
			supportedValues = mutableMapOf()
		)
	}

	override suspend fun addEvidence(cmd: RequestEvidenceAddCommand) = aggregate.doTransition(cmd) {
		evidences.add(cmd.evidence)
		this to RequestEvidenceAddedEvent(
			id = id,
			evidenceId = cmd.evidence.identifier
		)
	}

	override suspend fun removeEvidence(cmd: RequestEvidenceRemoveCommand) = aggregate.doTransition(cmd) {
		evidences.removeIf { evidence -> cmd.evidenceTypeId in evidence.isConformantTo }

		this to RequestEvidenceRemovedEvent(
			id = id,
			evidenceTypeId = cmd.evidenceTypeId
		)
	}

	override suspend fun addSupportedValue(cmd: RequestSupportedValueAddCommand) = aggregate.doTransition(cmd) {
		supportedValues[cmd.supportedValue.providesValueFor] = cmd.supportedValue

		this to RequestSupportedValueAddedEvent(
			id = id,
			providesValueFor = cmd.supportedValue.providesValueFor
		)
	}

	override suspend fun send(cmd: RequestSendCommand) = aggregate.doTransition(cmd) {
		this to updateStatus {
			RequestSentEvent(id = id)
		}
	}

	override suspend fun sign(cmd: RequestSignCommand) = aggregate.doTransition(cmd) {
		this to updateStatus {
			RequestSignedEvent(id = id)
		}
	}

	override suspend fun audit(cmd: RequestAuditCommand) = aggregate.doTransition(cmd) {
		this to updateStatus {
			RequestAuditedEvent(id = id)
		}
	}

	override suspend fun refuse(cmd: RequestRefuseCommand) = aggregate.doTransition(cmd) {
		this to updateStatus {
			RequestRefusedEvent(id = id)
		}
	}

	private fun <E: S2Event<RequestState, RequestId>> RequestEntity.updateStatus(buildEvent: () -> E): E {
		return buildEvent().also { event -> status = event.type }
	}

}
