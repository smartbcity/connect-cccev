package cccev.s2.concept.domain.command

import cccev.s2.concept.domain.D2InformationConceptPage
import cccev.s2.concept.domain.InformationConceptEvent
import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.concept.domain.InformationConceptInitCommand
import cccev.s2.unit.domain.DataUnitId
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Create a new information concept.
 * @d2 function
 * @parent [D2InformationConceptPage]
 * @order 10
 */
interface InformationConceptCreateFunction

@JsExport
@JsName("InformationConceptCreateCommandDTO")
interface InformationConceptCreateCommandDTO: InformationConceptInitCommand {
    /**
     * The name of the information concept.
     * @example [cccev.s2.concept.domain.model.InformationConcept.name]
     */
    val name: String

    /**
     * The data unit used for the information concept.
     * @example [cccev.s2.concept.domain.model.InformationConcept.unit]
     */
    val unit: DataUnitId

    /**
     * The description of the information concept.
     * @example [cccev.s2.concept.domain.model.InformationConcept.description]
     */
    val description: String

    /**
     * Expression to evaluate in order to auto-compute the SupportedValue associated with the information concept, if applicable. <br />
     * For now, the expression will be evaluated using a Kotlin engine. <br />
     * The expression may contain other known information concepts, identified by their id. They must be declared in the `dependsOn` field.
     * @example [cccev.s2.concept.domain.model.InformationConcept.expressionOfExpectedValue]
     */
    val expressionOfExpectedValue: String?

    /**
     * A list of information concepts the one depends on for auto-computation, if applicable.
     * @example [cccev.s2.concept.domain.model.InformationConcept.dependsOn]
     */
    val dependsOn: List<InformationConceptId>
}

/**
 * @d2 command
 * @parent [InformationConceptCreateFunction]
 */
data class InformationConceptCreateCommand(
    override val name: String,
    override val unit: DataUnitId,
    override val description: String,
    override val expressionOfExpectedValue: String?,
    override val dependsOn: List<InformationConceptId>
): InformationConceptCreateCommandDTO

/**
 * @d2 event
 * @parent [InformationConceptCreateFunction]
 */
@JsExport
@JsName("InformationConceptCreatedEventDTO")
interface InformationConceptCreatedEventDTO: InformationConceptEvent

/**
 * @d2 inherit
 */
data class InformationConceptCreatedEvent(
    /**
     * Identifier of the created information concept.
     */
    override val id: InformationConceptId
): InformationConceptCreatedEventDTO
