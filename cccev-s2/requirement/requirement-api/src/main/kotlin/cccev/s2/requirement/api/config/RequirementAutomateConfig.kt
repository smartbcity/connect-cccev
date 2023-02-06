package cccev.s2.requirement.api.config

import cccev.s2.requirement.api.entity.RequirementEntity
import cccev.s2.requirement.api.entity.RequirementRepository
import cccev.s2.requirement.domain.RequirementId
import cccev.s2.requirement.domain.RequirementState
import cccev.s2.requirement.domain.s2Requirement
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Service
import s2.spring.automate.data.S2SpringDataReactiveConfigurerAdapter
import s2.spring.automate.executor.S2AutomateExecutorSpring

@Configuration
class RequirementAutomateConfig(
	private val automateExecutor: RequirementAutomateExecutor,
	repository: RequirementRepository
): S2SpringDataReactiveConfigurerAdapter<RequirementState, RequirementId, RequirementEntity, RequirementAutomateExecutor>(repository) {
	override fun automate() = s2Requirement
	override fun executor() = automateExecutor
}

@Service
class RequirementAutomateExecutor: S2AutomateExecutorSpring<RequirementState, RequirementId, RequirementEntity>()
