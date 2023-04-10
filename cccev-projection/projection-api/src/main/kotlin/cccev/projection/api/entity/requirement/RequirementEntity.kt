package cccev.projection.api.entity.requirement

import cccev.projection.api.entity.EntityBase
import cccev.projection.api.entity.NodeLabel
import cccev.projection.api.entity.Relation
import cccev.projection.api.entity.concept.InformationConceptEntity
import cccev.projection.api.entity.evidencetypelist.EvidenceTypeListEntity
import cccev.projection.api.entity.framework.FrameworkEntity
import cccev.s2.requirement.domain.RequirementId
import cccev.s2.requirement.domain.RequirementState
import cccev.s2.requirement.domain.model.RequirementKind
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship

@Node(NodeLabel.REQUIREMENT)
class RequirementEntity: EntityBase<RequirementId, RequirementState>() {
    var identifier: String? = null

    lateinit var kind: RequirementKind

    var name: String? = null

    var description: String? = null

    var type: String? = null

    @Relationship(type = Relation.IS_DERIVED_FROM)
    lateinit var isDerivedFrom: List<FrameworkEntity>

    @Relationship(type = Relation.HAS_REQUIREMENT)
    lateinit var hasRequirement: MutableList<RequirementEntity>

    @Relationship
    var hasQualifiedRelation: MutableMap<String, List<RequirementEntity>> = mutableMapOf()

    @Relationship(type = Relation.HAS_CONCEPT)
    lateinit var hasConcept: MutableList<InformationConceptEntity>

    @Relationship(type = Relation.HAS_EVIDENCE_TYPE_LIST)
    lateinit var hasEvidenceTypeList: MutableList<EvidenceTypeListEntity>
}
