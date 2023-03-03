package cccev.projection.api.entity.concept

import cccev.projection.api.entity.Relation
import cccev.projection.api.entity.unit.DataUnitEntity
import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.concept.domain.InformationConceptState
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship
import java.util.UUID

@Node("InformationConcept")
class InformationConceptEntity {
    @Id
    val id: InformationConceptId = UUID.randomUUID().toString()

    lateinit var name: String

    @Relationship(Relation.HAS_UNIT)
    lateinit var hasUnit: DataUnitEntity

    lateinit var description: String

    var expressionOfExpectedValue: String? = null

    @Relationship(Relation.DEPENDS_ON)
    lateinit var dependsOn: List<InformationConceptEntity>

    lateinit var status: InformationConceptState
}
