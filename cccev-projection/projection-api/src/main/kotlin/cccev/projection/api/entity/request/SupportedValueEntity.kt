package cccev.projection.api.entity.request

import cccev.projection.api.entity.EntityBase
import cccev.projection.api.entity.NodeLabel
import cccev.projection.api.entity.Relation
import cccev.projection.api.entity.concept.InformationConceptEntity
import cccev.s2.framework.domain.FrameworkState
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship
import org.springframework.data.neo4j.core.schema.RelationshipProperties
import org.springframework.data.neo4j.core.schema.TargetNode
import org.springframework.data.neo4j.core.support.UUIDStringGenerator
import s2.dsl.automate.model.WithS2Id
import s2.dsl.automate.model.WithS2State

typealias SupportedValueId = String

@Node(NodeLabel.SUPPORTED_VALUE)
class SupportedValueEntity: WithS2Id<SupportedValueId> {
    @Id
    @GeneratedValue(UUIDStringGenerator::class)
    lateinit var id: SupportedValueId

    @CreatedDate
    var creationDate: Long = 0

    @LastModifiedDate
    var lastModificationDate: Long = 0


    var value: String? = null

    @Relationship(Relation.PROVIDES_VALUE_FOR)
    lateinit var providesValueFor: InformationConceptEntity
    override fun s2Id() = id

}
