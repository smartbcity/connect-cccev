package cccev.s2.request.domain.model

import cccev.dsl.model.Evidence
import cccev.dsl.model.EvidenceDTO
import cccev.dsl.model.EvidenceType
import cccev.dsl.model.InformationConceptId
import cccev.dsl.model.RequirementId
import cccev.dsl.model.SupportedValue
import cccev.dsl.model.SupportedValueDTO
import cccev.s2.request.domain.RequestState
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

/**
 * The unique id of the request.
 * @visual json "822cade3-84ec-4798-a899-53877dcf7ef2"
 * @d2 model
 */
typealias RequestId = String


/**
 * The request to gather data
 * @parent [cccev.f2.request.domain.features.D2RequestApiPage]
 * @d2 model
 */
@JsExport
@JsName("RequestDTO")
interface RequestDTO {
	val id: RequestId
	var status: RequestState
	val frameworkId: RequirementId
	val evidences: List<EvidenceDTO>
	val supportedValues: Map<InformationConceptId, SupportedValueDTO>
}

/**
 * @d2 inherit
 */
@Serializable
data class Request(
    override val id: RequestId,
    override var status: RequestState,
    override val frameworkId: RequirementId,
    override val evidences: List<Evidence>,
    override val supportedValues: Map<InformationConceptId, SupportedValue>,
): RequestDTO
