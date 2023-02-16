package cccev.f2.concept.domain.model

import cccev.core.dsl.CUnitDTO
import cccev.core.dsl.Code
import cccev.core.dsl.InformationConcept
import cccev.core.dsl.InformationConceptId
import cccev.core.dsl.SupportedValue
import cccev.core.dsl.SupportedValueDTO
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
    override val type: Code,
    override val unit: CUnitDTO,
    override val description: String,
    override val expressionOfExpectedValue: String?,
    override val dependsOn: List<InformationConceptId>,
    override val evidenceTypeChoices: EvidenceTypeListChoicesDTOBase,
    override val supportedValue: SupportedValue
): RequestInformationConceptDTO
