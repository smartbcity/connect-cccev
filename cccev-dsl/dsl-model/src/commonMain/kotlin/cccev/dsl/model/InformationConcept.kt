package cccev.dsl.model

import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

typealias InformationConceptId = String
typealias InformationConceptIdentifier = String

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
    override val identifier: InformationConceptIdentifier,
    override val name: String,
    override val unit: DataUnit? = null,
    override val type: Code? = null,
    override val description: String? = null,
    override val expressionOfExpectedValue: String? = null,
    override val dependsOn: List<InformationConceptId>? = emptyList()
): InformationConcept
