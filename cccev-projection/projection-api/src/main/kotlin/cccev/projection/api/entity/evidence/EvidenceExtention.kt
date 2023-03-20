package cccev.projection.api.entity.evidence

import cccev.dsl.model.Evidence


fun EvidenceEntity.toEvidence() = Evidence(
    identifier = id,
//    type = status,
    name = name,
    isConformantTo = emptyList(),
    supportsValue = emptyList(),
    supportsConcept = emptyList(),
    supportsRequirement = emptyList(),
    validityPeriod = null,
)

