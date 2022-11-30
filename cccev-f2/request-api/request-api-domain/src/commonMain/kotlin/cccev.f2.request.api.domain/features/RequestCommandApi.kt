package cccev.f2.request.api.domain.features

import cccev.f2.request.api.domain.features.command.RequestAuditCommandFunction
import cccev.f2.request.api.domain.features.command.RequestEvidenceAddCommandFunction
import cccev.f2.request.api.domain.features.command.RequestEvidenceRemoveCommandFunction
import cccev.f2.request.api.domain.features.command.RequestInitCommandFunction
import cccev.f2.request.api.domain.features.command.RequestRefuseCommandFunction
import cccev.f2.request.api.domain.features.command.RequestSendCommandFunction
import cccev.f2.request.api.domain.features.command.RequestSignCommandFunction
import cccev.f2.request.api.domain.features.command.RequestSupportedValueAddCommandFunction

interface RequestCommandApi {

    /**
     * Init a Request
     */
    fun initRequest(): RequestInitCommandFunction

    /**
     * Add an evidence to a request
     */
    fun addEvidence(): RequestEvidenceAddCommandFunction

    /**
     * Remove an evidence to a request
     */
    fun removeEvidence(): RequestEvidenceRemoveCommandFunction

    /**
     * Add a supported value
     */
    fun addSupportedValue(): RequestSupportedValueAddCommandFunction

    /**
     * Send a request
     */
    fun sendRequest(): RequestSendCommandFunction

    /**
     * Sign a request
     */
    fun signRequest(): RequestSignCommandFunction

    /**
     * Audit a request
     */
    fun auditRequest(): RequestAuditCommandFunction

    /**
     * Refuse a request
     */
    fun refuseRequest(): RequestRefuseCommandFunction
}