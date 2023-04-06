package cccev.f2.framework.api.service

import cccev.s2.framework.api.FrameworkAggregateService
import cccev.s2.framework.domain.command.FrameworkCreateCommand
import cccev.s2.framework.domain.command.FrameworkCreatedEvent
import org.springframework.stereotype.Service

@Service
class FrameworkF2AggregateService(
    private val frameworkAggregateService: FrameworkAggregateService
) {
    suspend fun create(command: FrameworkCreateCommand): FrameworkCreatedEvent {
        return frameworkAggregateService.create(command)
    }
}
