package cccev.s2.request.domain

import cccev.s2.request.domain.features.command.RequestAuditCommand
import cccev.s2.request.domain.features.command.RequestEvidenceAddCommand
import cccev.s2.request.domain.features.command.RequestEvidenceRemoveCommand
import cccev.s2.request.domain.features.command.RequestInitCommand
import cccev.s2.request.domain.features.command.RequestRefuseCommand
import cccev.s2.request.domain.features.command.RequestSendCommand
import cccev.s2.request.domain.features.command.RequestSignCommand
import cccev.s2.request.domain.features.command.RequestSupportedValueAddCommand
import cccev.s2.request.domain.model.RequestId
import s2.dsl.automate.S2Command
import s2.dsl.automate.S2Event
import s2.dsl.automate.S2Role
import s2.dsl.automate.S2State
import s2.dsl.automate.builder.s2
import kotlin.js.JsExport
import kotlin.js.JsName

fun s2Request() = S2Request

val S2Request = s2 {
	name = "RequestS2"
	init<RequestInitCommand> {
		to = RequestState.Created
		role = EditorRole()
	}
	transaction<RequestEvidenceAddCommand> {
		from = RequestState.Created
		to = RequestState.Created
		role = EditorRole()
	}
	transaction<RequestEvidenceRemoveCommand> {
		from = RequestState.Created
		to = RequestState.Created
		role = EditorRole()
	}
	transaction<RequestSupportedValueAddCommand> {
		from = RequestState.Created
		to = RequestState.Created
		role = EditorRole()
	}
	transaction<RequestSendCommand> {
		from = RequestState.Created
		to = RequestState.Sent
		role = EditorRole()
	}
	transaction<RequestEvidenceAddCommand> {
		from = RequestState.Sent
		to = RequestState.Sent
		role = EditorRole()
	}
	transaction<RequestEvidenceRemoveCommand> {
		from = RequestState.Sent
		to = RequestState.Sent
		role = EditorRole()
	}
	transaction<RequestSupportedValueAddCommand> {
		from = RequestState.Sent
		to = RequestState.Sent
		role = EditorRole()
	}
	transaction<RequestSendCommand> {
		from = RequestState.Sent
		to = RequestState.Sent
		role = EditorRole()
	}
	transaction<RequestSignCommand> {
		from = RequestState.Sent
		to = RequestState.Signed
		role = EditorRole()
	}
	transaction<RequestAuditCommand> {
		from = RequestState.Signed
		to = RequestState.Audited
		role = EditorRole()
	}
	transaction<RequestRefuseCommand> {
		from = RequestState.Signed
		to = RequestState.Created
		role = EditorRole()
	}
}

open class RequestState(override var position: Int): S2State {
	object Created: RequestState(position = 0)
	object Sent: RequestState(position = 10)
	object Signed: RequestState(position = 20)
	object Audited: RequestState(position = 30)
}

class EditorRole: S2Role
class AuditorRole: S2Role

@JsExport
@JsName("RequestEvent")
interface RequestEvent: S2Event<RequestState, RequestId>

@JsExport
@JsName("RequestCommand")
interface RequestCommand: S2Command<RequestId>
