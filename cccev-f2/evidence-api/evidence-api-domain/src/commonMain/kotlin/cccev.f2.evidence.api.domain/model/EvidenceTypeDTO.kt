package cccev.f2.evidence.api.domain.model

import cccev.core.dsl.Code
import cccev.core.dsl.CoreLocationLocation
import cccev.core.dsl.Evidence
import cccev.core.dsl.EvidenceDTO
import cccev.core.dsl.EvidenceType
import cccev.core.dsl.EvidenceTypeId
import cccev.core.dsl.PeriodOfTime
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
