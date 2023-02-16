package cccev.s2.request.api.entity

import cccev.s2.request.domain.model.Request

fun RequestEntity.toRequest() = Request(
    id = id,
    status = status,
    frameworkId = frameworkId,
    evidences = evidences,
    supportedValues = supportedValues
)
