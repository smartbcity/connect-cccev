package cccev.f2.evidence.type.domain.command.list

import cccev.f2.evidence.type.domain.D2EvidenceTypeF2Page
import cccev.s2.evidence.type.domain.command.list.EvidenceTypeListCreateCommand
import cccev.s2.evidence.type.domain.command.list.EvidenceTypeListCreateCommandDTO
import cccev.s2.evidence.type.domain.command.list.EvidenceTypeListCreatedEvent
import cccev.s2.evidence.type.domain.command.list.EvidenceTypeListCreatedEventDTO
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Create an evidence type list
 * @d2 function
 * @parent [D2EvidenceTypeF2Page]
 */
typealias EvidenceTypeListCreateFunction = F2Function<EvidenceTypeListCreateCommand, EvidenceTypeListCreatedEvent>

/**
 * @d2 command
 * @parent [EvidenceTypeListCreateFunction]
 */
@JsExport
@JsName("EvidenceTypeListCreateCommandDTO")
interface EvidenceTypeListCreateCommandDTO: EvidenceTypeListCreateCommandDTO

/**
 * @d2 event
 * @parent [EvidenceTypeListCreateFunction]
 */
@JsExport
@JsName("EvidenceTypeListCreatedEventDTO")
interface EvidenceTypeListCreatedEventDTO: EvidenceTypeListCreatedEventDTO
