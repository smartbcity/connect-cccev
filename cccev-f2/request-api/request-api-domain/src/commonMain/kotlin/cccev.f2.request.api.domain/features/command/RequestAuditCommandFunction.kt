package cccev.f2.request.api.domain.features.command

import cccev.s2.request.domain.features.command.RequestAuditCommand
import cccev.s2.request.domain.features.command.RequestAuditedEvent
import f2.dsl.fnc.F2Function

/**
 * Audit to a request.
 * @D2 function
 * @parent [cccev.s2.request.domain.RequestAggregate]
 */
typealias RequestAuditCommandFunction = F2Function<RequestAuditCommand, RequestAuditedEvent>
