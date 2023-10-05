package cccev.projection.api.entity.certification

import cccev.projection.api.entity.NodeLabel
import cccev.projection.api.entity.Relation
import cccev.projection.api.entity.concept.InformationConceptEntity
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship
import s2.dsl.automate.model.WithS2Id

typealias SupportedValueId = String

@Node(NodeLabel.SUPPORTED_VALUE)
data class SupportedValueEntity(
    @Id
    val id: SupportedValueId,
    @Version
    val version: Long = 0,
    @CreatedDate
    val creationDate: Long = 0,
    @LastModifiedDate
    val lastModificationDate: Long = 0,
    var value: String? = null,
    @Relationship(Relation.PROVIDES_VALUE_FOR)
    val providesValueFor: InformationConceptEntity
): WithS2Id<SupportedValueId> {

    override fun s2Id() = id

}
