package cccev.f2.evidence.type.domain.model

import cccev.f2.evidence.type.domain.D2EvidenceTypeF2Page
import cccev.s2.evidence.domain.EvidenceTypeListId
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

/**
 * @d2 model
 * @parent [D2EvidenceTypeF2Page]
 * @order 100
 */
@JsExport
@JsName("EvidenceTypeListDTO")
interface EvidenceTypeListDTO {
    /**
     * Identifier of the evidence type.
     */
    val id: EvidenceTypeListId

    /**
     * Name of the evidence type.
     * @example [cccev.s2.evidence.domain.model.EvidenceTypeList.name]
     */
    val name: String

    /**
     * Description of the evidence type.
     * @example [cccev.s2.evidence.domain.model.EvidenceTypeList.description]
     */
    val description: String

    /**
     * How long (in milliseconds) an evidence of this type is considered as valid after it has been issued, if applicable.
     * @example [cccev.s2.evidence.domain.model.EvidenceTypeList.specifiesEvidenceType]
     */
    val specifiesEvidenceType: List<EvidenceTypeDTO>
}

/**
 * @d2 inherit
 */
@Serializable
data class EvidenceTypeListDTOBase(
    override val id: EvidenceTypeListId,
    override val name: String,
    override val description: String,
    override val specifiesEvidenceType: List<EvidenceTypeDTOBase>
): EvidenceTypeListDTO
