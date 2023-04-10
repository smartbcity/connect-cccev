package cccev.s2.request.api.entity

import cccev.projection.api.entity.request.RequestEntity
import cccev.projection.api.entity.request.RequestEvolver
import cccev.projection.api.entity.request.RequestSnapRepository
import cccev.s2.request.domain.RequestEvent
import cccev.s2.request.domain.RequestState
import cccev.s2.request.domain.command.RequestAddedEvidenceEvent
import cccev.s2.request.domain.command.RequestAddedRequirementsEvent
import cccev.s2.request.domain.command.RequestAddedValuesEvent
import cccev.s2.request.domain.command.RequestCreatedEvent
import cccev.s2.request.domain.command.RequestRemovedEvidenceEvent
import cccev.s2.request.domain.command.RequestRemovedRequirementsEvent
import cccev.s2.request.domain.model.RequestId
import cccev.s2.request.domain.s2Request
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
class RequestAutomateConfig(
	automateExecutor: RequestAutomateExecutor,
	requestEvolver: RequestEvolver,
	requestSnapRepository: RequestSnapRepository,
): S2SourcingSsmAdapter<
		RequestEntity,
		RequestState,
		RequestEvent,
		RequestId,
		RequestAutomateExecutor
>(automateExecutor, requestEvolver, requestSnapRepository) {
	override fun automate() = s2Request
	override fun entityType(): KClass<RequestEvent> {
		return RequestEvent::class
	}

	override var permisive: Boolean = true

	override fun json(): Json = Json {
		serializersModule = SerializersModule {
			classDiscriminator = "class"
			polymorphic(RequestEvent::class) {
				subclass(RequestCreatedEvent::class, RequestCreatedEvent.serializer())
				subclass(RequestAddedValuesEvent::class, RequestAddedValuesEvent.serializer())
				subclass(RequestAddedEvidenceEvent::class, RequestAddedEvidenceEvent.serializer())
				subclass(RequestRemovedEvidenceEvent::class, RequestRemovedEvidenceEvent.serializer())
				subclass(RequestAddedRequirementsEvent::class, RequestAddedRequirementsEvent.serializer())
				subclass(RequestRemovedRequirementsEvent::class, RequestRemovedRequirementsEvent.serializer())
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
class RequestAutomateExecutor: S2AutomateDeciderSpring<RequestEntity, RequestState, RequestEvent, RequestId>()
