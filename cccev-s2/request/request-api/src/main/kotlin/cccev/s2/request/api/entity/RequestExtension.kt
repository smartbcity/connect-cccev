package cccev.s2.request.api.entity

import cccev.projection.api.entity.evidencetype.EvidenceTypeEntity
import cccev.projection.api.entity.request.EvidenceEntity
import cccev.projection.api.entity.request.RequestEntity
import cccev.projection.api.entity.requirement.RequirementEntity
import cccev.s2.request.domain.model.Evidence
import cccev.s2.request.domain.model.Request

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
    supportedValues = supportedValues.associate { it.providesValueFor.id to it.value }
)

fun EvidenceEntity.toEvidence() = Evidence(
    id = id,
    name = name,
    file = file,
    url = url,
    isConformantTo = isConformantTo.map(EvidenceTypeEntity::id),
)
