package features.cccev.test.entities.evidence

import cccev.dsl.model.Evidence
import cccev.dsl.model.EvidenceId
import cccev.dsl.model.EvidenceTypeId
import cccev.dsl.model.InformationConceptId
import cccev.dsl.model.PeriodOfTime
import cccev.dsl.model.RequirementId
import cccev.dsl.model.SupportedValueId
import features.cccev.test.data.DataTest
import java.util.UUID

fun DataTest.evidence(
    identifier: EvidenceId = UUID.randomUUID().toString(),
    isConformantTo: List<EvidenceTypeId> = emptyList(),
    supportsValue: List<SupportedValueId> = emptyList(),
    supportsConcept: List<InformationConceptId> = emptyList(),
    supportsRequirement: List<RequirementId> = emptyList(),
    validityPeriod: PeriodOfTime? = null,
    name: String = "",
    file: String? = null
) = Evidence(
    identifier = identifier,
    isConformantTo = isConformantTo,
    supportsValue = supportsValue,
    supportsConcept = supportsConcept,
    supportsRequirement = supportsRequirement,
    validityPeriod = validityPeriod,
    name = name,
    file = file
)
