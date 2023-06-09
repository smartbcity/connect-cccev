package cccev.test.s2.unit.data

import cccev.s2.unit.domain.model.DataUnitType
import kotlin.reflect.jvm.jvmName
import s2.bdd.data.parser.EntryParser

private val dataUnitTypeParser = EntryParser(
    parseErrorMessage = "DataUnit type must be in ${DataUnitType::class.jvmName} values",
    parser = String::toDataUnitType
)

fun Map<String, String>.extractDataUnitType(key: String) = dataUnitTypeParser.single(this, key)
fun Map<String, String>.extractDataUnitTypeList(key: String) = dataUnitTypeParser.list(this, key)

fun String.toDataUnitType() = DataUnitType.valueOf(this)
