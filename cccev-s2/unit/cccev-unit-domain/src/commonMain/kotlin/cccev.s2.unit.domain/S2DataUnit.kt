package cccev.s2.unit.domain

import cccev.s2.unit.domain.command.DataUnitCreateCommand
import cccev.s2.unit.domain.command.DataUnitCreatedEvent
import kotlin.js.JsExport
import kotlin.js.JsName
import s2.dsl.automate.Evt
import s2.dsl.automate.S2Command
import s2.dsl.automate.S2InitCommand
import s2.dsl.automate.S2Role
import s2.dsl.automate.S2State
import s2.dsl.automate.builder.s2Sourcing
import s2.dsl.automate.model.WithS2Id

/**
 * Id of a DataUnit
 * @visual json "aeb2c258-9eab-4e55-9e52-77db89aaabfb"
 * @parent [D2DataUnitPage]
 * @order 15
 */
typealias DataUnitId = String

/**
 * Identifier of a DataUnit
 * @visual json "TheDataUnitIdentifier
 * @parent [D2DataUnitPage]
 * @order 15
 */
typealias DataUnitIdentifier = String

val s2DataUnit = s2Sourcing {
	name = "DataUnitS2"
	init<DataUnitCreateCommand, DataUnitCreatedEvent> {
		to = DataUnitState.EXISTS
		role = EditorRole
	}
}

enum class DataUnitState(override var position: Int): S2State {
	EXISTS(0)
}

object EditorRole: S2Role
object AuditorRole: S2Role

@JsExport
@JsName("DataUnitInitCommand")
interface DataUnitInitCommand: S2InitCommand

@JsExport
@JsName("DataUnitCommand")
interface DataUnitCommand: S2Command<DataUnitId>

@JsExport
@JsName("DataUnitEvent")
interface DataUnitEvent: Evt, WithS2Id<DataUnitId>
