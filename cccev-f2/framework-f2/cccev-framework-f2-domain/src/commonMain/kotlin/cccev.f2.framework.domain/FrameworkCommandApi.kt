package cccev.f2.framework.domain

import cccev.f2.framework.domain.command.FrameworkCreateFunction

interface FrameworkCommandApi {
    fun frameworkCreate(): FrameworkCreateFunction
}
