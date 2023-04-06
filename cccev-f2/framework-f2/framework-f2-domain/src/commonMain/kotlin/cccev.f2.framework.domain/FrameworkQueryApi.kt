package cccev.f2.framework.domain

import cccev.f2.framework.domain.query.FrameworkGetFunction

interface FrameworkQueryApi {
    fun frameworkGet(): FrameworkGetFunction
}
