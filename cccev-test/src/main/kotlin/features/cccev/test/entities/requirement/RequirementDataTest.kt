package features.cccev.test.entities.requirement

import cccev.core.dsl.Code
import cccev.core.dsl.EvidenceTypeListBase
import cccev.core.dsl.InformationConceptBase
import cccev.core.dsl.InformationConceptId
import cccev.core.dsl.InformationRequirement
import cccev.core.dsl.Requirement
import features.cccev.test.data.DataTest
import features.cccev.test.data.DummyCode
import java.util.UUID

fun DataTest.informationRequirement(
    identifier: InformationConceptId = UUID.randomUUID().toString(),
    name: String = UUID.randomUUID().toString(),
    type: Code = DummyCode,
    description: String = "InfoRequirement description",
    hasConcept: List<InformationConceptBase> = emptyList(),
    hasRequirement: List<Requirement> = emptyList(),
    hasEvidenceTypeList: List<EvidenceTypeListBase> = emptyList(),
) = InformationRequirement(
    identifier = identifier,
    name = name,
    type = type,
    description = description,
    hasConcept = hasConcept,
    hasRequirement = hasRequirement,
    hasEvidenceTypeList = hasEvidenceTypeList
)
