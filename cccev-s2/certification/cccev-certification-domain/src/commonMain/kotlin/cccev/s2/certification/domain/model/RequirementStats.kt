package cccev.s2.certification.domain.model

import cccev.s2.requirement.domain.RequirementId
import kotlinx.serialization.Serializable

/**
 * Computed stats for a given Requirement in the context of a Request
 * @d2 model
 * @parent [cccev.s2.certification.domain.D2CertificationPage]
 * @order 20
 */
interface RequirementStatsDTO {
    /**
     * Id of the requirement
     */
    val id: RequirementId

    /**
     * Percentage of completion of the requirement in the request (from 0 to 100 included).
     * @example 50.0
     */
    val completion: Double
}

@Serializable
data class RequirementStats(
    override val id: RequirementId,
    override val completion: Double
): RequirementStatsDTO
