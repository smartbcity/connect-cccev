package cccev.s2.framework.domain

import cccev.s2.framework.domain.command.FrameworkCreateCommand
import cccev.s2.framework.domain.command.FrameworkCreatedEvent
import kotlin.js.JsExport
import kotlin.js.JsName
import s2.dsl.automate.Evt
import s2.dsl.automate.S2Command
import s2.dsl.automate.S2InitCommand
import s2.dsl.automate.S2Role
import s2.dsl.automate.S2State
import s2.dsl.automate.WithId
import s2.dsl.automate.builder.s2Sourcing
import s2.dsl.automate.model.WithS2Id

/**
 * @d2 hidden
 * @visual json "06edb0f8-9a87-4aee-b8fa-ad9e811a299a"
 */
typealias FrameworkId = String
typealias FrameworkIdentifier = String

val s2Framework = s2Sourcing {
	name = "FrameworkS2"
	init<FrameworkCreateCommand, FrameworkCreatedEvent> {
		to = FrameworkState.CREATED
		role = EditorRole
	}
}

/**
 * @d2 model
 * @parent [D2FrameworkPage]
 * @order 15
 */
enum class FrameworkState(override var position: Int): S2State {
	CREATED(0)
}

object EditorRole: S2Role
object AuditorRole: S2Role

@JsExport
@JsName("FrameworkInitCommand")
interface FrameworkInitCommand: S2InitCommand

@JsExport
@JsName("FrameworkCommand")
interface FrameworkCommand: S2Command<FrameworkId>

@JsExport
@JsName("FrameworkEvent")
interface FrameworkEvent: Evt, WithS2Id<FrameworkId>, WithId<FrameworkId> {
	override fun s2Id() = id
}
