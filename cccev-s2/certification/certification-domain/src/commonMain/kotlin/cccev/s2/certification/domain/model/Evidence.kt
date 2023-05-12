package cccev.s2.certification.domain.model

import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.evidence.domain.EvidenceTypeId
import city.smartb.fs.s2.file.domain.model.FilePath
import city.smartb.fs.s2.file.domain.model.FilePathDTO
import kotlinx.serialization.Serializable
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
    val file: FilePathDTO?

    /**
     * Url pointing to any data serving as evidence.
     * @example null
     */
    val url: String?

    /**
     * Ids of the evidence types this evidence can be used as.
     */
    val isConformantTo: List<EvidenceTypeId>

    /**
     * Ids of the concepts for which the evidence supports a value
     */
    val supportsConcept: List<InformationConceptId>
}

@Serializable
data class Evidence(
    override val id: EvidenceId,
    override val name: String,
    override val file: FilePath? = null,
    override val url: String? = null,
    override val isConformantTo: List<EvidenceTypeId> = emptyList(),
    override val supportsConcept: List<InformationConceptId> = emptyList()
): EvidenceDTO
