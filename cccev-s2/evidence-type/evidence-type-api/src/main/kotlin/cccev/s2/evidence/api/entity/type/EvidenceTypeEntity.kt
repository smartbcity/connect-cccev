package cccev.s2.evidence.api.entity.type

import cccev.s2.evidence.domain.EvidenceTypeId
import cccev.s2.evidence.domain.EvidenceTypeState
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import s2.dsl.automate.model.WithS2Id
import s2.dsl.automate.model.WithS2State
import s2.spring.utils.data.EntityBase
import java.util.UUID

@Document("evidence_type")
data class EvidenceTypeEntity(
    @Id
    val id: EvidenceTypeId = UUID.randomUUID().toString(),
    val name: String,
    val description: String,
    val validityPeriodConstraint: Long?,
    val status: EvidenceTypeState
): EntityBase(), WithS2Id<EvidenceTypeId>, WithS2State<EvidenceTypeState> {
    override fun s2Id() = id
    override fun s2State() = status
}
