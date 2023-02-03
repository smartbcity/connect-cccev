package cccev.s2.requirement.domain

import cccev.s2.requirement.domain.features.command.RequirementCreateCommand
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
	init<RequirementCreateCommand> {
		to = RequirementState.Created
		role = EditorRole()
	}
}
typealias RequirementId = String
open class RequirementState(override var position: Int): S2State {
	object Created: RequirementState(position = 0)
}

class EditorRole: S2Role
class AuditorRole: S2Role

@JsExport
@JsName("RequirementEvent")
interface RequirementEvent: S2Event<RequirementState, RequirementId>

@JsExport
@JsName("RequirementCommand")
interface RequirementCommand: S2Command<RequirementId>
