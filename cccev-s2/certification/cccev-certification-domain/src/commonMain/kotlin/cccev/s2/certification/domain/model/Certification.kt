package cccev.s2.certification.domain.model

import cccev.dsl.model.RequirementId
import cccev.s2.concept.domain.InformationConceptId
import kotlinx.serialization.Serializable
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * @visual json "822cade3-84ec-4798-a899-53877dcf7ef2"
 * @d2 hidden
 */
typealias CertificationId = String

/**
 * @visual json "C3P0"
 * @d2 hidden
 */
typealias CertificationIdentifier = String

/**
 * @d2 model
 * @parent [cccev.s2.certification.domain.D2CertificationPage]
 * @order 10
 */
@JsExport
@JsName("CertificationDTO")
interface CertificationDTO {
    /**
     * Unique identifier of the request.
     */
    val id: CertificationId

    /**
     * Custom identifier of the request.
     */
    val identifier: CertificationIdentifier

    /**
     * Name of the request.
     * @example "VeryFunActivity"
     */
    val name: String

    /**
     * Description of the request.
     * @example "This is fun."
     */
    val description: String?

    /**
     * Start date of the request, if relevant, formatted as UNIX timestamp in milliseconds.
     * @example 1679415708000
     */
    val startDate: Long?

    /**
     * End date of the request, if relevant, formatted as UNIX timestamp in milliseconds.
     * @example 1687364508000
     */
    val endDate: Long?

    /**
     * Estimated end date of the request, formatted as UNIX timestamp in milliseconds.
     */
    val estimatedEndDate: Long?

    /**
     * Identifier of the creator of the request.
     * @example "c525b81f-fa7b-4fb7-ad62-1007038a8bc2"
     */
    val creator: String?

    /**
     * Identifier of the executor of the request.
     * @example "dbbc7434-ffe4-415a-b314-4962a2a432f6"
     */
    val executor: String?

    /**
     * Identifier of the validator of the request.
     * @example "c12840d9-025f-4403-89fd-00ed182ad708"
     */
    val validator: String?

    /**
     * Specifies if the request is accessible to the public or not.
     * @example true
     */
    val isPublic: Boolean

    /**
     * Specifies if the request validates issuance of credits.
     * @example false
     */
    val issuable: Boolean

    /**
     * Specifies if the request needs verification.
     * @example true
     */
    val verifiable: Boolean

    /**
     * Identifier of the verifier of the request.
     * @example "ecafe595-ed69-4e70-963a-34851ac019e8"
     */
    val verifier: String?

    /**
     * Date at which the request as been verified, formatted as UNIX timestamp in milliseconds.
     */
    val verificationDate: Long?

    /**
     * List of requirements that must be fulfilled by this request.
     */
    val requirements: List<RequirementId>

    /**
     * List of all the evidences provided for this request, mapped by InformationConcept.
     */
    val evidences: Map<InformationConceptId, List<EvidenceDTO>>

    /**
     * List of data provided for this request, mapped by InformationConcept.
     * @example { "59950d76-c39e-4566-834e-fe14356622c9": "a very peculiar thing" }
     */
    val supportedValues: Map<InformationConceptId, String?>

    /**
     * Fulfillment stats of the requirements in the context of the request
     * @example { "082f9b5b-4ffa-4e95-8288-2de2972cade5": { id: "082f9b5b-4ffa-4e95-8288-2de2972cade5", completion: 50.0 } }
     */
    val requirementStats: Map<RequirementId, RequirementStatsDTO>
}

/**
 * @d2 inherit
 */
@Serializable
data class Certification(
    override val id: CertificationId,
    override val identifier: CertificationIdentifier,
    override val name: String,
    override val description: String? = null,
    override val startDate: Long? = null,
    override val endDate: Long? = null,
    override val estimatedEndDate: Long? = null,
    override val creator: String? = null,
    override val executor: String? = null,
    override val validator: String? = null,
    override val isPublic: Boolean,
    override val issuable: Boolean,
    override val verifiable: Boolean,
    override val verifier: String? = null,
    override val verificationDate: Long? = null,
    override val requirements: List<RequirementId> = emptyList(),
    override val evidences: Map<InformationConceptId, List<Evidence>> = emptyMap(),
    override val supportedValues: Map<InformationConceptId, String?> = emptyMap(),
    override val requirementStats: Map<RequirementId, RequirementStats> = emptyMap()
): CertificationDTO
