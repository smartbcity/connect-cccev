package cccev.f2.evidence.domain.model

import cccev.dsl.model.Code
import cccev.dsl.model.CoreLocationLocation
import cccev.dsl.model.Evidence
import cccev.dsl.model.EvidenceDTO
import cccev.dsl.model.EvidenceType
import cccev.dsl.model.EvidenceTypeId
import cccev.dsl.model.PeriodOfTime
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
@JsName("EvidenceTypeDTO")
interface EvidenceTypeDTO: EvidenceType {
    val evidence: EvidenceDTO?
}

class EvidenceTypeDTOBase(
    override val identifier: EvidenceTypeId,
    override val name: String,
    override val evidenceTypeClassification: Code,
    override val validityPeriodConstraint: PeriodOfTime?,
    override val issuingPlace: CoreLocationLocation?,
    override val evidence: Evidence?
): EvidenceTypeDTO
