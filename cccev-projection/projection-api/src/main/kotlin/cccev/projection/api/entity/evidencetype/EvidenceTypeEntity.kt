package cccev.projection.api.entity.evidencetype

import cccev.projection.api.entity.NodeLabel
import cccev.s2.evidence.domain.EvidenceTypeId
import cccev.s2.evidence.domain.EvidenceTypeState
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import org.springframework.data.neo4j.core.schema.Node
import s2.dsl.automate.model.WithS2Id
import s2.dsl.automate.model.WithS2State

@Node(NodeLabel.EVIDENCE_TYPE)
data class EvidenceTypeEntity(
    @Id
    var id: EvidenceTypeId,
    var status: EvidenceTypeState,
    @Version
    var version: Long = 0,
    @CreatedDate
    var creationDate: Long = 0,
    @LastModifiedDate
    var lastModificationDate: Long = 0,
    var identifier: String? = null,
    var name: String,
    var description: String,
    var validityPeriodConstraint: Long? = null
):  WithS2Id<EvidenceTypeId>, WithS2State<EvidenceTypeState> {
    override fun s2Id() = id
    override fun s2State() = status
}
