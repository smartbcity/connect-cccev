package cccev.s2.request.api

import cccev.s2.request.api.entity.RequestAutomateExecutor
import cccev.s2.request.domain.RequestAggregate
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
import java.util.UUID

@Service
class RequestAggregateService(
	private val automate: RequestAutomateExecutor,
): RequestAggregate {

	override suspend fun create(command: RequestCreateCommand) = automate.init(command) {
		RequestCreatedEvent(
			id = UUID.randomUUID().toString(),
			name = command.name,
			description = command.description,
			requirements = command.requirements,
		)
	}

	override suspend fun addValues(command: RequestAddValuesCommand) = automate.transition(command) {
		RequestAddedValuesEvent(
			id = command.id,
			values = command.values
		)
	}

	override suspend fun addEvidence(command: RequestAddEvidenceCommand) = automate.transition(command) {
		RequestAddedEvidenceEvent(
			id = command.id,
			evidenceId = UUID.randomUUID().toString(),
			name = command.name,
			file = command.file,
			url = command.url,
			isConformantTo = command.isConformantTo,
		)
	}

	override suspend fun removeEvidence(command: RequestRemoveEvidenceCommand) = automate.transition(command) {
		RequestRemovedEvidenceEvent(
			id = command.id,
			evidenceId = command.evidenceId
		)
	}

	override suspend fun addRequirements(command: RequestAddRequirementsCommand) = automate.transition(command) {
		RequestAddedRequirementsEvent(
			id = command.id,
			requirementIds = command.requirementIds
		)
	}

	override suspend fun removeRequirements(command: RequestRemoveRequirementsCommand) = automate.transition(command) {
		RequestRemovedRequirementsEvent(
			id = command.id,
			requirementIds = command.requirementIds
		)
	}
}
