package cccev.f2.certification.domain.command

import cccev.s2.certification.domain.command.CertificationAddValuesCommand
import cccev.s2.certification.domain.command.CertificationAddValuesCommandDTO
import cccev.s2.certification.domain.command.CertificationAddedValuesEvent
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Provide data for the information concepts specified in the requirements a certification has to fulfill.
 * @d2 function
 * @parent [cccev.f2.certification.domain.D2CertificationApiPage]
 * @child [cccev.s2.certification.domain.command.CertificationAddValuesCommandDTO]
 * @child [cccev.s2.certification.domain.command.CertificationAddedValuesEventDTO]
 * @order 30
 */
typealias CertificationAddValuesFunction = F2Function<CertificationAddValuesCommand, CertificationAddedValuesEvent>

@JsExport
@JsName("CertificationAddValuesCommandDTO")
interface CertificationAddValuesCommandDTO:
    CertificationAddValuesCommandDTO

@JsExport
@JsName("CertificationAddedValuesEventDTO")
interface CertificationAddedValuesEventDTO: cccev.s2.certification.domain.command.CertificationAddedValuesEventDTO
