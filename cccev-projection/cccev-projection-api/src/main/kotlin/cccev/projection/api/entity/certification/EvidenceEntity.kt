package cccev.projection.api.entity.certification

import cccev.dsl.model.EvidenceId
import cccev.projection.api.entity.NodeLabel
import cccev.projection.api.entity.Relation
import cccev.projection.api.entity.concept.InformationConceptEntity
import cccev.projection.api.entity.evidencetype.EvidenceTypeEntity
import city.smartb.fs.s2.file.domain.model.FilePath
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship

@Node(NodeLabel.EVIDENCE)
data class EvidenceEntity(
    @Id
    val id: EvidenceId,
    val name: String,
    val file: FilePath? = null,
    val url: String? = null,
    @Relationship
    val isConformantTo: MutableList<EvidenceTypeEntity> = mutableListOf(),
    @Relationship(Relation.SUPPORTS_CONCEPT)
    val supportsConcept: MutableList<InformationConceptEntity> = mutableListOf(),
    @Version
    val version: Long = 0,
    @CreatedDate
    val creationDate: Long = 0,
    @LastModifiedDate
    val lastModificationDate: Long = 0
)
