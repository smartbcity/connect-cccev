package cccev.f2.concept.domain

import cccev.f2.concept.domain.features.query.GetInformationConceptsQueryFunction

interface ConceptQueryApi {

    /**
     * Get Information Concepts
     */
    fun getInformationConcepts(): GetInformationConceptsQueryFunction

}
