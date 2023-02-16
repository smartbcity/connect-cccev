package cccev.f2.request.domain.features.command

import cccev.s2.request.domain.features.command.RequestRefuseCommand
import cccev.s2.request.domain.features.command.RequestRefusedEvent
import f2.dsl.fnc.F2Function

/**
 * Refuse to a request.
 * @D2 function
 * @parent [cccev.f2.request.domain.features.D2RequestApiPage]
 * @child [RequestRefuseCommand]
 * @child [RequestRefusedEvent]
 */
typealias RequestRefuseCommandFunction = F2Function<RequestRefuseCommand, RequestRefusedEvent>
