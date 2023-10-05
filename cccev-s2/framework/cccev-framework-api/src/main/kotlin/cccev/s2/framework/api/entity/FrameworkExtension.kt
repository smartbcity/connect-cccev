package cccev.s2.framework.api.entity

import cccev.projection.api.entity.framework.FrameworkEntity
import cccev.s2.framework.domain.model.Framework

fun FrameworkEntity.toFramework() = Framework(
    id = id,
    identifier = identifier,
    name = name
)
