package cccev.f2.evidence.type.domain.command.list

import cccev.f2.evidence.type.domain.D2EvidenceTypeF2Page
import cccev.s2.evidence.domain.command.list.EvidenceTypeListCreateCommand
import cccev.s2.evidence.domain.command.list.EvidenceTypeListCreatedEvent
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
interface EvidenceTypeListCreateCommandDTO: cccev.s2.evidence.domain.command.list.EvidenceTypeListCreateCommandDTO

/**
 * @d2 event
 * @parent [EvidenceTypeListCreateFunction]
 */
@JsExport
@JsName("EvidenceTypeListCreatedEventDTO")
interface EvidenceTypeListCreatedEventDTO: cccev.s2.evidence.domain.command.list.EvidenceTypeListCreatedEventDTO
