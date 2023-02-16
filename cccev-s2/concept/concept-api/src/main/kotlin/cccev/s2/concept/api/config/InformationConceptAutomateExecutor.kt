package cccev.s2.concept.api.config

import cccev.s2.concept.api.entity.InformationConceptEntity
import cccev.s2.concept.api.entity.InformationConceptRepository
import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.concept.domain.InformationConceptState
import cccev.s2.concept.domain.s2InformationConcept
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Service
import s2.spring.automate.data.S2SpringDataReactiveConfigurerAdapter
import s2.spring.automate.executor.S2AutomateExecutorSpring

@Configuration
class InformationConceptAutomateConfig(
	private val automateExecutor: InformationConceptAutomateExecutor,
	repository: InformationConceptRepository,
): S2SpringDataReactiveConfigurerAdapter<
		InformationConceptState, InformationConceptId, InformationConceptEntity, InformationConceptAutomateExecutor
>(repository) {
	override fun automate() = s2InformationConcept
	override fun executor() = automateExecutor
}

@Service
class InformationConceptAutomateExecutor
	: S2AutomateExecutorSpring<InformationConceptState, InformationConceptId, InformationConceptEntity>()
