package cccev.f2.certification.domain.command

import cccev.s2.certification.domain.command.CertificationAddedEvidenceEvent
import cccev.s2.certification.domain.model.CertificationId
import cccev.s2.concept.domain.InformationConceptId
import cccev.s2.evidence.domain.EvidenceTypeId
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Add an evidence to a certification.
 * @d2 function
 * @parent [cccev.f2.certification.domain.D2CertificationApiPage]
 * @child [CertificationAddEvidenceCommandDTO]
 * @child [cccev.s2.certification.domain.command.CertificationAddedEvidenceEventDTO]
 * @order 40
 */
typealias CertificationAddEvidenceFunction
        = F2Function<Pair<CertificationAddEvidenceCommandDTOBase, ByteArray>, CertificationAddedEvidenceEvent>

/**
 * @d2 command
 */
@JsExport
@JsName("CertificationAddEvidenceCommandDTO")
interface CertificationAddEvidenceCommandDTO {
    /**
     * Id of the certification to add the evidence to.
     */
    val id: CertificationId

    /**
     * @ref [cccev.s2.certification.domain.model.EvidenceDTO.name]
     */
    val name: String

    /**
     * @ref [cccev.s2.certification.domain.model.EvidenceDTO.url]
     */
    val url: String?

    /**
     * @ref [cccev.s2.certification.domain.model.EvidenceDTO.isConformantTo]
     */
    val isConformantTo: List<EvidenceTypeId>

    /**
     * @ref [cccev.s2.certification.domain.model.EvidenceDTO.supportsConcept]
     */
    val supportsConcept: List<InformationConceptId>

    /**
     * Metadata of the evidence's file.
     */
    val metadata: Map<String, String>?
}

/**
 * @d2 inherit
 */
data class CertificationAddEvidenceCommandDTOBase(
    override val id: CertificationId,
    override val name: String,
    override val url: String?,
    override val isConformantTo: List<EvidenceTypeId>,
    override val supportsConcept: List<InformationConceptId>,
    override val metadata: Map<String, String>?
): CertificationAddEvidenceCommandDTO

@JsExport
@JsName("CertificationAddedEvidenceEventDTO")
interface CertificationAddedEvidenceEventDTO: cccev.s2.certification.domain.command.CertificationAddedEvidenceEventDTO
