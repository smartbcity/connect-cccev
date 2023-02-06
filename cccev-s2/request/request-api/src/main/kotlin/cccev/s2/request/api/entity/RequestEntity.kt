package cccev.s2.request.api.entity

import cccev.core.dsl.Evidence
import cccev.core.dsl.InformationConceptId
import cccev.core.dsl.RequirementId
import cccev.core.dsl.SupportedValue
import cccev.s2.request.domain.RequestState
import cccev.s2.request.domain.model.RequestId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import s2.dsl.automate.model.WithS2Id
import s2.dsl.automate.model.WithS2State
import s2.spring.utils.data.EntityBase
import java.util.UUID

@Document("request")
class RequestEntity(
	@Id
	val id: RequestId = UUID.randomUUID().toString(),
	var status: RequestState,
	val frameworkId: RequirementId,
	val evidences: MutableList<Evidence>,
	val supportedValues: MutableMap<InformationConceptId, SupportedValue>
): EntityBase(), WithS2Id<RequestId>, WithS2State<RequestState> {
	override fun s2Id() = id
	override fun s2State() = status
}
