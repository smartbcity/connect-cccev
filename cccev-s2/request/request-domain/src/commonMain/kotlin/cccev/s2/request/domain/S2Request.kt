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
import kotlinx.serialization.Serializable
import s2.dsl.automate.model.WithS2Id

fun s2Request() = S2Request

val S2Request = s2 {
	name = "RequestS2"
	init<RequestInitCommand> {
		to = RequestState.CREATED
		role = EditorRole()
	}
	transaction<RequestEvidenceAddCommand> {
		from = RequestState.CREATED
		to = RequestState.CREATED
		role = EditorRole()
	}
	transaction<RequestEvidenceRemoveCommand> {
		from = RequestState.CREATED
		to = RequestState.CREATED
		role = EditorRole()
	}
	transaction<RequestSupportedValueAddCommand> {
		from = RequestState.CREATED
		to = RequestState.CREATED
		role = EditorRole()
	}
	transaction<RequestSendCommand> {
		from = RequestState.CREATED
		to = RequestState.SENT
		role = EditorRole()
	}
	transaction<RequestEvidenceAddCommand> {
		from = RequestState.SENT
		to = RequestState.SENT
		role = EditorRole()
	}
	transaction<RequestEvidenceRemoveCommand> {
		from = RequestState.SENT
		to = RequestState.SENT
		role = EditorRole()
	}
	transaction<RequestSupportedValueAddCommand> {
		from = RequestState.SENT
		to = RequestState.SENT
		role = EditorRole()
	}
	transaction<RequestSendCommand> {
		from = RequestState.SENT
		to = RequestState.SENT
		role = EditorRole()
	}
	transaction<RequestSignCommand> {
		from = RequestState.SENT
		to = RequestState.SIGNED
		role = EditorRole()
	}
	transaction<RequestAuditCommand> {
		from = RequestState.SIGNED
		to = RequestState.AUDITED
		role = EditorRole()
	}
	transaction<RequestRefuseCommand> {
		from = RequestState.SIGNED
		to = RequestState.CREATED
		role = EditorRole()
	}
}

@Serializable
enum class RequestState(override var position: Int): S2State {
	CREATED(position = 0),
	SENT(position = 10),
	SIGNED(position = 20),
	AUDITED(position = 30)
}

//open class RequestState(override var position: Int): S2State {
//	@Serializable
//	object Created: RequestState(position = 0)
//	@Serializable
//	object Sent: RequestState(position = 10)
//	@Serializable
//	object Signed: RequestState(position = 20)
//	@Serializable
//	object Audited: RequestState(position = 30)
//}

class EditorRole: S2Role
class AuditorRole: S2Role

@JsExport
@JsName("RequestEvent")
interface RequestEvent: S2Event<RequestState, RequestId>, WithS2Id<RequestId> {
	override fun s2Id() = id
}

@JsExport
@JsName("RequestCommand")
interface RequestCommand: S2Command<RequestId>
