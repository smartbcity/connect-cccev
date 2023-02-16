package cccev.f2.evidence.type.domain.command.list

import cccev.f2.evidence.type.domain.D2EvidenceTypeF2Page
import cccev.s2.evidence.domain.command.list.EvidenceTypeListUpdateCommand
import cccev.s2.evidence.domain.command.list.EvidenceTypeListUpdatedEvent
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Update an evidence type list
 * @d2 function
 * @parent [D2EvidenceTypeF2Page]
 */
typealias EvidenceTypeListUpdateFunction = F2Function<EvidenceTypeListUpdateCommand, EvidenceTypeListUpdatedEvent>

/**
 * @d2 command
 * @parent [EvidenceTypeListUpdateFunction]
 */
@JsExport
@JsName("EvidenceTypeListUpdateCommandDTO")
interface EvidenceTypeListUpdateCommandDTO: cccev.s2.evidence.domain.command.list.EvidenceTypeListUpdateCommandDTO

/**
 * @d2 event
 * @parent [EvidenceTypeListUpdateFunction]
 */
@JsExport
@JsName("EvidenceTypeListUpdatedEventDTO")
interface EvidenceTypeListUpdatedEventDTO: cccev.s2.evidence.domain.command.list.EvidenceTypeListUpdatedEventDTO
