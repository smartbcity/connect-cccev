package cccev.s2.certification.domain.command

import cccev.s2.certification.domain.CertificationCommand
import cccev.s2.certification.domain.CertificationEvent
import cccev.s2.certification.domain.model.CertificationId
import cccev.s2.certification.domain.model.EvidenceId
import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.evidence.type.domain.EvidenceTypeId
import city.smartb.fs.s2.file.domain.model.FilePath
import city.smartb.fs.s2.file.domain.model.FilePathDTO
import kotlinx.serialization.Serializable
import kotlin.js.JsExport
import kotlin.js.JsName

@Serializable
data class CertificationAddEvidenceCommand(
    override val id: CertificationId,
    val name: String,
    val file: FilePath? = null,
    val url: String? = null,
    val isConformantTo: List<EvidenceTypeId> = emptyList(),
    val supportsConcept: List<InformationConceptId> = emptyList()
): CertificationCommand

/**
 * @d2 event
 */
@JsExport
@JsName("CertificationAddedEvidenceEventDTO")
interface CertificationAddedEvidenceEventDTO: CertificationEvent {
    /**
     * Id of the certification the evidence has been added to.
     */
    override val id: CertificationId

    /**
     * Id of the newly created evidence.
     */
    val evidenceId: EvidenceId

    /**
     * @ref [cccev.s2.certification.domain.model.EvidenceDTO.name]
     */
    val name: String

    /**
     * @ref [cccev.s2.certification.domain.model.EvidenceDTO.file]
     */
    val file: FilePathDTO?

    /**
     * @ref [cccev.s2.certification.domain.model.EvidenceDTO.url]
     */
    val url: String?

    /**
     * @ref [cccev.s2.certification.domain.model.EvidenceDTO.isConformantTo]
     */
    val isConformantTo: List<EvidenceTypeId>

    /**
     * @ref [cccev.s2.certification.domain.model.EvidenceDTO.supportsConcept]
     */
    val supportsConcept: List<InformationConceptId>
}

/**
 * @d2 inherit
 */
@Serializable
data class CertificationAddedEvidenceEvent(
    override val id: CertificationId,
    override val evidenceId: EvidenceId,
    override val name: String,
    override val file: FilePath? = null,
    override val url: String? = null,
    override val isConformantTo: List<EvidenceTypeId> = emptyList(),
    override val supportsConcept: List<InformationConceptId> = emptyList()
): CertificationAddedEvidenceEventDTO
