package cccev.s2.requirement.api

import cccev.core.dsl.EvidenceTypeId
import cccev.core.dsl.EvidenceTypeList
import cccev.core.dsl.InformationConceptId
import cccev.core.dsl.Requirement
import cccev.core.dsl.RequirementId
import org.springframework.stereotype.Service

@Service
class RequirementFinderService {
    companion object {
        val AVAILABLE_REQUIREMENTS = mutableMapOf<RequirementId, Requirement>() // will be removed when requirements are stored in db
    }

    fun get(id: RequirementId) = AVAILABLE_REQUIREMENTS[id]

    fun list(
        parent: RequirementId? = null, concept: InformationConceptId? = null, evidenceType: EvidenceTypeId? = null
    ): List<Requirement> {
        val requirements = parent?.let { listOfNotNull(AVAILABLE_REQUIREMENTS[it]) }
            ?: AVAILABLE_REQUIREMENTS.values.toList()

        return requirements.flatMap { requirement -> requirement.subRequirements() }
            .withConcept(concept)
            .withEvidenceType(evidenceType)
    }

    private fun Requirement.subRequirements(): List<Requirement> {
        return hasRequirement.orEmpty()
            .flatMap { it.subRequirements() }
            .plus(this)
    }

    private fun List<Requirement>.withConcept(conceptId: InformationConceptId?) = conceptId?.let {
        filter { requirement -> requirement.hasConcept(conceptId) }
    } ?: this

    private fun Requirement.hasConcept(conceptId: InformationConceptId): Boolean {
        return hasConcept.orEmpty().any { concept -> concept.identifier == conceptId }
    }

    private fun List<Requirement>.withEvidenceType(evidenceTypeId: EvidenceTypeId?) = evidenceTypeId?.let {
        filter { requirement -> requirement.hasEvidenceType(evidenceTypeId) }
    } ?: this

    private fun Requirement.hasEvidenceType(evidenceTypeId: EvidenceTypeId): Boolean {
        return hasEvidenceTypeList.orEmpty().any { evidenceTypeList ->
            evidenceTypeList.hasEvidenceType(evidenceTypeId)
        }
    }

    private fun EvidenceTypeList.hasEvidenceType(evidenceTypeId: EvidenceTypeId): Boolean {
        return specifiesEvidenceType.any { evidenceType ->
            evidenceType.identifier == evidenceTypeId
        }
    }
}
