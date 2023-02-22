package cccev.core.dsl

import kotlin.js.JsExport
import kotlin.js.JsName

typealias InformationConceptId = String

@JsExport
@JsName("InformationConcept")
interface InformationConcept {
	val identifier: InformationConceptId
	val name: String
	val unit: CUnitDTO
	val type: Code
	val description: String
	val expressionOfExpectedValue: String?
	val dependsOn: List<InformationConceptId>
}

open class InformationConceptBase(
	override val identifier: InformationConceptId,
	override val name: String,
	override val unit: CUnit,
	override val type: Code,
	override val description: String,
	override val expressionOfExpectedValue: String? = null,
	override val dependsOn: List<InformationConceptId> = emptyList()
): InformationConcept
