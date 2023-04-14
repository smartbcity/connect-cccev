package cccev.projection.api.entity.request

import cccev.projection.api.entity.EntityBase
import cccev.projection.api.entity.NodeLabel
import cccev.projection.api.entity.Relation
import cccev.projection.api.entity.requirement.RequirementEntity
import cccev.s2.request.domain.RequestState
import cccev.s2.request.domain.model.RequestId
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship

@Node(NodeLabel.REQUEST)
class RequestEntity: EntityBase<RequestId, RequestState>() {
    lateinit var name: String

    var description: String? = null

    var startDate: Long? = null

    var endDate: Long? = null

    var estimatedEndDate: Long? = null

    var creator: String? = null

    var executor: String? = null

    var validator: String? = null

    var isPublic: Boolean = false

    var issuable: Boolean = false

    var verifiable: Boolean = false

    var verifier: String? = null

    var verificationDate: Long? = null

    @Relationship(type = Relation.FULFILLS)
    var requirements: MutableList<RequirementEntity> = mutableListOf()

    @Relationship(type = Relation.PROVIDES_EVIDENCE)
    var evidences: MutableList<EvidenceEntity> = mutableListOf()

    @Relationship(type = Relation.PROVIDES_VALUE)
    var supportedValues: MutableList<SupportedValueEntity> = mutableListOf()
}
