package cccev.s2.unit.domain.command

import cccev.s2.unit.domain.D2DataUnitPage
import cccev.s2.unit.domain.DataUnitEvent
import cccev.s2.unit.domain.DataUnitId
import cccev.s2.unit.domain.DataUnitInitCommand
import cccev.s2.unit.domain.model.DataUnitType
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Create a new data unit.
 * @d2 function
 * @parent [D2DataUnitPage]
 */
interface DataUnitCreateFunction

/**
 * @d2 command
 * @parent [DataUnitCreateFunction]
 */
data class DataUnitCreateCommand(
    /**
     * The name of the data unit.
     * @example [cccev.s2.unit.domain.model.DataUnit.name]
     */
    val name: String,

    /**
     * The description of the data unit.
     * @example [cccev.s2.unit.domain.model.DataUnit.description]
     */
    val description: String,

    /**
     * The notation of the data unit.
     * @example [cccev.s2.unit.domain.model.DataUnit.notation]
     */
    val notation: String?,

    /**
     * The type of data used for this data unit.
     * @example [cccev.s2.unit.domain.model.DataUnit.type]
     */
    val type: DataUnitType
): DataUnitInitCommand

/**
 * @d2 event
 * @parent [DataUnitCreateFunction]
 */
@JsExport
@JsName("DataUnitCreatedEventDTO")
interface DataUnitCreatedEventDTO: DataUnitEvent

/**
 * @d2 inherit
 */
data class DataUnitCreatedEvent(
    /**
     * The id of the created data unit.
     */
    override val id: DataUnitId
): DataUnitCreatedEventDTO
