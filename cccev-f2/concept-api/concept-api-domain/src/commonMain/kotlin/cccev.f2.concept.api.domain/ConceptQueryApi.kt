package cccev.f2.concept.api.domain

import cccev.f2.concept.api.domain.features.query.GetInformationConceptsQueryFunction

interface ConceptQueryApi {

    /**
     * Get Information Concepts
     */
    fun getInformationConcepts(): GetInformationConceptsQueryFunction

}
