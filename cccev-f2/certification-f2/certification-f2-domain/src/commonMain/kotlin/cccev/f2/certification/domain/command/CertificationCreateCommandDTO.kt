package cccev.f2.certification.domain.command

import cccev.s2.certification.domain.command.CertificationCreateCommand
import cccev.s2.certification.domain.command.CertificationCreatedEvent
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Create a request.
 * @d2 function
 * @parent [cccev.f2.certification.domain.D2CertificationApiPage]
 * @child [cccev.s2.certification.domain.command.CertificationCreateCommandDTO]
 * @child [cccev.s2.certification.domain.command.CertificationCreatedEventDTO]
 * @order 10
 */
typealias CertificationCreateFunction = F2Function<CertificationCreateCommand, CertificationCreatedEvent>

@JsExport
@JsName("RequestCreateCommandDTO")
interface CertificationCreateCommandDTO:
    cccev.s2.certification.domain.command.CertificationCreateCommandDTO

@JsExport
@JsName("RequestCreatedEventDTO")
interface CertificationCreatedEventDTO: cccev.s2.certification.domain.command.CertificationCreatedEventDTO
