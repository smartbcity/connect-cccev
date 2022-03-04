package features.cccev.test.entities.evidencetype

import cccev.core.dsl.Code
import cccev.core.dsl.CoreLocationLocation
import cccev.core.dsl.EvidenceTypeBase
import cccev.core.dsl.EvidenceTypeId
import cccev.core.dsl.PeriodOfTime
import features.cccev.test.data.DataTest
import features.cccev.test.data.DummyCode
import java.util.UUID

fun DataTest.evidenceType(
    identifier: EvidenceTypeId = UUID.randomUUID().toString(),
    name: String = UUID.randomUUID().toString(),
    evidenceTypeClassification: Code = DummyCode,
    validityPeriodConstraint: PeriodOfTime? = null,
    issuingPlace: CoreLocationLocation? = null,
) = EvidenceTypeBase(
    identifier = identifier,
    name = name,
    evidenceTypeClassification = evidenceTypeClassification,
    validityPeriodConstraint = validityPeriodConstraint,
    issuingPlace = issuingPlace
)
