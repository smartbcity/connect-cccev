package cccev.f2.request.domain.features

import cccev.f2.request.domain.features.query.GetRequestScoreQueryFunction

interface RequestQueryApi {
    /**
     * Return the score of a request
     */
    fun getRequestScore(): GetRequestScoreQueryFunction
}
