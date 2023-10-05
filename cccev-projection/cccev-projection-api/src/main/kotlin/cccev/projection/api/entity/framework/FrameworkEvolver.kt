package cccev.projection.api.entity.framework

import cccev.s2.framework.domain.FrameworkEvent
import cccev.s2.framework.domain.FrameworkState
import cccev.s2.framework.domain.command.FrameworkCreatedEvent
import org.springframework.stereotype.Service
import s2.sourcing.dsl.view.View

@Service
class FrameworkEvolver: View<FrameworkEvent, FrameworkEntity> {

	override suspend fun evolve(event: FrameworkEvent, model: FrameworkEntity?): FrameworkEntity? = when (event) {
		is FrameworkCreatedEvent -> create(event)
		else -> TODO()
	}

	private suspend fun create(event: FrameworkCreatedEvent): FrameworkEntity {
		return FrameworkEntity(
			id = event.id,
			identifier = event.identifier,
			name = event.name,
			status = FrameworkState.CREATED
		)
	}
}
