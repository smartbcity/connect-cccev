package cccev.s2.evidence.api.config

import cccev.s2.evidence.api.entity.type.EvidenceTypeEntity
import cccev.s2.evidence.api.entity.type.EvidenceTypeRepository
import cccev.s2.evidence.domain.EvidenceTypeId
import cccev.s2.evidence.domain.EvidenceTypeState
import cccev.s2.evidence.domain.s2EvidenceType
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Service
import s2.spring.automate.data.S2SpringDataReactiveConfigurerAdapter
import s2.spring.automate.executor.S2AutomateExecutorSpring

@Configuration
class EvidenceTypeAutomateConfig(
	private val automateExecutor: EvidenceTypeAutomateExecutor,
	repository: EvidenceTypeRepository
): S2SpringDataReactiveConfigurerAdapter<EvidenceTypeState, EvidenceTypeId, EvidenceTypeEntity, EvidenceTypeAutomateExecutor>(repository) {
	override fun automate() = s2EvidenceType
	override fun executor() = automateExecutor
}

@Service
class EvidenceTypeAutomateExecutor: S2AutomateExecutorSpring<EvidenceTypeState, EvidenceTypeId, EvidenceTypeEntity>()
