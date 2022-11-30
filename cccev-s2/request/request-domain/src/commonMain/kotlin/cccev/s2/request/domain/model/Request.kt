package cccev.s2.request.domain.model

import cccev.core.dsl.Evidence
import cccev.core.dsl.EvidenceDTO
import cccev.core.dsl.InformationConceptId
import cccev.core.dsl.RequirementId
import cccev.core.dsl.SupportedValue
import cccev.core.dsl.SupportedValueDTO
import cccev.s2.request.domain.RequestState
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * The unique id of the request.
 * @visual json "822cade3-84ec-4798-a899-53877dcf7ef2"
 * @d2 model
 */
typealias RequestId = String


/**
 * The request to gather data
 * @parent [cccev.core.dsl.D2DslPage]
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
data class Request(
	override val id: RequestId,
	override var status: RequestState,
	override val frameworkId: RequirementId,
	override val evidences: List<Evidence>,
	override val supportedValues: Map<InformationConceptId, SupportedValue>,
): RequestDTO
