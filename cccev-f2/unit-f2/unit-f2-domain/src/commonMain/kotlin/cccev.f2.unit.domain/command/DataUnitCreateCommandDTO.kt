package cccev.f2.unit.domain.command

import cccev.f2.unit.domain.D2DataUnitF2Page
import cccev.s2.unit.domain.command.DataUnitCreatedEvent
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

/**
 * Create a new data unit.
 * @d2 function
 * @parent [D2DataUnitF2Page]
 */
typealias DataUnitCreateFunction = F2Function<DataUnitCreateCommandDTOBase, DataUnitCreatedEvent>

/**
 * @d2 command
 * @parent [DataUnitCreateFunction]
 */
@JsExport
@JsName("DataUnitCreateCommandDTO")
interface DataUnitCreateCommandDTO {
    /**
     * The name of the data unit.
     * @example [cccev.s2.unit.domain.model.DataUnit.name]
     */
    val name: String

    /**
     * The description of the data unit.
     * @example [cccev.s2.unit.domain.model.DataUnit.description]
     */
    val description: String

    /**
     * The notation of the data unit.
     * @example [cccev.s2.unit.domain.model.DataUnit.notation]
     */
    val notation: String?

    /**
     * The type of data used for this data unit. <br/>
     * See [cccev.s2.unit.domain.model.DataUnitType]
     * @example [cccev.s2.unit.domain.model.DataUnit.type]
     */
    val type: String
}

/**
 * @d2 inherit
 */
@Serializable
data class DataUnitCreateCommandDTOBase(
    override val name: String,
    override val description: String,
    override val notation: String? = null,
    override val type: String
): DataUnitCreateCommandDTO

/**
 * @d2 event
 * @parent [DataUnitCreateFunction]
 */
@JsExport
@JsName("DataUnitCreatedEventDTO")
interface DataUnitCreatedEventDTO: cccev.s2.unit.domain.command.DataUnitCreatedEventDTO
