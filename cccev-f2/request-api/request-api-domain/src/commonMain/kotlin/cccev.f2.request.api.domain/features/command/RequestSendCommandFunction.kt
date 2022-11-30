package cccev.f2.request.api.domain.features.command

import cccev.s2.request.domain.features.command.RequestSendCommand
import cccev.s2.request.domain.features.command.RequestSentEvent
import f2.dsl.fnc.F2Function

/**
 * Send to a request.
 * @D2 function
 * @parent [cccev.f2.request.api.domain.features.D2RequestApiPage]
 * @child [RequestSendCommand]
 * @child [RequestSentEvent]
 */
typealias RequestSendCommandFunction = F2Function<RequestSendCommand, RequestSentEvent>
