package cccev.f2.request.domain.features.command

import cccev.s2.request.domain.features.command.RequestEvidenceRemoveCommand
import cccev.s2.request.domain.features.command.RequestEvidenceRemovedEvent
import f2.dsl.fnc.F2Function

/**
 * Remove evidence from a request.
 * @D2 function
 * @parent [cccev.f2.request.domain.features.D2RequestApiPage]
 * @child [RequestEvidenceRemoveCommand]
 * @child [RequestEvidenceRemovedEvent]
 */
typealias RequestEvidenceRemoveCommandFunction
        = F2Function<RequestEvidenceRemoveCommand, RequestEvidenceRemovedEvent>
