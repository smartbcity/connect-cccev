package cccev.f2.request.api.domain.features.command

import cccev.s2.request.domain.features.command.RequestSupportedValueAddCommand
import cccev.s2.request.domain.features.command.RequestSupportedValueAddedEvent
import f2.dsl.fnc.F2Function

/**
 * Add a Supported Value to a request.
 * @D2 function
 * @parent [cccev.s2.request.domain.RequestAggregate]
 */
typealias RequestSupportedValueAddCommandFunction = F2Function<RequestSupportedValueAddCommand, RequestSupportedValueAddedEvent>
