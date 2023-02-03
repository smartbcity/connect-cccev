package cccev.f2.request.domain.features.command

import cccev.s2.request.domain.features.command.RequestSignCommand
import cccev.s2.request.domain.features.command.RequestSignedEvent
import f2.dsl.fnc.F2Function

/**
 * Sign to a request.
 * @D2 function
 * @parent [cccev.f2.request.domain.features.D2RequestApiPage]
 * @child [RequestSignCommand]
 * @child [RequestSignedEvent]
 */
typealias RequestSignCommandFunction = F2Function<RequestSignCommand, RequestSignedEvent>
