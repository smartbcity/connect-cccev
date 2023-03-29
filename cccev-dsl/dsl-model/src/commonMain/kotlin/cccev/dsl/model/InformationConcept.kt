package cccev.dsl.model

import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

typealias InformationConceptId = String

@JsExport
@JsName("InformationConcept")
interface InformationConcept {
	val identifier: InformationConceptId
	val name: String
	val unit: DataUnitDTO?
	val type: Code?
	val description: String?
	val expressionOfExpectedValue: String?
	val dependsOn: List<InformationConceptId>?
}
@Serializable
open class InformationConceptBase(
    override val identifier: InformationConceptId,
    override val name: String,
    override val unit: DataUnit?,
    override val type: Code?,
    override val description: String?,
    override val expressionOfExpectedValue: String? = null,
    override val dependsOn: List<InformationConceptId>? = emptyList()
): InformationConcept
