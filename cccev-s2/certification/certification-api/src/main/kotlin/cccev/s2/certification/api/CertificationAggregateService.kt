package cccev.s2.certification.api

import cccev.s2.certification.api.entity.CertificationAutomateExecutor
import cccev.s2.certification.domain.CertificationAggregate
import cccev.s2.certification.domain.command.CertificationAddEvidenceCommand
import cccev.s2.certification.domain.command.CertificationAddRequirementsCommand
import cccev.s2.certification.domain.command.CertificationAddValuesCommand
import cccev.s2.certification.domain.command.CertificationAddedEvidenceEvent
import cccev.s2.certification.domain.command.CertificationAddedRequirementsEvent
import cccev.s2.certification.domain.command.CertificationAddedValuesEvent
import cccev.s2.certification.domain.command.CertificationCreateCommand
import cccev.s2.certification.domain.command.CertificationCreatedEvent
import cccev.s2.certification.domain.command.CertificationRemoveEvidenceCommand
import cccev.s2.certification.domain.command.CertificationRemoveRequirementsCommand
import cccev.s2.certification.domain.command.CertificationRemovedEvidenceEvent
import cccev.s2.certification.domain.command.CertificationRemovedRequirementsEvent
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CertificationAggregateService(
	private val automate: CertificationAutomateExecutor,
): CertificationAggregate {

	override suspend fun create(command: CertificationCreateCommand) = automate.init(command) {
		CertificationCreatedEvent(
			id = UUID.randomUUID().toString(),
			identifier = command.identifier,
			name = command.name,
			description = command.description,
			requirements = command.requirements,
		)
	}

	override suspend fun addValues(command: CertificationAddValuesCommand) = automate.transition(command) {
		CertificationAddedValuesEvent(
			id = command.id,
			values = command.values
		)
	}

	override suspend fun addEvidence(command: CertificationAddEvidenceCommand) = automate.transition(command) {
		CertificationAddedEvidenceEvent(
			id = command.id,
			evidenceId = UUID.randomUUID().toString(),
			name = command.name,
			file = command.file,
			url = command.url,
			isConformantTo = command.isConformantTo,
		)
	}

	override suspend fun removeEvidence(command: CertificationRemoveEvidenceCommand) = automate.transition(command) {
		CertificationRemovedEvidenceEvent(
			id = command.id,
			evidenceId = command.evidenceId
		)
	}

	override suspend fun addRequirements(command: CertificationAddRequirementsCommand) = automate.transition(command) {
		CertificationAddedRequirementsEvent(
			id = command.id,
			requirementIds = command.requirementIds
		)
	}

	override suspend fun removeRequirements(command: CertificationRemoveRequirementsCommand) = automate.transition(command) {
		CertificationRemovedRequirementsEvent(
			id = command.id,
			requirementIds = command.requirementIds
		)
	}
}
