package cccev.f2.certification.domain.command

import cccev.s2.certification.domain.command.CertificationRemoveRequirementsCommand
import cccev.s2.certification.domain.command.CertificationRemovedRequirementsEvent
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Remove requirements to fulfill from a request.
 * @d2 function
 * @parent [cccev.f2.certification.domain.D2CertificationApiPage]
 * @child [cccev.s2.certification.domain.command.CertificationRemoveRequirementsCommandDTO]
 * @child [cccev.s2.certification.domain.command.CertificationRemovedRequirementsEventDTO]
 * @order 21
 */
typealias CertificationRemoveRequirementsFunction
        = F2Function<CertificationRemoveRequirementsCommand, CertificationRemovedRequirementsEvent>

@JsExport
@JsName("RequestRemoveRequirementsCommandDTO")
interface CertificationRemoveRequirementsCommandDTO: cccev.s2.certification.domain.command.CertificationRemoveRequirementsCommandDTO

@JsExport
@JsName("RequestRemovedRequirementsEventDTO")
interface CertificationRemovedRequirementsEventDTO: cccev.s2.certification.domain.command.CertificationRemovedRequirementsEventDTO
