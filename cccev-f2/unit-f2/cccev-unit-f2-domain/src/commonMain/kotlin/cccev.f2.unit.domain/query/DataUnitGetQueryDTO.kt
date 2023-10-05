package cccev.f2.unit.domain.query

import cccev.f2.unit.domain.D2DataUnitF2Page
import cccev.f2.unit.domain.model.DataUnitDTO
import cccev.f2.unit.domain.model.DataUnitDTOBase
import cccev.s2.unit.domain.DataUnitId
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

/**
 * Get a data unit by its id.
 * @d2 function
 * @parent [D2DataUnitF2Page]
 */
typealias DataUnitGetFunction = F2Function<DataUnitGetQueryDTOBase, DataUnitGetResultDTOBase>

/**
 * @d2 query
 * @parent [DataUnitGetFunction]
 */
@JsExport
@JsName("DataUnitGetQueryDTO")
interface DataUnitGetQueryDTO {
    /**
     * Identifier of the data unit to get.
     */
    val id: DataUnitId
}

/**
 * @d2 inherit
 */
@Serializable
data class DataUnitGetQueryDTOBase(
    override val id: DataUnitId
): DataUnitGetQueryDTO

/**
 * @d2 result
 * @parent [DataUnitGetFunction]
 */
@JsExport
@JsName("DataUnitGetResultDTO")
interface DataUnitGetResultDTO {
    /**
     * The retrieved data unit.
     */
    val item: DataUnitDTO?
}

/**
 * @d2 inherit
 */
@Serializable
data class DataUnitGetResultDTOBase(
    override val item: DataUnitDTOBase? = null
): DataUnitGetResultDTO
