package cccev.projection.api.entity.concept

import cccev.projection.api.entity.EntityBase
import cccev.projection.api.entity.NodeLabel
import cccev.projection.api.entity.Relation
import cccev.projection.api.entity.unit.DataUnitEntity
import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.concept.domain.InformationConceptIdentifier
import cccev.s2.concept.domain.InformationConceptState
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship

@Node(NodeLabel.INFORMATION_CONCEPT)
class InformationConceptEntity: EntityBase<InformationConceptId, InformationConceptState>() {
    var identifier: InformationConceptIdentifier? = null

    lateinit var name: String

    @Relationship(Relation.HAS_UNIT)
    var hasUnit: DataUnitEntity? = null

    var description: String? = null

    var expressionOfExpectedValue: String? = null

    @Relationship(Relation.DEPENDS_ON)
    var dependsOn: List<InformationConceptEntity>? = null
}
