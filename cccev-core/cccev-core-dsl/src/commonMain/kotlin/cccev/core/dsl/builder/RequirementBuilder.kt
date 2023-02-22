package cccev.core.dsl.builder

import cccev.core.dsl.Code
import cccev.core.dsl.EvidenceTypeListBase
import cccev.core.dsl.InformationConceptBase
import cccev.core.dsl.ReferenceFramework
import cccev.core.dsl.Requirement
import cccev.core.dsl.RequirementId


interface RequirementBuilder<T : Requirement> {
    var description: String?
    var identifier: RequirementId?
    var name: String?
    var type: Code?

    var hasConcept: List<InformationConceptBase>?
    var hasEvidenceTypeList: List<EvidenceTypeListBase>?

    @Deprecated("Use isRequirementOf, hasRequirement or hasQualifiedRelation")
    fun criterion(init: CriterionBuilder.() -> Unit)
    @Deprecated("Use isRequirementOf, hasRequirement or hasQualifiedRelation")
    fun informationRequirement(init: InformationRequirementBuilder.() -> Unit)
    @Deprecated("Use isRequirementOf, hasRequirement or hasQualifiedRelation")
    fun constraint(init: ConstraintBuilder.() -> Unit)
    @Deprecated("Use isRequirementOf, hasRequirement or hasQualifiedRelation")
    operator fun Requirement.unaryPlus()

    fun isRequirementOf(lambda: RequirementsLinkedBuilder.() -> Unit)
    fun hasRequirement(lambda: RequirementsLinkedBuilder.() -> Unit)
    fun hasQualifiedRelation(lambda: RequirementsLinkedBuilder.() -> Unit)

    fun build(): Requirement
}
abstract class AbstractRequirementBuilder<T : Requirement> : RequirementBuilder<T> {
    override var description: String? = null
    override var identifier: RequirementId? = null
    override var name: String? = null
    override var type: Code? = null
    override var hasConcept: List<InformationConceptBase>? = null
    override var hasEvidenceTypeList: List<EvidenceTypeListBase>? = null

    protected var isDerivedFrom = mutableListOf<ReferenceFramework>()
    protected var isRequirementOf = mutableListOf<Requirement>()
    protected var hasRequirement = mutableListOf<Requirement>()
    protected var hasQualifiedRelation = mutableListOf<Requirement>()

    @Deprecated("Use isRequirementOf, hasRequirement or hasQualifiedRelation")
    override fun criterion(
        init: CriterionBuilder.() -> Unit,
    ) {
        +CriterionBuilder().apply(init).build()
    }

    @Deprecated("Use isRequirementOf, hasRequirement or hasQualifiedRelation")
    override fun informationRequirement(
        init: InformationRequirementBuilder.() -> Unit
    ) {
        +InformationRequirementBuilder().apply(init).build()
    }

    @Deprecated("Use isRequirementOf, hasRequirement or hasQualifiedRelation")
    override fun constraint(
        init: ConstraintBuilder.() -> Unit) {
        +ConstraintBuilder().apply(init).build()
    }

    @Deprecated("Use isRequirementOf, hasRequirement or hasQualifiedRelation")
    override operator fun Requirement.unaryPlus() {
        this@AbstractRequirementBuilder.hasRequirement.add(this)
    }

    override fun isRequirementOf(lambda: RequirementsLinkedBuilder.() -> Unit) {
        isRequirementOf.addAll(RequirementsLinkedBuilder().apply(lambda).build())
    }
    override fun hasRequirement(lambda: RequirementsLinkedBuilder.() -> Unit) {
        isRequirementOf.addAll(RequirementsLinkedBuilder().apply(lambda).build())
    }
    override fun hasQualifiedRelation(lambda: RequirementsLinkedBuilder.() -> Unit) {
        isRequirementOf.addAll(RequirementsLinkedBuilder().apply(lambda).build())
    }
}
