package cccev.s2.request.domain.model

import kotlin.js.JsName

typealias RequestId = String

@JsExport
@JsName("RequestDTO")
interface RequestDTO {
	val id: RequestId
	var status: RequestState
	val frameworkId: RequirementId
	val evidences: List<EvidenceDTO>
	val supportedValues: Map<InformationConceptId, SupportedValueDTO>
}

data class Request(
	override val id: RequestId,
	override var status: RequestState,
	override val frameworkId: RequirementId,
	override val evidences: List<Evidence>,
	override val supportedValues: Map<InformationConceptId, SupportedValue>,
): RequestDTO
