package cccev.projection.api.entity.request

import cccev.projection.api.entity.evidence.toEvidence
import cccev.s2.request.domain.model.Request

fun RequestEntity.toRequest() = Request(
    id = id,
    status = status,
    frameworkId = frameworkId,
    evidences = evidences.map { it.toEvidence() }.toMutableList(),
    supportedValues = emptyMap()
//    supportedValues = supportedValues
)

