package cccev.projection.api.entity.certification

import cccev.projection.api.entity.concept.InformationConceptRepository
import cccev.projection.api.entity.evidencetype.EvidenceTypeRepository
import cccev.projection.api.entity.requirement.RequirementRepository
import cccev.s2.certification.domain.CertificationEvent
import cccev.s2.certification.domain.CertificationState
import cccev.s2.certification.domain.command.CertificationAddedEvidenceEvent
import cccev.s2.certification.domain.command.CertificationAddedRequirementsEvent
import cccev.s2.certification.domain.command.CertificationAddedValuesEvent
import cccev.s2.certification.domain.command.CertificationCreatedEvent
import cccev.s2.certification.domain.command.CertificationRemovedEvidenceEvent
import cccev.s2.certification.domain.command.CertificationRemovedRequirementsEvent
import java.util.UUID
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Service
import s2.sourcing.dsl.view.View

@Service
class CertificationEvolver(
	private val evidenceTypeRepository: EvidenceTypeRepository,
	private val informationConceptRepository: InformationConceptRepository,
	private val certificationRepository: CertificationRepository,
	private val requirementRepository: RequirementRepository,
): View<CertificationEvent, CertificationEntity> {

	override suspend fun evolve(event: CertificationEvent, model: CertificationEntity?): CertificationEntity? = when (event) {
		is CertificationCreatedEvent -> create(event)
		is CertificationAddedValuesEvent -> model?.addValues(event)
		is CertificationAddedEvidenceEvent -> model?.addEvidence(event)
		is CertificationRemovedEvidenceEvent -> model?.removeEvidence(event)
		is CertificationAddedRequirementsEvent -> model?.addRequirements(event)
		is CertificationRemovedRequirementsEvent -> model?.removeRequirements(event)
		else -> throw NotImplementedError("Evolution for event [${event::class.simpleName}] not implemented")
	}

	private suspend fun create(event: CertificationCreatedEvent) = CertificationEntity(
		id = event.id,
		status = CertificationState.CREATED,
		name = event.name,
		description = event.description,
		requirements = requirementRepository.findAllById(event.requirements).collectList().awaitSingle()
	)

	private suspend fun CertificationEntity.addValues(event: CertificationAddedValuesEvent) = apply {
		informationConceptRepository.findAllById(event.values.keys)
			.collectList().awaitSingle()
			.forEach { concept ->
				val existingSupportedValue = supportedValues.firstOrNull { it.providesValueFor.id == concept.id }
				if (existingSupportedValue == null) {
					supportedValues.add(SupportedValueEntity(
						id = UUID.randomUUID().toString(),
						providesValueFor = concept,
						value = event.values[concept.id]
					))
				} else {
					existingSupportedValue.value = event.values[concept.id]
				}
			}
	}

	private suspend fun CertificationEntity.addEvidence(event: CertificationAddedEvidenceEvent) = apply {
		val evidenceTypes = evidenceTypeRepository.findAllById(event.isConformantTo)
			.collectList().awaitSingle()

		evidences.add(EvidenceEntity(
			id = event.evidenceId,
			name = event.name,
			file = event.file,
			isConformantTo = evidenceTypes
		))
	}

	private suspend fun CertificationEntity.removeEvidence(event: CertificationRemovedEvidenceEvent) = apply {
		evidences.removeIf { it.id == event.evidenceId }
	}

	private suspend fun CertificationEntity.addRequirements(event: CertificationAddedRequirementsEvent) = apply {
		requirements.addAll(requirementRepository.findAllById(event.requirementIds).collectList().awaitSingle())
	}

	private suspend fun CertificationEntity.removeRequirements(event: CertificationRemovedRequirementsEvent) = apply {
		requirements.removeIf { it.id in event.requirementIds }
	}
}
