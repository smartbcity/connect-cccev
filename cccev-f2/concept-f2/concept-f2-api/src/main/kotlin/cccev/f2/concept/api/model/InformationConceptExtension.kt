package cccev.f2.concept.api.model

import cccev.core.dsl.InformationConceptBase
import cccev.core.dsl.SupportedValue
import cccev.f2.concept.domain.model.InformationConceptDTOBase
import cccev.f2.evidence.api.model.toEvidenceTypeListChoices
import cccev.f2.evidence.domain.model.EvidenceTypeListDTO
import java.util.UUID

fun InformationConceptBase.toDTO(evidenceTypeLists: List<EvidenceTypeListDTO>, supportedValue: SupportedValue?) = InformationConceptDTOBase(
    identifier = identifier,
    name = name,
    unit = unit,
    type = type,
    description = description,
    expressionOfExpectedValue = expressionOfExpectedValue,
    dependsOn = dependsOn,
    evidenceTypeChoices = evidenceTypeLists.toEvidenceTypeListChoices(),
    supportedValue = supportedValue ?: SupportedValue(
        identifier = UUID.randomUUID().toString(),
        providesValueFor = identifier
    )
)
