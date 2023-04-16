package cccev.projection.api.entity.evidencetype

import cccev.s2.evidence.domain.EvidenceTypeEvent
import cccev.s2.evidence.domain.command.type.EvidenceTypeCreatedEvent
import org.springframework.stereotype.Service
import s2.sourcing.dsl.view.View

@Service
class EvidenceTypeEvolver: View<EvidenceTypeEvent, EvidenceTypeEntity> {

	override suspend fun evolve(
		event: EvidenceTypeEvent, model: EvidenceTypeEntity?
	): EvidenceTypeEntity? = when (event) {
		is EvidenceTypeCreatedEvent -> created(event)
		else -> TODO()
	}

	private suspend fun created(event: EvidenceTypeCreatedEvent): EvidenceTypeEntity {
		return EvidenceTypeEntity(
			id = event.id,
			identifier = event.identifier,
			name = event.name,
			description = event.description,
			validityPeriodConstraint = event.validityPeriodConstraint,
			status = event.status
		)
	}
}
