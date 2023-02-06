package cccev.s2.requirement.api.entity

import cccev.core.dsl.EvidenceTypeListId
import cccev.core.dsl.InformationConceptId
import cccev.s2.requirement.domain.RequirementId
import cccev.s2.requirement.domain.RequirementState
import cccev.s2.requirement.domain.model.RequirementKind
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import s2.dsl.automate.model.WithS2Id
import s2.dsl.automate.model.WithS2State
import java.util.UUID

@Document("requirement")
data class RequirementEntity(
    @Id
    val id: RequirementId = UUID.randomUUID().toString(),
    val kind: RequirementKind,
    val description: String?,
    val name: String?,
    val type: String?,
    val hasRequirement: List<RequirementId>,
    val hasConcept: List<InformationConceptId>,
    val hasEvidenceTypeList: List<EvidenceTypeListId>,
    val status: RequirementState
): WithS2Id<RequirementId>, WithS2State<RequirementState> {
    override fun s2Id() = id
    override fun s2State() = status
}
