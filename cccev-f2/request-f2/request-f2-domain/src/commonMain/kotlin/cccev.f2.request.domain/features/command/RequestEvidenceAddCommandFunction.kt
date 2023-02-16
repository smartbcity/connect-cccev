package cccev.f2.request.domain.features.command

import cccev.s2.request.domain.features.command.RequestEvidenceAddCommand
import cccev.s2.request.domain.features.command.RequestEvidenceAddedEvent
import f2.dsl.fnc.F2Function

/**
 * Add evidence to a request.
 * @D2 function
 * @parent [cccev.f2.request.domain.features.D2RequestApiPage]
 * TODO FIX child recovery with d2 inherit
 * @//child [RequestEvidenceAddCommand]
 * @//child [RequestEvidenceAddedEvent]
 * @child [cccev.s2.request.domain.features.command.RequestEvidenceAddCommandDTO]
 * @child [cccev.s2.request.domain.features.command.RequestEvidenceAddedEventDTO]
 */
typealias RequestEvidenceAddCommandFunction
        = F2Function<RequestEvidenceAddCommand, RequestEvidenceAddedEvent>
