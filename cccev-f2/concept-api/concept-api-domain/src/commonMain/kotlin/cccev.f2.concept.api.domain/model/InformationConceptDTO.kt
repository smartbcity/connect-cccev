package cccev.f2.concept.api.domain.model

import cccev.core.dsl.CUnitDTO
import cccev.core.dsl.Code
import cccev.core.dsl.EvidenceTypeId
import cccev.core.dsl.InformationConcept
import cccev.core.dsl.InformationConceptId
import cccev.core.dsl.SupportedValue
import cccev.core.dsl.SupportedValueDTO
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
@JsName("InformationConceptDTO")
interface InformationConceptDTO: InformationConcept {
    val evidenceTypes: Array<Array<EvidenceTypeId>>
    val supportedValue: SupportedValueDTO
}

class InformationConceptDTOBase(
    override val identifier: String,
    override val name: String,
    override val type: Code,
    override val unit: CUnitDTO,
    override val description: String,
    override val expressionOfExpectedValue: String?,
    override val dependsOn: List<InformationConceptId>,
    override val evidenceTypes: Array<Array<EvidenceTypeId>>,
    override val supportedValue: SupportedValue
): InformationConceptDTO
