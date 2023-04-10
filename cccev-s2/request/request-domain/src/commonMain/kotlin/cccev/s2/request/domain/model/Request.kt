package cccev.s2.request.domain.model

import cccev.dsl.model.RequirementId
import cccev.s2.concept.domain.InformationConceptId
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

/**
 * @visual json "822cade3-84ec-4798-a899-53877dcf7ef2"
 * @d2 hidden
 */
typealias RequestId = String

/**
 * @d2 model
 * @parent [cccev.s2.request.domain.D2RequestPage]
 * @order 10
 */
@JsExport
@JsName("RequestDTO")
interface RequestDTO {
    /**
     * Unique identifier of the request.
     */
    val id: RequestId

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
     * List of all the evidences provided for this request.
     */
    val evidences: List<EvidenceDTO>

    /**
     * List of data provided for this request.
     * @example { "59950d76-c39e-4566-834e-fe14356622c9": "a very peculiar thing" }
     */
    val supportedValues: Map<InformationConceptId, String?>
}

/**
 * @d2 inherit
 */
@Serializable
data class Request(
    override val id: RequestId,
    override val name: String,
    override val description: String?,
    override val startDate: Long?,
    override val endDate: Long?,
    override val estimatedEndDate: Long?,
    override val creator: String?,
    override val executor: String?,
    override val validator: String?,
    override val isPublic: Boolean,
    override val issuable: Boolean,
    override val verifiable: Boolean,
    override val verifier: String?,
    override val verificationDate: Long?,
    override val requirements: List<RequirementId>,
    override val evidences: List<Evidence>,
    override val supportedValues: Map<InformationConceptId, String?>,
): RequestDTO
