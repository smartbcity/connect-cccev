package cccev.s2.request.domain.command

import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.request.domain.RequestCommand
import cccev.s2.request.domain.RequestEvent
import cccev.s2.request.domain.model.RequestId
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

/**
 * @d2 command
 */
@JsExport
@JsName("RequestAddValuesCommandDTO")
interface RequestAddValuesCommandDTO: RequestCommand {
    /**
     * Id of the request to add the values to.
     */
    override val id: RequestId

    /**
     * New values for the request, mapped by the [id][cccev.s2.concept.domain.model.InformationConcept.id]
     * of the information concept it provides data for. <br />
     * If a value had already been provided for one of the information concepts, it will be overwritten with the new specified one.
     * @example [cccev.s2.request.domain.model.RequestDTO.supportedValues]
     */
    val values: Map<InformationConceptId, String?>
}

/**
 * @d2 inherit
 */
data class RequestAddValuesCommand(
    override val id: RequestId,
    override val values: Map<InformationConceptId, String?>
): RequestAddValuesCommandDTO

/**
 * @d2 event
 */
@JsExport
@JsName("RequestAddedValuesEventDTO")
interface RequestAddedValuesEventDTO: RequestEvent {
    /**
     * Id of the request the values have been added to.
     */
    override val id: RequestId

    /**
     * @ref [RequestAddValuesCommandDTO.values]
     */
    val values: Map<InformationConceptId, String?>
}

/**
 * @d2 inherit
 */
@Serializable
data class RequestAddedValuesEvent(
    override val id: RequestId,
    override val values: Map<InformationConceptId, String?>
): RequestAddedValuesEventDTO
