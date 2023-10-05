package cccev.f2.evidence.domain.model

import cccev.dsl.model.EvidenceTypeListId
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

/**
 * Represents a OR relation between the EvidenceTypeLists contained in the list
 */
@JsExport
@JsName("EvidenceTypeListChoicesDTO")
interface EvidenceTypeListChoicesDTO {
    val evidenceTypeLists: List<EvidenceTypeListId>
    val isFilled: Boolean
}
@Serializable
class EvidenceTypeListChoicesDTOBase(
    override val evidenceTypeLists: List<EvidenceTypeListId> = emptyList(),
    override val isFilled: Boolean
): EvidenceTypeListChoicesDTO
