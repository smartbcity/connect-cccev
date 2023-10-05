package cccev.f2.evidence.domain.model

import cccev.dsl.model.EvidenceTypeList
import cccev.dsl.model.EvidenceTypeListId
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

@JsExport
@JsName("EvidenceTypeListDTO")
interface EvidenceTypeListDTO: EvidenceTypeList {
    override val specifiesEvidenceType: List<EvidenceTypeDTO>
}

@Serializable
class EvidenceTypeListDTOBase(
    override val description: String,
    override val identifier: EvidenceTypeListId,
    override val name: String,
    override val specifiesEvidenceType: List<EvidenceTypeDTOBase>
): EvidenceTypeListDTO
