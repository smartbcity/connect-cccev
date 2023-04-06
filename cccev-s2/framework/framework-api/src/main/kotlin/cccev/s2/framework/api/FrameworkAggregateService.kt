package cccev.s2.framework.api

import cccev.s2.framework.api.entity.FrameworkAutomateExecutor
import cccev.s2.framework.domain.FrameworkAggregate
import cccev.s2.framework.domain.command.FrameworkCreateCommand
import cccev.s2.framework.domain.command.FrameworkCreatedEvent
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class FrameworkAggregateService(
    private val automate: FrameworkAutomateExecutor
): FrameworkAggregate {
    override suspend fun create(command: FrameworkCreateCommand) = automate.init(command) {
        FrameworkCreatedEvent(
            id = UUID.randomUUID().toString(),
            identifier = command.identifier,
            name = command.name
        )
    }
}
