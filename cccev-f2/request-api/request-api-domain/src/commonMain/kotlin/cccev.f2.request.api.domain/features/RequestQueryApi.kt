package cccev.f2.request.api.domain.features

import cccev.f2.request.api.domain.features.query.GetRequestScoreQueryFunction

interface RequestQueryApi {
    /**
     * Return the score of a request
     */
    fun getRequestScore(): GetRequestScoreQueryFunction
}