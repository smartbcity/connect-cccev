package cccev.f2.concept.domain.model

import cccev.f2.concept.domain.D2InformationConceptF2Page
import cccev.f2.unit.domain.model.DataUnitDTO
import cccev.f2.unit.domain.model.DataUnitDTOBase
import cccev.s2.concept.domain.InformationConceptId
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

/**
 * See [cccev.s2.concept.domain.model.InformationConcept]
 * @d2 model
 * @parent [D2InformationConceptF2Page]
 * @order 10
 */
@JsExport
@JsName("InformationConceptDTO")
interface InformationConceptDTO {
    /**
     * Unique identifier of this information concept.
     */
    val id: InformationConceptId

    /**
     * The name of this information concept.
     * @example [cccev.s2.concept.domain.model.InformationConcept.name]
     */
    val name: String

    /**
     * The data unit used for this information concept.
     */
    val unit: DataUnitDTO

    /**
     * The description of this information concept.
     * @example [cccev.s2.concept.domain.model.InformationConcept.description]
     */
    val description: String

    /**
     * Expression to evaluate in order to auto-compute the SupportedValue associated with this information concept, if applicable. <br />
     * For now, the expression will be evaluated using a Kotlin engine. <br />
     * The expression may contain other known information concepts, identified by their id. They must be declared in the `dependsOn` field.
     * @example [cccev.s2.concept.domain.model.InformationConcept.expressionOfExpectedValue]
     */
    val expressionOfExpectedValue: String?

    /**
     * A list of information concepts this one depends on for auto-computation, if applicable.
     * @example [cccev.s2.concept.domain.model.InformationConcept.dependsOn]
     */
    val dependsOn: List<InformationConceptId>
}

/**
 * @d2 inherit
 */
@Serializable
data class InformationConceptDTOBase(
    override val id: InformationConceptId,
    override val name: String,
    override val unit: DataUnitDTOBase,
    override val description: String,
    override val expressionOfExpectedValue: String?,
    override val dependsOn: List<InformationConceptId>
): InformationConceptDTO
