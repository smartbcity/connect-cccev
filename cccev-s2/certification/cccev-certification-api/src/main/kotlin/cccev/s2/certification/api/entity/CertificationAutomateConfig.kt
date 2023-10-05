package cccev.s2.certification.api.entity

import cccev.projection.api.entity.certification.CertificationEntity
import cccev.projection.api.entity.certification.CertificationEvolver
import cccev.projection.api.entity.certification.CertificationSnapRepository
import cccev.s2.certification.domain.CertificationEvent
import cccev.s2.certification.domain.CertificationState
import cccev.s2.certification.domain.command.CertificationAddedEvidenceEvent
import cccev.s2.certification.domain.command.CertificationAddedRequirementsEvent
import cccev.s2.certification.domain.command.CertificationAddedValuesEvent
import cccev.s2.certification.domain.command.CertificationCreatedEvent
import cccev.s2.certification.domain.command.CertificationRemovedEvidenceEvent
import cccev.s2.certification.domain.command.CertificationRemovedRequirementsEvent
import cccev.s2.certification.domain.model.CertificationId
import cccev.s2.certification.domain.s2Ceritification
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
class CertificationAutomateConfig(
	automateExecutor: CertificationAutomateExecutor,
	certificationEvolver: CertificationEvolver,
	certificationSnapRepository: CertificationSnapRepository,
): S2SourcingSsmAdapter<
		CertificationEntity,
		CertificationState,
		CertificationEvent,
		CertificationId,
		CertificationAutomateExecutor
>(automateExecutor, certificationEvolver, certificationSnapRepository) {
	override fun automate() = s2Ceritification
	override fun entityType(): KClass<CertificationEvent> {
		return CertificationEvent::class
	}

	override var permisive: Boolean = true

	override fun json(): Json = Json {
		serializersModule = SerializersModule {
			classDiscriminator = "class"
			polymorphic(CertificationEvent::class) {
				subclass(CertificationCreatedEvent::class, CertificationCreatedEvent.serializer())
				subclass(CertificationAddedValuesEvent::class, CertificationAddedValuesEvent.serializer())
				subclass(CertificationAddedEvidenceEvent::class, CertificationAddedEvidenceEvent.serializer())
				subclass(CertificationRemovedEvidenceEvent::class, CertificationRemovedEvidenceEvent.serializer())
				subclass(CertificationAddedRequirementsEvent::class, CertificationAddedRequirementsEvent.serializer())
				subclass(CertificationRemovedRequirementsEvent::class, CertificationRemovedRequirementsEvent.serializer())
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
class CertificationAutomateExecutor: S2AutomateDeciderSpring<CertificationEntity, CertificationState, CertificationEvent, CertificationId>()
