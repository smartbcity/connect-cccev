package cccev.projection.api.entity.request

import cccev.projection.api.entity.NodeLabel
import cccev.projection.api.entity.Relation
import cccev.projection.api.entity.requirement.RequirementEntity
import cccev.s2.request.domain.RequestState
import cccev.s2.request.domain.model.RequestId
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship
import s2.dsl.automate.model.WithS2Id
import s2.dsl.automate.model.WithS2State

@Node(NodeLabel.REQUEST)
data class RequestEntity(
    @Id
    val id: RequestId,
    val status: RequestState,
    @Version
    val version: Long = 0,
    @CreatedDate
    val creationDate: Long = 0,
    @LastModifiedDate
    val lastModificationDate: Long = 0,
    val name: String,
    val description: String? = null,
    val startDate: Long? = null,
    val endDate: Long? = null,
    val estimatedEndDate: Long? = null,
    val creator: String? = null,
    val executor: String? = null,
    val validator: String? = null,
    val isPublic: Boolean = false,
    val issuable: Boolean = false,
    val verifiable: Boolean = false,
    val verifier: String? = null,
    val verificationDate: Long? = null,
    @Relationship(type = Relation.FULFILLS)
    val requirements: MutableList<RequirementEntity> = mutableListOf(),
    @Relationship(type = Relation.PROVIDES_EVIDENCE)
    val evidences: MutableList<EvidenceEntity> = mutableListOf(),
    @Relationship(type = Relation.PROVIDES_VALUE)
    val supportedValues: MutableList<SupportedValueEntity> = mutableListOf(),
):  WithS2Id<RequestId>, WithS2State<RequestState> {
    override fun s2Id() = id
    override fun s2State() = status
}
