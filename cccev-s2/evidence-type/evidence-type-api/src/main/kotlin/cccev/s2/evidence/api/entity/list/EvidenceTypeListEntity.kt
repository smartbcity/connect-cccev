package cccev.s2.evidence.api.entity.list

import cccev.s2.evidence.domain.EvidenceTypeId
import cccev.s2.evidence.domain.EvidenceTypeListId
import cccev.s2.evidence.domain.EvidenceTypeListState
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import s2.dsl.automate.model.WithS2Id
import s2.dsl.automate.model.WithS2State
import s2.spring.utils.data.EntityBase
import java.util.UUID

@Document("evidence_type_list")
data class EvidenceTypeListEntity(
    @Id
    val id: EvidenceTypeListId = UUID.randomUUID().toString(),
    var name: String,
    var description: String,
    var specifiesEvidenceType: List<EvidenceTypeId>,
    var status: EvidenceTypeListState
): EntityBase(), WithS2Id<EvidenceTypeListId>, WithS2State<EvidenceTypeListState> {
    override fun s2Id() = id
    override fun s2State() = status
}
