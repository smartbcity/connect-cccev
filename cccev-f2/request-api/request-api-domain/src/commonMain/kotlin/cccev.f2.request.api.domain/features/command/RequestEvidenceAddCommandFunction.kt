package cccev.f2.request.api.domain.features.command

import cccev.s2.request.domain.features.command.RequestEvidenceAddCommand
import cccev.s2.request.domain.features.command.RequestEvidenceAddedEvent
import f2.dsl.fnc.F2Function

/**
 * Add evidence to a request.
 * @D2 function
 * @parent [cccev.s2.request.domain.RequestAggregate]
 */
typealias RequestEvidenceAddCommandFunction = F2Function<RequestEvidenceAddCommand, RequestEvidenceAddedEvent>
