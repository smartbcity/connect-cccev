package cccev.s2.unit.domain.command

import cccev.s2.unit.domain.D2DataUnitPage
import cccev.s2.unit.domain.DataUnitEvent
import cccev.s2.unit.domain.DataUnitId
import cccev.s2.unit.domain.DataUnitIdentifier
import cccev.s2.unit.domain.DataUnitInitCommand
import cccev.s2.unit.domain.DataUnitState
import cccev.s2.unit.domain.model.DataUnitType
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

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
@Serializable
data class DataUnitCreateCommand(
    /**
     * The identifier of the data unit.
     * @example [cccev.s2.unit.domain.model.DataUnit.name]
     */
    val identifier: DataUnitIdentifier,
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
    val notation: String? = null,

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
interface DataUnitCreatedEventDTO: DataUnitEvent {
    /**
     * Id of the created unit
     */
    val id: DataUnitId
    /**
     * Identifier of the created unit
     */
    val identifier: DataUnitId

    /**
     * @ref [DataUnitCreateCommand.name]
     */
    val name: String

    /**
     * @ref [DataUnitCreateCommand.description]
     */
    val description: String

    /**
     * @ref [DataUnitCreateCommand.notation]
     */
    val notation: String?

    /**
     * @ref [DataUnitCreateCommand.type]
     */
    val type: DataUnitType

    val status: DataUnitState
}

/**
 * @d2 inherit
 */
@Serializable
data class DataUnitCreatedEvent(
    override val id: DataUnitId,
    override val identifier: DataUnitIdentifier,
    override val name: String,
    override val description: String,
    override val notation: String? = null,
    override val type: DataUnitType,
    override val status: DataUnitState
): DataUnitCreatedEventDTO {
    override fun s2Id() = id
}
