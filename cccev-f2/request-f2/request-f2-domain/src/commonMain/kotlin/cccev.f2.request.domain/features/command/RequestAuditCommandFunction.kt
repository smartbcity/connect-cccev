package cccev.f2.request.domain.features.command

import cccev.s2.request.domain.features.command.RequestAuditCommand
import cccev.s2.request.domain.features.command.RequestAuditedEvent
import f2.dsl.fnc.F2Function

/**
 * Audit to a request.
 * @D2 function
 * @parent [cccev.f2.request.domain.features.D2RequestApiPage]
 * @child [ cccev.s2.request.domain.features.command.RequestAuditCommandDTO]
 * @child [ cccev.s2.request.domain.features.command.RequestAuditedEventDTO]
 */
typealias RequestAuditCommandFunction = F2Function<RequestAuditCommand, RequestAuditedEvent>
