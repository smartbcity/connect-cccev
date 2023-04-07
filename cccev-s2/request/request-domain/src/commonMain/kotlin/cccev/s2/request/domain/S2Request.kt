package cccev.s2.request.domain

import cccev.s2.request.domain.command.RequestAddEvidenceCommand
import cccev.s2.request.domain.command.RequestAddRequirementsCommand
import cccev.s2.request.domain.command.RequestAddValuesCommand
import cccev.s2.request.domain.command.RequestAddedEvidenceEvent
import cccev.s2.request.domain.command.RequestAddedRequirementsEvent
import cccev.s2.request.domain.command.RequestAddedValuesEvent
import cccev.s2.request.domain.command.RequestCreateCommand
import cccev.s2.request.domain.command.RequestCreatedEvent
import cccev.s2.request.domain.command.RequestRemoveEvidenceCommand
import cccev.s2.request.domain.command.RequestRemoveRequirementsCommand
import cccev.s2.request.domain.command.RequestRemovedEvidenceEvent
import cccev.s2.request.domain.command.RequestRemovedRequirementsEvent
import cccev.s2.request.domain.model.RequestId
import kotlinx.serialization.Serializable
import s2.dsl.automate.Evt
import s2.dsl.automate.S2Command
import s2.dsl.automate.S2InitCommand
import s2.dsl.automate.S2Role
import s2.dsl.automate.S2State
import s2.dsl.automate.WithId
import s2.dsl.automate.builder.s2Sourcing
import s2.dsl.automate.model.WithS2Id
import kotlin.js.JsExport
import kotlin.js.JsName

val s2Request = s2Sourcing {
	name = "RequestS2"
	init<RequestCreateCommand, RequestCreatedEvent> {
		to = RequestState.CREATED
		role = EditorRole()
	}
	selfTransaction<RequestAddValuesCommand, RequestAddedValuesEvent> {
		name = "AddValues"
		states += RequestState.CREATED
		role = EditorRole()
	}
	selfTransaction<RequestAddEvidenceCommand, RequestAddedEvidenceEvent> {
		name = "AddEvidence"
		states += RequestState.CREATED
		role = EditorRole()
	}
	selfTransaction<RequestRemoveEvidenceCommand, RequestRemovedEvidenceEvent> {
		name = "RemoveEvidence"
		states += RequestState.CREATED
		role = EditorRole()
	}
	selfTransaction<RequestAddRequirementsCommand, RequestAddedRequirementsEvent> {
		name = "AddRequirements"
		states += RequestState.CREATED
		role = EditorRole()
	}
	selfTransaction<RequestRemoveRequirementsCommand, RequestRemovedRequirementsEvent> {
		name = "RemoveRequirements"
		states += RequestState.CREATED
		role = EditorRole()
	}
}

@Serializable
enum class RequestState(override var position: Int): S2State {
	CREATED(0)
}

class EditorRole: S2Role
class AuditorRole: S2Role

@JsExport
@JsName("RequestInitCommand")
interface RequestInitCommand: S2InitCommand

@JsExport
@JsName("RequestCommand")
interface RequestCommand: S2Command<RequestId>

@JsExport
@JsName("RequestEvent")
interface RequestEvent: Evt, WithS2Id<RequestId>, WithId<RequestId> {
	override fun s2Id() = id
}
