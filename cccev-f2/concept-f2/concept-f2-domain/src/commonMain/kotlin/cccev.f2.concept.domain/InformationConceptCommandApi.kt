package cccev.f2.concept.domain

import cccev.f2.concept.domain.command.InformationConceptCreateFunction

interface InformationConceptCommandApi {
    fun conceptCreate(): InformationConceptCreateFunction
}
