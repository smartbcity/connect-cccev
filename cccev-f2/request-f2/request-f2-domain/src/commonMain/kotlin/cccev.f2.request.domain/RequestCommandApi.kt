package cccev.f2.request.domain

import cccev.f2.request.domain.command.RequestAddRequirementsFunction
import cccev.f2.request.domain.command.RequestAddValuesFunction
import cccev.f2.request.domain.command.RequestCreateFunction
import cccev.f2.request.domain.command.RequestRemoveEvidenceFunction
import cccev.f2.request.domain.command.RequestRemoveRequirementsFunction

interface RequestCommandApi {
    /** Create a request */
    fun requestCreate(): RequestCreateFunction

    /** Add requirements to a request */
    fun requestAddRequirements(): RequestAddRequirementsFunction

    /** Remove requirements from a request */
    fun requestRemoveRequirements(): RequestRemoveRequirementsFunction

    /** Add values to a request */
    fun requestAddValues(): RequestAddValuesFunction

    /** Remove an evidence from a request */
    fun requestRemoveEvidence(): RequestRemoveEvidenceFunction
}
