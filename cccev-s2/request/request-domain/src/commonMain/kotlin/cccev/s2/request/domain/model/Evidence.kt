package cccev.s2.request.domain.model

import cccev.s2.evidence.domain.EvidenceTypeId
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * @d2 hidden
 * @visual json "61003570-643b-41db-baf8-b48f4d170b5b"
 */
typealias EvidenceId = String

@JsExport
@JsName("EvidenceDTO")
interface EvidenceDTO {
    /**
     * Id of the evidence.
     */
    val id: EvidenceId

    /**
     * Name of the evidence.
     * @example "ID card"
     */
    val name: String

    /**
     * Path to a file serving as evidence.
     * @example "/document/id_card.png"
     */
    val file: String?

    /**
     * Ids of the evidence types this evidence can be used as.
     */
    val isConformantTo: List<EvidenceTypeId>
}

data class Evidence(
    override val id: EvidenceId,
    override val name: String,
    override val file: String?,
    override val isConformantTo: List<EvidenceTypeId>
): EvidenceDTO
