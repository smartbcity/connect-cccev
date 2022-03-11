package cccev.f2.evidence.api.domain.model

import cccev.core.dsl.EvidenceTypeListId
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Represents a OR relation between the EvidenceTypeLists contained in the list
 */
@JsExport
@JsName("EvidenceTypeListChoicesDTO")
interface EvidenceTypeListChoicesDTO {
    val evidenceTypeLists: List<EvidenceTypeListId>
    val isFilled: Boolean
}

class EvidenceTypeListChoicesDTOBase(
    override val evidenceTypeLists: List<EvidenceTypeListId>,
    override val isFilled: Boolean
): EvidenceTypeListChoicesDTO
