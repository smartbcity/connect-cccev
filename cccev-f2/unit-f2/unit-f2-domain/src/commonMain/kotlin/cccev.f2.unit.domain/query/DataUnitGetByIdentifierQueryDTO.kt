package cccev.f2.unit.domain.query

import cccev.f2.unit.domain.D2DataUnitF2Page
import cccev.f2.unit.domain.model.DataUnitDTO
import cccev.f2.unit.domain.model.DataUnitDTOBase
import cccev.s2.unit.domain.DataUnitId
import cccev.s2.unit.domain.DataUnitIdentifier
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

/**
 * Get a data unit by its id.
 * @d2 function
 * @parent [D2DataUnitF2Page]
 */
typealias DataUnitGetByIdentifierFunction = F2Function<DataUnitGetByIdentifierQueryDTOBase, DataUnitGetByIdentifierResultDTOBase>

/**
 * @d2 query
 * @parent [DataUnitGetByIdentifierFunction]
 */
@JsExport
@JsName("DataUnitGetByIdentifierQueryDTO")
interface DataUnitGetByIdentifierQueryDTO {
    /**
     * Identifier of the data unit to get.
     */
    val identifier: DataUnitIdentifier
}

/**
 * @d2 inherit
 */
@Serializable
data class DataUnitGetByIdentifierQueryDTOBase(
    override val identifier: DataUnitIdentifier
): DataUnitGetByIdentifierQueryDTO

/**
 * @d2 result
 * @parent [DataUnitGetByIdentifierFunction]
 */
@JsExport
@JsName("DataUnitGetByIdentifierResultDTO")
interface DataUnitGetByIdentifierResultDTO {
    /**
     * The retrieved data unit.
     */
    val item: DataUnitDTO?
}

/**
 * @d2 inherit
 */
@Serializable
data class DataUnitGetByIdentifierResultDTOBase(
    override val item: DataUnitDTOBase? = null
): DataUnitGetByIdentifierResultDTO
