package cccev.dsl.model

import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
@JsName("CUnitDTO")
interface CUnitDTO {
    val identifier: String
    val name: String
    val description: String
    val notation: String?
    val type: CUnitType
}

open class CUnit(
    override val identifier: String,
    override val name: String,
    override val description: String,
    override val notation: String? = null,
    override val type: CUnitType
): CUnitDTO

@Suppress("EnumNaming")
enum class CUnitType {
    boolean, date, number, string
}

object XSDDate: CUnit(
    identifier = "xsdDate",
    name = "XSDDate",
    description = "Date",
    type = CUnitType.date
)

object XSDDouble: CUnit(
    identifier = "xsdDouble",
    name = "XSDDouble",
    description = "Nombre réel quelconque",
    type = CUnitType.number
)

object XSDInt: CUnit(
    identifier = "xsdInt",
    name = "XSDInt",
    description = "Nombre entier quelconque",
    type = CUnitType.number
)

object XSDString: CUnit(
    identifier = "xsdString",
    name = "XSDString",
    description = "Chaîne de caractères quelconque",
    type = CUnitType.string
)

object XSDBoolean: CUnit(
    identifier = "xsdBoolean",
    name = "XSDBoolean",
    description = "Vrai ou faux",
    type = CUnitType.boolean
)

object Duration {
    object Hour: CUnit(
        identifier = "hourDuration",
        name = "Durée en heures",
        description = "Durée en heures",
        notation = "h",
        type = CUnitType.number
    )
    object Year: CUnit(
        identifier = "yearDuration",
        name = "Durée en années",
        description = "Durée en années",
        notation = "an(s)",
        type = CUnitType.number
    )
}

object Ratio: CUnit(
    identifier = "ration",
    name = "Ration",
    description = "Ratio entre deux valeurs",
    notation = "%",
    type = CUnitType.number
)

object SquareMeter: CUnit(
    identifier = "squareMeter",
    name = "Mètre carré",
    description = "Mètre carré",
    notation = "m²",
    type = CUnitType.number
)

object CubicMeter: CUnit(
    identifier = "cubicMeter",
    name = "Mètre cube",
    description = "Mètre cube",
    notation = "m³",
    type = CUnitType.number
)
