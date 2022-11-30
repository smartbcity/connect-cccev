package cccev.f2.request.api.domain.features.command

import cccev.s2.request.domain.features.command.RequestInitCommand
import cccev.s2.request.domain.features.command.RequestInitializedEvent
import f2.dsl.fnc.F2Function

/**
 * Init a request.
 * @D2 function
 * @parent [cccev.f2.request.api.domain.features.D2RequestApiPage]
 * @child [RequestInitCommand]
 * @child [RequestInitializedEvent]
 */
typealias RequestInitCommandFunction = F2Function<RequestInitCommand, RequestInitializedEvent>
