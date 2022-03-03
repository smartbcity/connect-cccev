package cccev.f2.request.api.domain.features.command

import cccev.s2.request.domain.features.command.RequestRefuseCommand
import cccev.s2.request.domain.features.command.RequestRefusedEvent
import f2.dsl.fnc.F2Function

/**
 * Refuse to a request.
 * @D2 function
 * @parent [cccev.s2.request.domain.RequestAggregate]
 */
typealias RequestRefuseCommandFunction = F2Function<RequestRefuseCommand, RequestRefusedEvent>
