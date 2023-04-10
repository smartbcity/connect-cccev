package cccev.f2.concept.domain.model

import cccev.dsl.model.Code
import cccev.dsl.model.DataUnitDTO
import cccev.dsl.model.InformationConcept
import cccev.dsl.model.InformationConceptId
import cccev.dsl.model.SupportedValue
import cccev.dsl.model.SupportedValueDTO
import cccev.f2.evidence.domain.model.EvidenceTypeListChoicesDTO
import cccev.f2.evidence.domain.model.EvidenceTypeListChoicesDTOBase
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Information Concepts
 * TODO move to request-f2 module?
 */
@JsExport
@JsName("RequestInformationConceptDTO")
interface RequestInformationConceptDTO: InformationConcept {
    /**
     * TODO
     */
    val evidenceTypeChoices: EvidenceTypeListChoicesDTO
    /**
     * TODO
     */
    val supportedValue: SupportedValueDTO
}

class RequestInformationConceptDTOBase(
    override val identifier: String,
    override val name: String,
    override val type: Code?,
    override val unit: DataUnitDTO?,
    override val description: String?,
    override val expressionOfExpectedValue: String?,
    override val dependsOn: List<InformationConceptId>?,
    override val evidenceTypeChoices: EvidenceTypeListChoicesDTOBase,
    override val supportedValue: SupportedValue
): RequestInformationConceptDTO
