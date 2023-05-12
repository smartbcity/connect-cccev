package cccev.s2.certification.domain.command

import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.certification.domain.CertificationCommand
import cccev.s2.certification.domain.CertificationEvent
import cccev.s2.certification.domain.model.CertificationId
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

/**
 * @d2 command
 */
@JsExport
@JsName("CertificationAddValuesCommandDTO")
interface CertificationAddValuesCommandDTO: CertificationCommand {
    /**
     * Id of the certification to add the values to.
     */
    override val id: CertificationId

    /**
     * New values for the certification, mapped by the [id][cccev.s2.concept.domain.model.InformationConcept.id]
     * of the information concept it provides data for. <br />
     * If a value had already been provided for one of the information concepts, it will be overwritten with the new specified one.
     * @example [cccev.s2.certification.domain.model.CertificationDTO.supportedValues]
     */
    val values: Map<InformationConceptId, String?>
}

/**
 * @d2 inherit
 */
@Serializable
data class CertificationAddValuesCommand(
    override val id: CertificationId,
    override val values: Map<InformationConceptId, String?> = emptyMap()
): CertificationAddValuesCommandDTO

/**
 * @d2 event
 */
@JsExport
@JsName("CertificationAddedValuesEventDTO")
interface CertificationAddedValuesEventDTO: CertificationEvent {
    /**
     * Id of the certification the values have been added to.
     */
    override val id: CertificationId

    /**
     * @ref [CertificationAddValuesCommandDTO.values]
     */
    val values: Map<InformationConceptId, String?>
}

/**
 * @d2 inherit
 */
@Serializable
data class CertificationAddedValuesEvent(
    override val id: CertificationId,
    override val values: Map<InformationConceptId, String?> = emptyMap()
): CertificationAddedValuesEventDTO
