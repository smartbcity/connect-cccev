package cccev.f2.concept.domain

import cccev.f2.concept.domain.query.InformationConceptGetByIdentifierFunction
import cccev.f2.concept.domain.query.InformationConceptGetFunction

interface InformationConceptQueryApi {
    fun conceptGet(): InformationConceptGetFunction
    fun conceptGetByIdentifier(): InformationConceptGetByIdentifierFunction
}
