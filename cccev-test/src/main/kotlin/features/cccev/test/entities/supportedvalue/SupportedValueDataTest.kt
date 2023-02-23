package features.cccev.test.entities.supportedvalue

import cccev.dsl.model.InformationConceptId
import cccev.dsl.model.SupportedValue
import cccev.dsl.model.SupportedValueId
import features.cccev.test.data.DataTest
import java.util.UUID

fun DataTest.supportedValue(
    identifier: SupportedValueId = UUID.randomUUID().toString(),
    value: String? = null,
    query: String? = null,
    providesValueFor: InformationConceptId = UUID.randomUUID().toString()
) = SupportedValue(
    identifier = identifier,
    value = value,
    query = query,
    providesValueFor = providesValueFor
)
