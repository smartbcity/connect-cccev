package cccev.test.s2.requirement.data

import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.evidence.domain.EvidenceTypeListId
import cccev.s2.requirement.api.entity.RequirementEntity
import cccev.s2.requirement.api.entity.RequirementRepository
import cccev.s2.requirement.domain.RequirementId
import cccev.s2.requirement.domain.RequirementState
import cccev.s2.requirement.domain.model.RequirementKind
import cccev.test.AssertionMongoEntity
import fixers.bdd.assertion.AssertionBdd
import org.assertj.core.api.Assertions

fun AssertionBdd.requirement(conceptRepository: RequirementRepository) = AssertionRequirement(conceptRepository)

class AssertionRequirement(
    override val repository: RequirementRepository
): AssertionMongoEntity<RequirementEntity, RequirementId, AssertionRequirement.RequirementAssert>() {

    override suspend fun assertThat(entity: RequirementEntity) = RequirementAssert(entity)

    inner class RequirementAssert(
        private val requirement: RequirementEntity
    ) {
        fun hasFields(
            id: RequirementId = requirement.id,
            status: RequirementState = requirement.status,
            kind: RequirementKind = requirement.kind,
            name: String? = requirement.name,
            description: String? = requirement.description,
            hasRequirement: List<RequirementId> = requirement.hasRequirement,
            hasConcept: List<InformationConceptId> = requirement.hasConcept,
            hasEvidenceTypeList: List<EvidenceTypeListId> = requirement.hasEvidenceTypeList,
        ) = also {
            Assertions.assertThat(requirement.id).isEqualTo(id)
            Assertions.assertThat(requirement.status).isEqualTo(status)
            Assertions.assertThat(requirement.kind).isEqualTo(kind)
            Assertions.assertThat(requirement.name).isEqualTo(name)
            Assertions.assertThat(requirement.description).isEqualTo(description)
            Assertions.assertThat(requirement.hasRequirement).containsExactlyInAnyOrderElementsOf(hasRequirement)
            Assertions.assertThat(requirement.hasConcept).containsExactlyInAnyOrderElementsOf(hasConcept)
            Assertions.assertThat(requirement.hasEvidenceTypeList).containsExactlyInAnyOrderElementsOf(hasEvidenceTypeList)
        }
    }
}
