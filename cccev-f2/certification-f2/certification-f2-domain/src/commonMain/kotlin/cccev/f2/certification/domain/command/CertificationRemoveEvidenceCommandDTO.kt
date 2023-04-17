package cccev.f2.certification.domain.command

import cccev.s2.certification.domain.command.CertificationRemoveEvidenceCommand
import cccev.s2.certification.domain.command.CertificationRemovedEvidenceEvent
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Remove an evidence from a request.
 * @d2 function
 * @parent [cccev.f2.certification.domain.D2CertificationApiPage]
 * @child [cccev.s2.certification.domain.command.CertificationRemoveEvidenceCommandDTO]
 * @child [cccev.s2.certification.domain.command.CertificationRemovedEvidenceEventDTO]
 * @order 41
 */
typealias CertificationRemoveEvidenceFunction = F2Function<CertificationRemoveEvidenceCommand, CertificationRemovedEvidenceEvent>

@JsExport
@JsName("RequestRemoveEvidenceCommandDTO")
interface CertificationRemoveEvidenceCommandDTO:
    cccev.s2.certification.domain.command.CertificationRemoveEvidenceCommandDTO

@JsExport
@JsName("RequestRemovedEvidenceEventDTO")
interface CertificationRemovedEvidenceEventDTO: cccev.s2.certification.domain.command.CertificationRemovedEvidenceEventDTO
