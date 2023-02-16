package cccev.s2.unit.domain.model

import cccev.s2.unit.domain.D2DataUnitPage
import cccev.s2.unit.domain.DataUnitId

/**
 * Represents a unit of data, such as a physical measurement, date, or number.
 * @d2 model
 * @parent [D2DataUnitPage]
 * @order 10
 */
data class DataUnit(
    /**
     * Unique identifier of this data unit.
     */
    val id: DataUnitId,

    /**
     * The name of this data unit.
     * @example "Meter"
     */
    val name: String,

    /**
     * A description of this data unit.
     * @example "A unit of length in the International System of Units (SI)."
     */
    val description: String,

    /**
     * The short notation for this data unit, if applicable.
     * @example "m"
     */
    val notation: String?,

    /**
     * The type of data used for this data unit.
     * @example "NUMBER"
     */
    val type: DataUnitType
)
