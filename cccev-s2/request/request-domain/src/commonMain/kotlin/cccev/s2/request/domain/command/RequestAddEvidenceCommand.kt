package cccev.s2.request.domain.command

import cccev.s2.evidence.domain.EvidenceTypeId
import cccev.s2.request.domain.RequestCommand
import cccev.s2.request.domain.RequestEvent
import cccev.s2.request.domain.model.EvidenceId
import cccev.s2.request.domain.model.RequestId
import city.smartb.fs.s2.file.domain.model.FilePath
import city.smartb.fs.s2.file.domain.model.FilePathDTO
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

data class RequestAddEvidenceCommand(
    override val id: RequestId,
    val name: String,
    val file: FilePath?,
    val url: String?,
    val isConformantTo: List<EvidenceTypeId>
): RequestCommand

/**
 * @d2 event
 */
@JsExport
@JsName("RequestAddedEvidenceEventDTO")
interface RequestAddedEvidenceEventDTO: RequestEvent {
    /**
     * Id of the request the evidence has been added to.
     */
    override val id: RequestId

    /**
     * Id of the newly created evidence.
     */
    val evidenceId: EvidenceId

    /**
     * @ref [cccev.s2.request.domain.model.EvidenceDTO.name]
     */
    val name: String

    /**
     * @ref [cccev.s2.request.domain.model.EvidenceDTO.file]
     */
    val file: FilePathDTO?

    /**
     * @ref [cccev.s2.request.domain.model.EvidenceDTO.url]
     */
    val url: String?

    /**
     * @ref [cccev.s2.request.domain.model.EvidenceDTO.isConformantTo]
     */
    val isConformantTo: List<EvidenceTypeId>
}

/**
 * @d2 inherit
 */
@Serializable
data class RequestAddedEvidenceEvent(
    override val id: RequestId,
    override val evidenceId: EvidenceId,
    override val name: String,
    override val file: FilePath?,
    override val url: String?,
    override val isConformantTo: List<EvidenceTypeId>
): RequestAddedEvidenceEventDTO
