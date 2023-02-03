package cccev.f2.evidence.domain.model

import cccev.core.dsl.EvidenceTypeList
import cccev.core.dsl.EvidenceTypeListId
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
@JsName("EvidenceTypeListDTO")
interface EvidenceTypeListDTO: EvidenceTypeList {
    override val specifiesEvidenceType: List<EvidenceTypeDTO>
}

class EvidenceTypeListDTOBase(
    override val description: String,
    override val identifier: EvidenceTypeListId,
    override val name: String,
    override val specifiesEvidenceType: List<EvidenceTypeDTOBase>
): EvidenceTypeListDTO
