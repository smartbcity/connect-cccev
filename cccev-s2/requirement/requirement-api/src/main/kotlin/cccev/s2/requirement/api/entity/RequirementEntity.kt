package cccev.s2.requirement.api.entity

import cccev.dsl.model.EvidenceTypeListId
import cccev.dsl.model.InformationConceptId
import cccev.s2.requirement.domain.RequirementId
import cccev.s2.requirement.domain.RequirementState
import cccev.s2.requirement.domain.model.RequirementKind
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import s2.dsl.automate.model.WithS2Id
import s2.dsl.automate.model.WithS2State
import s2.spring.utils.data.EntityBase
import java.util.UUID

@Document("requirement")
data class RequirementEntity(
    @Id
    val id: RequirementId = UUID.randomUUID().toString(),
    val kind: RequirementKind,
    var description: String?,
    var name: String?,
    var hasRequirement: List<RequirementId>,
    var isRequirementOf: List<RequirementId>,
    var hasQualifiedRelation: List<RequirementId>,
    var hasConcept: List<InformationConceptId>,
    var hasEvidenceTypeList: List<EvidenceTypeListId>,
    var status: RequirementState
): EntityBase(), WithS2Id<RequirementId>, WithS2State<RequirementState> {
    override fun s2Id() = id
    override fun s2State() = status
}