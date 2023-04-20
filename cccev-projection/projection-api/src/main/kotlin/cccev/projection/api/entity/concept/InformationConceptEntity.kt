package cccev.projection.api.entity.concept

import cccev.projection.api.entity.NodeLabel
import cccev.projection.api.entity.Relation
import cccev.projection.api.entity.unit.DataUnitEntity
import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.concept.domain.InformationConceptIdentifier
import cccev.s2.concept.domain.InformationConceptState
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship
import s2.dsl.automate.model.WithS2Id
import s2.dsl.automate.model.WithS2State

@Node(NodeLabel.INFORMATION_CONCEPT)
data class InformationConceptEntity(
    @Id
    var id: InformationConceptId,
    var status: InformationConceptState,
    @Version
    var version: Long = 0,
    @CreatedDate
    var creationDate: Long = 0,
    @LastModifiedDate
    var lastModificationDate: Long = 0,
    var identifier: InformationConceptIdentifier? = null,
    var name: String,
    @Relationship(Relation.HAS_UNIT)
    var hasUnit: DataUnitEntity? = null,
    var description: String? = null,
    var expressionOfExpectedValue: String? = null,
    @Relationship(Relation.DEPENDS_ON)
    var dependsOn: List<InformationConceptEntity>? = null,
): WithS2Id<InformationConceptId>, WithS2State<InformationConceptState> {
    override fun s2Id() = id
    override fun s2State() = status
}
