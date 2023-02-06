package cccev.s2.concept.domain

import cccev.s2.concept.domain.command.InformationConceptCreateCommand
import cccev.s2.concept.domain.command.InformationConceptCreatedEvent

interface InformationConceptAggregate {
    suspend fun create(command: InformationConceptCreateCommand): InformationConceptCreatedEvent
}
