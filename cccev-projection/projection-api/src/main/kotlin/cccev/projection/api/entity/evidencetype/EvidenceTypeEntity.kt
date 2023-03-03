package cccev.projection.api.entity.evidencetype

import cccev.projection.api.entity.Relation
import cccev.projection.api.entity.evidencetypelist.EvidenceTypeListEntity
import cccev.s2.evidence.domain.EvidenceTypeId
import cccev.s2.evidence.domain.EvidenceTypeState
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship
import java.util.UUID

@Node("EvidenceType")
class EvidenceTypeEntity {
    @Id
    val id: EvidenceTypeId = UUID.randomUUID().toString()

    lateinit var name: String

    lateinit var description: String

    @Relationship(Relation.SPECIFIES_EVIDENCE_TYPE, direction = Relationship.Direction.INCOMING)
    lateinit var isSpecifiedIn: List<EvidenceTypeListEntity>

    var validityPeriodConstraint: Long? = null

    lateinit var status: EvidenceTypeState
}
