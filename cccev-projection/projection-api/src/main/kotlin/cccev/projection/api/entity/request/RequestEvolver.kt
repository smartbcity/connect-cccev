package cccev.projection.api.entity.request

import cccev.projection.api.entity.concept.InformationConceptRepository
import cccev.projection.api.entity.evidencetype.EvidenceTypeRepository
import cccev.projection.api.entity.requirement.RequirementRepository
import cccev.s2.request.domain.RequestEvent
import cccev.s2.request.domain.RequestState
import cccev.s2.request.domain.command.RequestAddedEvidenceEvent
import cccev.s2.request.domain.command.RequestAddedRequirementsEvent
import cccev.s2.request.domain.command.RequestAddedValuesEvent
import cccev.s2.request.domain.command.RequestCreatedEvent
import cccev.s2.request.domain.command.RequestRemovedEvidenceEvent
import cccev.s2.request.domain.command.RequestRemovedRequirementsEvent
import java.util.UUID
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Service
import s2.sourcing.dsl.view.View

@Service
class RequestEvolver(
	private val evidenceTypeRepository: EvidenceTypeRepository,
	private val informationConceptRepository: InformationConceptRepository,
	private val requestRepository: RequestRepository,
	private val requirementRepository: RequirementRepository,
): View<RequestEvent, RequestEntity> {

	override suspend fun evolve(event: RequestEvent, model: RequestEntity?): RequestEntity? = when (event) {
		is RequestCreatedEvent -> create(event)
		is RequestAddedValuesEvent -> model?.addValues(event)
		is RequestAddedEvidenceEvent -> model?.addEvidence(event)
		is RequestRemovedEvidenceEvent -> model?.removeEvidence(event)
		is RequestAddedRequirementsEvent -> model?.addRequirements(event)
		is RequestRemovedRequirementsEvent -> model?.removeRequirements(event)
		else -> throw NotImplementedError("Evolution for event [${event::class.simpleName}] not implemented")
	}

	private suspend fun create(event: RequestCreatedEvent) = RequestEntity(
		id = event.id,
		status = RequestState.CREATED,
		name = event.name,
		description = event.description,
		requirements = requirementRepository.findAllById(event.requirements).collectList().awaitSingle()
	)

	private suspend fun RequestEntity.addValues(event: RequestAddedValuesEvent) = apply {
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

	private suspend fun RequestEntity.addEvidence(event: RequestAddedEvidenceEvent) = apply {
		val evidenceTypes = evidenceTypeRepository.findAllById(event.isConformantTo)
			.collectList().awaitSingle()

		evidences.add(EvidenceEntity(
			id = event.evidenceId,
			name = event.name,
			file = event.file,
			isConformantTo = evidenceTypes
		))
	}

	private suspend fun RequestEntity.removeEvidence(event: RequestRemovedEvidenceEvent) = apply {
		evidences.removeIf { it.id == event.evidenceId }
	}

	private suspend fun RequestEntity.addRequirements(event: RequestAddedRequirementsEvent) = apply {
		requirements.addAll(requirementRepository.findAllById(event.requirementIds).collectList().awaitSingle())
	}

	private suspend fun RequestEntity.removeRequirements(event: RequestRemovedRequirementsEvent) = apply {
		requirements.removeIf { it.id in event.requirementIds }
	}
}
