package cccev.projection.api.entity.request

import cccev.s2.request.domain.RequestEvent
import cccev.s2.request.domain.RequestState
import cccev.s2.request.domain.features.command.RequestAuditedEvent
import cccev.s2.request.domain.features.command.RequestEvidenceAddedEvent
import cccev.s2.request.domain.features.command.RequestEvidenceRemovedEvent
import cccev.s2.request.domain.features.command.RequestInitializedEvent
import cccev.s2.request.domain.features.command.RequestRefusedEvent
import cccev.s2.request.domain.features.command.RequestSentEvent
import cccev.s2.request.domain.features.command.RequestSignedEvent
import cccev.s2.request.domain.features.command.RequestSupportedValueAddCommand
import cccev.s2.request.domain.features.command.RequestSupportedValueAddedEvent
import cccev.s2.request.domain.model.RequestId
import org.springframework.stereotype.Service
import s2.dsl.automate.S2Event
import s2.dsl.automate.model.WithS2State
import s2.sourcing.dsl.view.View

@Service
class RequestEvolver(
	private val requestRepository: RequestRepository,
): View<RequestEvent, RequestEntity> {


	override suspend fun evolve(event: RequestEvent, model: RequestEntity?): RequestEntity? = when (event) {
		is RequestAuditedEvent -> model?.audit(event)
		is RequestEvidenceAddedEvent -> model?.addEvidence(event)
		is RequestEvidenceRemovedEvent -> model?.removeEvidence(event)
		is RequestInitializedEvent -> init(event)
		is RequestRefusedEvent -> model?.refuse(event)
		is RequestSentEvent -> model?.send(event)
		is RequestSignedEvent -> model?.sign(event)
		is RequestSupportedValueAddedEvent -> model?.addSupportedValue(event)
		else -> model
	}
	private suspend fun RequestEntity.audit(cmd: RequestAuditedEvent) = this.apply {
		this.status = cmd.type
	}

	private suspend fun RequestEntity.addEvidence(cmd: RequestEvidenceAddedEvent) = this.apply {
		evidences.add(cmd.evidence)
	}

	private suspend fun RequestEntity.removeEvidence(cmd: RequestEvidenceRemovedEvent) = this.apply {
		evidences.removeIf { evidence -> cmd.evidenceTypeId in evidence.isConformantTo }
	}

	private suspend fun init(cmd: RequestInitializedEvent): RequestEntity {
		return RequestEntity().apply {
			id = cmd.id
			status = RequestState.Created
			frameworkId = cmd.frameworkId
			evidences = mutableListOf()
			supportedValues = mutableMapOf()
		}
	}


	private suspend fun RequestEntity.refuse(cmd: RequestRefusedEvent) = updateStatus(cmd)

	private suspend fun RequestEntity.send(cmd: RequestSentEvent) = updateStatus(cmd)

	private suspend fun RequestEntity.sign(cmd: RequestSignedEvent) = updateStatus(cmd)


	private fun RequestEntity.updateStatus(cmd: S2Event<RequestState, RequestId>) = this.apply {
		status = cmd.type
	}

	private suspend fun RequestEntity.addSupportedValue(cmd: RequestSupportedValueAddedEvent) = this.apply {
		supportedValues[cmd.supportedValue.providesValueFor] = cmd.supportedValue
	}

}
