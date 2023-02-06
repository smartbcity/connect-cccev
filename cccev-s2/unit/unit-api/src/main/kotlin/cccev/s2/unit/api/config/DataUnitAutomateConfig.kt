package cccev.s2.unit.api.config

import cccev.s2.unit.api.entity.DataUnitEntity
import cccev.s2.unit.api.entity.DataUnitRepository
import cccev.s2.unit.domain.DataUnitId
import cccev.s2.unit.domain.DataUnitState
import cccev.s2.unit.domain.s2DataUnit
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Service
import s2.spring.automate.data.S2SpringDataReactiveConfigurerAdapter
import s2.spring.automate.executor.S2AutomateExecutorSpring

@Configuration
class DataUnitAutomateConfig(
	private val automateExecutor: DataUnitAutomateExecutor,
	repository: DataUnitRepository
): S2SpringDataReactiveConfigurerAdapter<DataUnitState, DataUnitId, DataUnitEntity, DataUnitAutomateExecutor>(repository) {
	override fun automate() = s2DataUnit
	override fun executor() = automateExecutor
}

@Service
class DataUnitAutomateExecutor: S2AutomateExecutorSpring<DataUnitState, DataUnitId, DataUnitEntity>()
