package cccev.f2.concept.api.domain.model

import ccev.dsl.core.CUnitDTO
import ccev.dsl.core.Code
import ccev.dsl.core.EvidenceTypeId
import ccev.dsl.core.InformationConcept
import ccev.dsl.core.InformationConceptId
import ccev.dsl.core.SupportedValue
import ccev.dsl.core.SupportedValueDTO
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
