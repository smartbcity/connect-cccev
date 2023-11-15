package cccev.s2.unit.domain.command

import cccev.s2.unit.domain.D2DataUnitPage
import cccev.s2.unit.domain.DataUnitEvent
import cccev.s2.unit.domain.DataUnitId
import cccev.s2.unit.domain.DataUnitIdentifier
import cccev.s2.unit.domain.DataUnitInitCommand
import cccev.s2.unit.domain.DataUnitState
import cccev.s2.unit.domain.model.DataUnitOption
import cccev.s2.unit.domain.model.DataUnitType
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
    val type: DataUnitType,

    /**
     * @ref [cccev.s2.unit.domain.model.DataUnit.options]
     */
    val options: List<DataUnitOption>?
): DataUnitInitCommand

/**
 * @d2 inherit
 */
@Serializable
data class DataUnitCreatedEvent(
    val id: DataUnitId,
    val identifier: DataUnitIdentifier,
    val name: String,
    val description: String,
    val notation: String?,
    val type: DataUnitType,
    val options: List<DataUnitOption>?,
    val status: DataUnitState
): DataUnitEvent {
    override fun s2Id() = id
}
