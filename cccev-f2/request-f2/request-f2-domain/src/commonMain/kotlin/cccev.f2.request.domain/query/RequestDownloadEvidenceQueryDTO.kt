package cccev.f2.request.domain.query

import cccev.s2.request.domain.model.EvidenceId
import cccev.s2.request.domain.model.RequestId
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Download a given evidence of a given request
 * @d2 function
 */
interface RequestDownloadEvidenceFunction

/**
 * @d2 query
 * @parent [RequestDownloadEvidenceFunction]
 */
@JsExport
@JsName("RequestDownloadEvidenceQueryDTO")
interface RequestDownloadEvidenceQueryDTO {
    val id: RequestId
    val evidenceId: EvidenceId
}

data class RequestDownloadEvidenceQueryDTOBase(
    override val id: RequestId,
    override val evidenceId: EvidenceId
): RequestDownloadEvidenceQueryDTO
