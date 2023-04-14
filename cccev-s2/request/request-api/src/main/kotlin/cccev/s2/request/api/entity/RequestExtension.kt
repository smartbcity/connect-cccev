package cccev.s2.request.api.entity

import cccev.projection.api.entity.concept.InformationConceptEntity
import cccev.projection.api.entity.evidencetype.EvidenceTypeEntity
import cccev.projection.api.entity.request.EvidenceEntity
import cccev.projection.api.entity.request.RequestEntity
import cccev.projection.api.entity.requirement.RequirementEntity
import cccev.s2.request.domain.model.Evidence
import cccev.s2.request.domain.model.Request
import cccev.s2.request.domain.model.RequirementStats
import cccev.s2.requirement.domain.RequirementId

fun RequestEntity.toRequest() = Request(
    id = id,
    name = name,
    description = description,
    startDate = startDate,
    endDate = endDate,
    estimatedEndDate = estimatedEndDate,
    creator = creator,
    executor = executor,
    validator = validator,
    isPublic = isPublic,
    issuable = issuable,
    verifiable = verifiable,
    verifier = verifier,
    verificationDate = verificationDate,
    requirements = requirements.map(RequirementEntity::id),
    evidences = evidences.map(EvidenceEntity::toEvidence),
    supportedValues = supportedValues.associate { it.providesValueFor.id to it.value },
    requirementStats = computeRequirementStats()
)

fun EvidenceEntity.toEvidence() = Evidence(
    id = id,
    name = name,
    file = file,
    url = url,
    isConformantTo = isConformantTo.map(EvidenceTypeEntity::id),
)

fun RequestEntity.computeRequirementStats(): Map<RequirementId, RequirementStats> {
    val stats = mutableMapOf<RequirementId, RequirementStats>()
    val values = supportedValues.associate { it.providesValueFor.id to it.value }

    fun RequirementEntity.completion(): Double {
        val childrenCompletions = hasRequirement.map { stats[it.id]!!.completion }

        val concepts = hasConcept.ifEmpty { null }
            ?.flatMap {
                if (it.dependsOn.orEmpty().isNotEmpty()) {
                    it.dependsOn!!
                } else {
                    listOf(it)
                }
            }?.distinctBy(InformationConceptEntity::id)

        val thisCompletion = concepts
            ?.count { values[it.id] != null }
            ?.let { count -> count * 100.0 / concepts.size }

        return (childrenCompletions + thisCompletion).filterNotNull()
            .ifEmpty { null }
            ?.average()
            ?: 100.0
    }

    fun RequirementEntity.computeStats() {
        if (stats[id] != null) return

        hasRequirement.forEach(RequirementEntity::computeStats)

        stats[id] = RequirementStats(
            id = id,
            completion = completion()
        )
    }

    requirements.forEach(RequirementEntity::computeStats)

    return stats
}
