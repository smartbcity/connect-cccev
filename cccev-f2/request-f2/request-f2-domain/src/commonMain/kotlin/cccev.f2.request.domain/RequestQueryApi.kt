package cccev.f2.request.domain

import cccev.f2.request.domain.query.RequestGetFunction

interface RequestQueryApi {
    /** Get request */
    fun requestGet(): RequestGetFunction
}
