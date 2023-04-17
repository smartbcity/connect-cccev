package cccev.s2.certification.domain

import cccev.s2.certification.domain.command.CertificationAddEvidenceCommand
import cccev.s2.certification.domain.command.CertificationAddRequirementsCommand
import cccev.s2.certification.domain.command.CertificationAddValuesCommand
import cccev.s2.certification.domain.command.CertificationAddedEvidenceEvent
import cccev.s2.certification.domain.command.CertificationAddedRequirementsEvent
import cccev.s2.certification.domain.command.CertificationAddedValuesEvent
import cccev.s2.certification.domain.command.CertificationCreateCommand
import cccev.s2.certification.domain.command.CertificationCreatedEvent
import cccev.s2.certification.domain.command.CertificationRemoveEvidenceCommand
import cccev.s2.certification.domain.command.CertificationRemoveRequirementsCommand
import cccev.s2.certification.domain.command.CertificationRemovedEvidenceEvent
import cccev.s2.certification.domain.command.CertificationRemovedRequirementsEvent
import cccev.s2.certification.domain.model.CertificationId
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable
import s2.dsl.automate.Evt
import s2.dsl.automate.S2Command
import s2.dsl.automate.S2InitCommand
import s2.dsl.automate.S2Role
import s2.dsl.automate.S2State
import s2.dsl.automate.WithId
import s2.dsl.automate.builder.s2Sourcing
import s2.dsl.automate.model.WithS2Id

val s2Ceritification = s2Sourcing {
	name = "CertificationS2"
	init<CertificationCreateCommand, CertificationCreatedEvent> {
		to = CertificationState.CREATED
		role = EditorRole()
	}
	selfTransaction<CertificationAddValuesCommand, CertificationAddedValuesEvent> {
		states += CertificationState.CREATED
		role = EditorRole()
	}
	selfTransaction<CertificationAddEvidenceCommand, CertificationAddedEvidenceEvent> {
		states += CertificationState.CREATED
		role = EditorRole()
	}
	selfTransaction<CertificationRemoveEvidenceCommand, CertificationRemovedEvidenceEvent> {
		states += CertificationState.CREATED
		role = EditorRole()
	}
	selfTransaction<CertificationAddRequirementsCommand, CertificationAddedRequirementsEvent> {
		states += CertificationState.CREATED
		role = EditorRole()
	}
	selfTransaction<CertificationRemoveRequirementsCommand, CertificationRemovedRequirementsEvent> {
		states += CertificationState.CREATED
		role = EditorRole()
	}
}

@Serializable
enum class CertificationState(override var position: Int): S2State {
	CREATED(0)
}

class EditorRole: S2Role
class AuditorRole: S2Role

@JsExport
@JsName("CertificationInitCommand")
interface CertificationInitCommand: S2InitCommand

@JsExport
@JsName("CertificationCommand")
interface CertificationCommand: S2Command<CertificationId>

@JsExport
@JsName("CertificationEvent")
interface CertificationEvent: Evt, WithS2Id<CertificationId>, WithId<CertificationId> {
	override fun s2Id() = id
}
