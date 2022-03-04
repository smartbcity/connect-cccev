package features.cccev.test.entities.evidence

import cccev.core.dsl.Evidence
import cccev.core.dsl.EvidenceId
import cccev.core.dsl.EvidenceTypeId
import cccev.core.dsl.InformationConceptId
import cccev.core.dsl.PeriodOfTime
import cccev.core.dsl.RequirementId
import cccev.core.dsl.SupportedValueId
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
