package features.cccev.test.entities.informationconcept

import cccev.core.dsl.CUnit
import cccev.core.dsl.CUnitType
import cccev.core.dsl.Code
import cccev.core.dsl.InformationConceptBase
import cccev.core.dsl.InformationConceptId
import features.cccev.test.data.DataTest
import features.cccev.test.data.DummyCode
import java.util.UUID

fun DataTest.informationConcept(
    identifier: InformationConceptId = UUID.randomUUID().toString(),
    name: String = UUID.randomUUID().toString(),
    unit: CUnit = DataTest.cUnit(),
    type: Code = DummyCode,
    description: String = "InfoConcept description",
    expressionOfExpectedValue: String? = null,
    dependsOn: List<InformationConceptId> = emptyList(),
) = InformationConceptBase(
    identifier = identifier,
    name = name,
    unit = unit,
    type = type,
    description = description,
    expressionOfExpectedValue = expressionOfExpectedValue,
    dependsOn = dependsOn
)

fun DataTest.cUnit(
    identifier: String = UUID.randomUUID().toString(),
    name: String = UUID.randomUUID().toString(),
    description: String = "CUnit description",
    notation: String? = null,
    type: CUnitType = CUnitType.string
) = CUnit(
    identifier = identifier,
    name = name,
    description = description,
    notation = notation,
    type = type
)
