package cccev.s2.framework.api.entity

import cccev.projection.api.entity.framework.FrameworkEntity
import cccev.projection.api.entity.framework.FrameworkEvolver
import cccev.projection.api.entity.framework.FrameworkSnapRepository
import cccev.s2.framework.domain.FrameworkEvent
import cccev.s2.framework.domain.FrameworkId
import cccev.s2.framework.domain.FrameworkState
import cccev.s2.framework.domain.command.FrameworkCreatedEvent
import cccev.s2.framework.domain.s2Framework
import kotlin.reflect.KClass
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Service
import s2.spring.automate.sourcing.S2AutomateDeciderSpring
import s2.spring.sourcing.ssm.S2SourcingSsmAdapter
import ssm.chaincode.dsl.model.Agent
import ssm.chaincode.dsl.model.uri.ChaincodeUri
import ssm.chaincode.dsl.model.uri.from
import ssm.sdk.sign.extention.loadFromFile

@Configuration
class FrameworkAutomateConfig(
	automateExecutor: FrameworkAutomateExecutor,
	requirementEvolver: FrameworkEvolver,
	requirementSnapRepository: FrameworkSnapRepository,
): S2SourcingSsmAdapter<
		FrameworkEntity,
		FrameworkState,
		FrameworkEvent,
		FrameworkId,
		FrameworkAutomateExecutor
	>(automateExecutor, requirementEvolver, requirementSnapRepository) {
	override fun automate() = s2Framework
	override fun entityType(): KClass<FrameworkEvent> {
		return FrameworkEvent::class
	}

	override var permisive: Boolean = true

	override fun json(): Json = Json {
		serializersModule = SerializersModule {
			classDiscriminator = "class"
			polymorphic(FrameworkEvent::class) {
				subclass(FrameworkCreatedEvent::class, FrameworkCreatedEvent.serializer())
			}
		}
	}

	override fun chaincodeUri(): ChaincodeUri {
		return ChaincodeUri.from(
			channelId = "sandbox",
			chaincodeId = "ssm",
		)
	}

	override fun signerAgent(): Agent {
		return Agent.loadFromFile("ssm-admin","user/ssm-admin")
	}

 	override fun preventOptimisticLocking(): Boolean = true
}

@Service
class FrameworkAutomateExecutor: S2AutomateDeciderSpring<FrameworkEntity, FrameworkState, FrameworkEvent, FrameworkId>()
