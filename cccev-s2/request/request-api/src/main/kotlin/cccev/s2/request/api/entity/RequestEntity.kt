package cccev.s2.request.api.entity

import cccev.dsl.model.Evidence
import cccev.dsl.model.InformationConceptId
import cccev.dsl.model.RequirementId
import cccev.dsl.model.SupportedValue
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
