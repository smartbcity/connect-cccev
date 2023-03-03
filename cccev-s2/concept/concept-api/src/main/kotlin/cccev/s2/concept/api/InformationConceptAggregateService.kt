package cccev.s2.concept.api

import cccev.s2.concept.api.config.InformationConceptAutomateExecutor
import cccev.s2.concept.api.entity.InformationConceptEntity
import cccev.s2.concept.domain.InformationConceptAggregate
import cccev.s2.concept.domain.InformationConceptState
import cccev.s2.concept.domain.command.InformationConceptCreateCommand
import cccev.s2.concept.domain.command.InformationConceptCreatedEvent
import org.springframework.stereotype.Service

@Service
class InformationConceptAggregateService(
    private val automate: InformationConceptAutomateExecutor
): InformationConceptAggregate {
    override suspend fun create(command: InformationConceptCreateCommand) = automate.createWithEvent(command) {
        val entity = InformationConceptEntity(
            status = InformationConceptState.EXISTS,
            identifier = command.identifier,
            name = command.name,
            unitId = command.unitId,
            description = command.description,
            expressionOfExpectedValue = command.expressionOfExpectedValue,
            dependsOn = command.dependsOn,
        )
        entity to InformationConceptCreatedEvent(entity.id)
    }
}
