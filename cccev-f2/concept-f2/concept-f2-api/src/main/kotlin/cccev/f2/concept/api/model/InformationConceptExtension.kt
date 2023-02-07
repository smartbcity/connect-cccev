package cccev.f2.concept.api.model

import cccev.core.dsl.InformationConceptBase
import cccev.core.dsl.SupportedValue
import cccev.f2.concept.domain.model.InformationConceptDTOBase
import cccev.f2.concept.domain.model.RequestInformationConceptDTOBase
import cccev.f2.evidence.api.model.toEvidenceTypeListChoices
import cccev.f2.evidence.domain.model.EvidenceTypeListDTO
import cccev.f2.unit.domain.model.DataUnitDTOBase
import cccev.s2.concept.domain.model.InformationConcept
import cccev.s2.unit.domain.DataUnitId
import java.util.UUID

// TODO move to request-f2 module?
fun InformationConceptBase.toRequestDTO(
    evidenceTypeLists: List<EvidenceTypeListDTO>,
    supportedValue: SupportedValue?
) = RequestInformationConceptDTOBase(
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

suspend fun InformationConcept.toDTO(
    getUnit: suspend (DataUnitId) -> DataUnitDTOBase
) = InformationConceptDTOBase(
    id = id,
    name = name,
    unit = getUnit(unit),
    description = description,
    expressionOfExpectedValue = expressionOfExpectedValue,
    dependsOn = dependsOn
)
