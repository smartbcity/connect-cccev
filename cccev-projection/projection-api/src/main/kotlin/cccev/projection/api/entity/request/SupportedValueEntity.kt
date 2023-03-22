package cccev.projection.api.entity.request

import cccev.projection.api.entity.concept.InformationConceptEntity
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.RelationshipProperties
import org.springframework.data.neo4j.core.schema.TargetNode

typealias SupportedValueId = Long

@RelationshipProperties
class SupportedValueEntity {
    @Id
    @GeneratedValue
    var id: SupportedValueId? = null

    var value: String? = null

    @TargetNode
    lateinit var providesValueFor: InformationConceptEntity

    @Version
    var version: Long = 0

    @CreatedDate
    var creationDate: Long = 0

    @LastModifiedDate
    var lastModificationDate: Long = 0
}
