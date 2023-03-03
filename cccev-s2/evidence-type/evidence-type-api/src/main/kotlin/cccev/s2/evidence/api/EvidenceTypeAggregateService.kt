package cccev.s2.evidence.api

import cccev.s2.evidence.api.config.EvidenceTypeAutomateExecutor
import cccev.s2.evidence.api.config.EvidenceTypeListAutomateExecutor
import cccev.s2.evidence.api.entity.list.EvidenceTypeListEntity
import cccev.s2.evidence.api.entity.type.EvidenceTypeEntity
import cccev.s2.evidence.domain.EvidenceTypeAggregate
import cccev.s2.evidence.domain.EvidenceTypeId
import cccev.s2.evidence.domain.EvidenceTypeListState
import cccev.s2.evidence.domain.EvidenceTypeState
import cccev.s2.evidence.domain.command.list.EvidenceTypeListCreateCommand
import cccev.s2.evidence.domain.command.list.EvidenceTypeListCreatedEvent
import cccev.s2.evidence.domain.command.list.EvidenceTypeListUpdateCommand
import cccev.s2.evidence.domain.command.list.EvidenceTypeListUpdatedEvent
import cccev.s2.evidence.domain.command.type.EvidenceTypeCreateCommand
import cccev.s2.evidence.domain.command.type.EvidenceTypeCreatedEvent
import org.springframework.stereotype.Service

@Service
class EvidenceTypeAggregateService(
    private val typeAutomate: EvidenceTypeAutomateExecutor,
    private val listAutomate: EvidenceTypeListAutomateExecutor,
    private val evidenceTypeFinderService: EvidenceTypeFinderService
): EvidenceTypeAggregate {
    override suspend fun create(command: EvidenceTypeCreateCommand) = typeAutomate.createWithEvent(command) {
        val entity = EvidenceTypeEntity(
            identifier = command.identifier,
            name = command.name,
            description = command.description,
            validityPeriodConstraint = command.validityPeriodConstraint,
            status = EvidenceTypeState.EXISTS,
        )
        entity to EvidenceTypeCreatedEvent(entity.id)
    }

    override suspend fun createList(command: EvidenceTypeListCreateCommand) = listAutomate.createWithEvent(command) {
        checkEvidenceTypesExist(command.specifiesEvidenceType)

        val entity = EvidenceTypeListEntity(
            identifier = command.identifier,
            name = command.name,
            description = command.description,
            specifiesEvidenceType = command.specifiesEvidenceType,
            status = EvidenceTypeListState.EXISTS
        )
        entity to EvidenceTypeListCreatedEvent(entity.id)
    }

    override suspend fun updateList(command: EvidenceTypeListUpdateCommand) = listAutomate.doTransition(command) {
        checkEvidenceTypesExist(command.specifiesEvidenceType)

        name = command.name
        description = command.description
        specifiesEvidenceType = command.specifiesEvidenceType

        this to EvidenceTypeListUpdatedEvent(command.id)
    }

    private suspend fun checkEvidenceTypesExist(ids: Collection<EvidenceTypeId>) {
        ids.forEach { evidenceTypeFinderService.get(it) }
    }
}
