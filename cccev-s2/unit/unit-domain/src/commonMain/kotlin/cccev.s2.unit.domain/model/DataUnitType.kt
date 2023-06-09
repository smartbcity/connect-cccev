package cccev.s2.unit.domain.model

import cccev.s2.unit.domain.D2DataUnitPage

/**
 * Type of a data. <br/>
 * Can be either of: BOOLEAN, DATE, NUMBER, STRING
 * @d2 model
 * @parent [D2DataUnitPage]
 * @order 20
 */
enum class DataUnitType {
    BOOLEAN, DATE, NUMBER, STRING
}
