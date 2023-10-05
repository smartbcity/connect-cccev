package cccev.f2.evidence.type.domain.command.type

import cccev.f2.evidence.type.domain.D2EvidenceTypeF2Page
import cccev.s2.evidence.type.domain.command.type.EvidenceTypeCreateCommand
import cccev.s2.evidence.type.domain.command.type.EvidenceTypeCreateCommandDTO
import cccev.s2.evidence.type.domain.command.type.EvidenceTypeCreatedEvent
import cccev.s2.evidence.type.domain.command.type.EvidenceTypeCreatedEventDTO
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Create an evidence type
 * @d2 function
 * @parent [D2EvidenceTypeF2Page]
 */
typealias EvidenceTypeCreateFunction = F2Function<EvidenceTypeCreateCommand, EvidenceTypeCreatedEvent>

/**
 * @d2 command
 * @parent [EvidenceTypeCreateFunction]
 */
@JsExport
@JsName("EvidenceTypeCreateCommandDTO")
interface EvidenceTypeCreateCommandDTO: EvidenceTypeCreateCommandDTO

/**
 * @d2 event
 * @parent [EvidenceTypeCreateFunction]
 */
@JsExport
@JsName("EvidenceTypeCreatedEventDTO")
interface EvidenceTypeCreatedEventDTO: EvidenceTypeCreatedEventDTO
