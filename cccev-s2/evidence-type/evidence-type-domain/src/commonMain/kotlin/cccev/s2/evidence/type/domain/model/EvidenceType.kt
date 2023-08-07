package cccev.s2.evidence.type.domain.model

import cccev.s2.evidence.type.domain.D2EvidenceTypePage
import cccev.s2.evidence.type.domain.EvidenceTypeId
import cccev.s2.evidence.type.domain.EvidenceTypeIdentifier
import kotlinx.serialization.Serializable

/**
 * @d2 model
 * @parent [D2EvidenceTypePage]
 * @order 10
 */
@Serializable
data class EvidenceType(
    /**
     * Id of the evidence type.
     */
    val id: EvidenceTypeId,

    /**
     * Identifier of the evidence type.
     */
    val identifier: EvidenceTypeIdentifier,

    /**
     * Name of the evidence type.
     * @example "Weather report"
     */
    val name: String,

    /**
     * Description of the evidence type.
     * @example "Detailed report of various weather measurements"
     */
    val description: String,

    /**
     * How long (in milliseconds) an evidence of this type is considered as valid after it has been issued, if applicable.
     * @example null
     */
    val validityPeriodConstraint: Long? = null,
)
