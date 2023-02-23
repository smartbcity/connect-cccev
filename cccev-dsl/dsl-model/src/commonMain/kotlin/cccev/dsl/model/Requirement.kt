package cccev.dsl.model

import cccev.dsl.model.builder.ConstraintBuilder
import cccev.dsl.model.builder.CriterionBuilder
import cccev.dsl.model.builder.InformationRequirementBuilder

/**
 * The unique id of the requirement.
 * @visual json "082f9b5b-4ffa-4e95-8288-2de2972cade5"
 * @title DSL/RequirementId
 * @d2 model
 */
typealias RequirementId = String

sealed interface Requirement {
    val description: String?
    val identifier: RequirementId?
    val isDerivedFrom: List<ReferenceFramework>?
    val name: String?
    val type: Code?
    val hasRequirement: List<Requirement>?
    var isRequirementOf: List<Requirement>?
    var hasQualifiedRelation: List<Requirement>?

    val hasConcept: List<InformationConceptBase>?
    val hasEvidenceTypeList: List<EvidenceTypeListBase>?
}

open class Criterion(
    override val description: String? = null,
    override val identifier: RequirementId?,
    override val name: String?,
    override val type: Code?,
    val bias: Double? = null,
    val weight: Double? = null,
    val weightingConsiderationDescription: String? = null,
    val weightingType: Code? = null,
    override val hasConcept: List<InformationConceptBase>? = emptyList(),
    override val hasRequirement: List<Requirement>? = emptyList(),
    override val hasEvidenceTypeList: List<EvidenceTypeListBase>? = emptyList(),
    override val isDerivedFrom: List<ReferenceFramework>? = emptyList(),
    override var isRequirementOf: List<Requirement>? = emptyList(),
    override var hasQualifiedRelation: List<Requirement>? = emptyList(),
) : Requirement

open class InformationRequirement(
    override val description: String?,
    override val identifier: RequirementId?,
    override val name: String?,
    override val type: Code?,
    override val hasConcept: List<InformationConceptBase>? = emptyList(),
    override val hasRequirement: List<Requirement>? = emptyList(),
    override val hasEvidenceTypeList: List<EvidenceTypeListBase>? = emptyList(),
    override val isDerivedFrom: List<ReferenceFramework>? = emptyList(),
    override var isRequirementOf: List<Requirement>? = emptyList(),
    override var hasQualifiedRelation: List<Requirement>? = emptyList(),
) : Requirement

open class Constraint(
    override val description: String?,
    override val identifier: RequirementId?,
    override val name: String?,
    override val type: Code?,
    override val hasConcept: List<InformationConceptBase>? = emptyList(),
    override val hasRequirement: List<Requirement>? = emptyList(),
    override val hasEvidenceTypeList: List<EvidenceTypeListBase>? = emptyList(),
    override val isDerivedFrom: List<ReferenceFramework>? = emptyList(),
    override var isRequirementOf: List<Requirement>? = emptyList(),
    override var hasQualifiedRelation: List<Requirement>? = emptyList(),
) : Requirement

/**
 * Custom requirement which is considered validated when at least K of its N sub-requirements are met
 * where K is defined by the property [minRequirementsToMeet] and N is the size of the list [hasRequirement]
 * TODO more meaningful name
 */
open class PartialRequirement(
    override val description: String?,
    override val identifier: RequirementId?,
    override val name: String?,
    override val type: Code?,
    val minRequirementsToMeet: Int,
    override val hasConcept: List<InformationConceptBase>? = emptyList(),
    override val hasRequirement: List<Requirement>? = emptyList(),
    override val hasEvidenceTypeList: List<EvidenceTypeListBase>? = emptyList(),
    override val isDerivedFrom: List<ReferenceFramework>? = emptyList(),
    override var isRequirementOf: List<Requirement>? = emptyList(),
    override var hasQualifiedRelation: List<Requirement>? = emptyList(),
) : Requirement

fun criterion(init: CriterionBuilder.() -> Unit): Criterion = CriterionBuilder().apply(init).build()

fun informationRequirement(init: InformationRequirementBuilder.() -> Unit): InformationRequirement =
    InformationRequirementBuilder().apply(init).build()

fun constraint(init: ConstraintBuilder.() -> Unit): Constraint = ConstraintBuilder().apply(init).build()
