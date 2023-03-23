package cccev.projection.api.entity.request

import cccev.dsl.model.EvidenceId
import cccev.projection.api.entity.NodeLabel
import cccev.projection.api.entity.evidencetype.EvidenceTypeEntity
import city.smartb.fs.s2.file.domain.model.FilePath
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship

@Node(NodeLabel.EVIDENCE)
class EvidenceEntity {
    @Id
    lateinit var id: EvidenceId

    lateinit var name: String

    var file: FilePath? = null

    var url: String? = null

    @Relationship
    var isConformantTo: MutableList<EvidenceTypeEntity> = mutableListOf()

    @Version
    var version: Long = 0

    @CreatedDate
    var creationDate: Long = 0

    @LastModifiedDate
    var lastModificationDate: Long = 0
}
