package cccev.s2.evidence.domain.model

import cccev.s2.evidence.domain.D2EvidenceTypePage
import cccev.s2.evidence.domain.EvidenceTypeListId

/**
 * @d2 model
 * @parent [D2EvidenceTypePage]
 * @order 100
 */
data class EvidenceTypeList(
    /**
     * Identifier of the evidence type.
     */
    val id: EvidenceTypeListId,

    /**
     * Name of the evidence type.
     * @example ""
     */
    val name: String,

    /**
     * Description of the evidence type.
     * @example ""
     */
    val description: String,

    /**
     *
     */
    val specifiesEvidenceType: List<EvidenceType>
)
