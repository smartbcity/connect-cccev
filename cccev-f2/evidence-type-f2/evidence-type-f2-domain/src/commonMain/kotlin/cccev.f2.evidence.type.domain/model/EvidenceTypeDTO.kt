package cccev.f2.evidence.type.domain.model

import cccev.f2.evidence.type.domain.D2EvidenceTypeF2Page
import cccev.s2.evidence.domain.EvidenceTypeId
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

/**
 * @d2 model
 * @parent [D2EvidenceTypeF2Page]
 * @order 10
 */
@JsExport
@JsName("EvidenceTypeDTO")
interface EvidenceTypeDTO {
    /**
     * Identifier of the evidence type.
     */
    val id: EvidenceTypeId

    /**
     * Name of the evidence type.
     * @example [cccev.s2.evidence.domain.model.EvidenceType.name]
     */
    val name: String

    /**
     * Description of the evidence type.
     * @example [cccev.s2.evidence.domain.model.EvidenceType.description]
     */
    val description: String

    /**
     * How long (in milliseconds) an evidence of this type is considered as valid after it has been issued, if applicable.
     * @example [cccev.s2.evidence.domain.model.EvidenceType.validityPeriodConstraint]
     */
    val validityPeriodConstraint: Long?
}

/**
 * @d2 inherit
 */
@Serializable
data class EvidenceTypeDTOBase(
    override val id: EvidenceTypeId,
    override val name: String,
    override val description: String,
    override val validityPeriodConstraint: Long? = null
): EvidenceTypeDTO
