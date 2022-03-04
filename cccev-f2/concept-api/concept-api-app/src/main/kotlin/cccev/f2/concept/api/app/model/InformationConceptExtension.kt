package cccev.f2.concept.api.app.model

import cccev.core.dsl.EvidenceTypeId
import cccev.core.dsl.InformationConceptBase
import cccev.core.dsl.SupportedValue
import cccev.f2.concept.api.domain.model.InformationConceptDTOBase
import java.util.UUID

fun InformationConceptBase.toDTO(evidenceTypes: List<List<EvidenceTypeId>>, supportedValue: SupportedValue?) = InformationConceptDTOBase(
    identifier = identifier,
    name = name,
    unit = unit,
    type = type,
    description = description,
    expressionOfExpectedValue = expressionOfExpectedValue,
    dependsOn = dependsOn,
    evidenceTypes = evidenceTypes.map(List<EvidenceTypeId>::toTypedArray).toTypedArray(),
    supportedValue = supportedValue ?: SupportedValue(
        identifier = UUID.randomUUID().toString(),
        providesValueFor = identifier
    )
)
