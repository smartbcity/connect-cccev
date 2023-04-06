package cccev.s2.concept.domain

import cccev.s2.concept.domain.model.InformationConcept

interface InformationConceptFinder {
    suspend fun getOrNull(id: InformationConceptId): InformationConcept?
    suspend fun get(id: InformationConceptId): InformationConcept
    suspend fun getByIdentifierOrNull(identifier: String): InformationConcept?
    suspend fun getByIdentifier(identifier: String): InformationConcept
}
