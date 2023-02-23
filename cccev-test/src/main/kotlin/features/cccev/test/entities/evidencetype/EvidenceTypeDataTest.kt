package features.cccev.test.entities.evidencetype

import cccev.dsl.model.Code
import cccev.dsl.model.CoreLocationLocation
import cccev.dsl.model.EvidenceTypeBase
import cccev.dsl.model.EvidenceTypeId
import cccev.dsl.model.PeriodOfTime
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
