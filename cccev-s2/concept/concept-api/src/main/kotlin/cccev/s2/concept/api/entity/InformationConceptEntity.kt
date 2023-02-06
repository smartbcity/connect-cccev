package cccev.s2.concept.api.entity

import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.concept.domain.InformationConceptState
import cccev.s2.unit.domain.DataUnitId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import s2.dsl.automate.model.WithS2Id
import s2.dsl.automate.model.WithS2State
import java.util.UUID

@Document("concept")
data class InformationConceptEntity(
    @Id
    val id: InformationConceptId = UUID.randomUUID().toString(),
    val name: String,
    val unit: DataUnitId,
    val type: String,
    val description: String,
    val expressionOfExpectedValue: String?,
    val dependsOn: List<InformationConceptId>,
    val status: InformationConceptState
): WithS2Id<InformationConceptId>, WithS2State<InformationConceptState> {
    override fun s2Id() = id
    override fun s2State() = status
}
