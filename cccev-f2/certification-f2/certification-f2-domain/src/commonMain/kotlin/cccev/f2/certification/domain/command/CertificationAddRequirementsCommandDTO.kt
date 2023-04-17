package cccev.f2.certification.domain.command

import cccev.s2.certification.domain.command.CertificationAddRequirementsCommand
import cccev.s2.certification.domain.command.CertificationAddRequirementsCommandDTO
import cccev.s2.certification.domain.command.CertificationAddedRequirementsEvent
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Add requirements to fulfill in a certification.
 * @d2 function
 * @parent [cccev.f2.certification.domain.D2CertificationApiPage]
 * @child [cccev.s2.certification.domain.command.CertificationAddRequirementsCommandDTO]
 * @child [cccev.s2.certification.domain.command.CertificationAddedRequirementsEventDTO]
 * @order 20
 */
typealias CertificationAddRequirementsFunction = F2Function<CertificationAddRequirementsCommand, CertificationAddedRequirementsEvent>

@JsExport
@JsName("CertificationAddRequirementsCommandDTO")
interface CertificationAddRequirementsCommandDTO:
    CertificationAddRequirementsCommandDTO

@JsExport
@JsName("CertificationAddedRequirementsEventDTO")
interface CertificationAddedRequirementsEventDTO: cccev.s2.certification.domain.command.CertificationAddedRequirementsEventDTO
