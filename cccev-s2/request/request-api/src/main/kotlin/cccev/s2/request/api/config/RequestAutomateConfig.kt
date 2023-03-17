package cccev.s2.request.api.config

import cccev.projection.api.entity.request.RequestEntity
import cccev.projection.api.entity.request.RequestEvolver
import cccev.projection.api.entity.request.RequestSnapRepository
import cccev.projection.api.entity.requirement.RequirementEvolver
import cccev.s2.request.domain.RequestEvent
import cccev.s2.request.domain.RequestState
import cccev.s2.request.domain.features.command.RequestAuditedEvent
import cccev.s2.request.domain.features.command.RequestEvidenceAddedEvent
import cccev.s2.request.domain.features.command.RequestEvidenceRemovedEvent
import cccev.s2.request.domain.features.command.RequestInitializedEvent
import cccev.s2.request.domain.features.command.RequestRefusedEvent
import cccev.s2.request.domain.features.command.RequestSentEvent
import cccev.s2.request.domain.features.command.RequestSignedEvent
import cccev.s2.request.domain.features.command.RequestSupportedValueAddedEvent
import cccev.s2.request.domain.model.RequestId
import cccev.s2.request.domain.s2Request
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
import kotlin.reflect.KClass

@Configuration
class RequestAutomateConfig(
	decider: RequestDecider,
	requirementEvolver: RequestEvolver,
	requestSnapRepository: RequestSnapRepository,
): S2SourcingSsmAdapter<
		RequestEntity,
		RequestState,
		RequestEvent,
		RequestId,
		RequestDecider
	>(decider, requirementEvolver, requestSnapRepository) {
	override fun automate() = s2Request()
	override fun entityType(): KClass<RequestEvent> {
		return RequestEvent::class
	}

	override var permisive: Boolean = true

	override fun json(): Json = Json {
		serializersModule = SerializersModule {
			classDiscriminator = "class"
			polymorphic(RequestEvent::class) {
				subclass(RequestAuditedEvent::class, RequestAuditedEvent.serializer())
				subclass(RequestEvidenceAddedEvent::class, RequestEvidenceAddedEvent.serializer())
				subclass(RequestEvidenceRemovedEvent::class, RequestEvidenceRemovedEvent.serializer())
				subclass(RequestInitializedEvent::class, RequestInitializedEvent.serializer())
				subclass(RequestRefusedEvent::class, RequestRefusedEvent.serializer())
				subclass(RequestSentEvent::class, RequestSentEvent.serializer())
				subclass(RequestSignedEvent::class, RequestSignedEvent.serializer())
				subclass(RequestSupportedValueAddedEvent::class, RequestSupportedValueAddedEvent.serializer())
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
}

@Service
class RequestDecider : S2AutomateDeciderSpring<RequestEntity, RequestState, RequestEvent, RequestId>()
