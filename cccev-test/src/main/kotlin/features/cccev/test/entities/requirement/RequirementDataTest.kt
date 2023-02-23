package features.cccev.test.entities.requirement

import cccev.dsl.model.Code
import cccev.dsl.model.EvidenceTypeListBase
import cccev.dsl.model.InformationConceptBase
import cccev.dsl.model.InformationConceptId
import cccev.dsl.model.InformationRequirement
import cccev.dsl.model.Requirement
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
