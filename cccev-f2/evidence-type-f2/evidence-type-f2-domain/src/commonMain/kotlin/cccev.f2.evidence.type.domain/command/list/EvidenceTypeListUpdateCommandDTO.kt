package cccev.f2.evidence.type.domain.command.list

import cccev.f2.evidence.type.domain.D2EvidenceTypeF2Page
import cccev.s2.evidence.type.domain.command.list.EvidenceTypeListUpdateCommand
import cccev.s2.evidence.type.domain.command.list.EvidenceTypeListUpdateCommandDTO
import cccev.s2.evidence.type.domain.command.list.EvidenceTypeListUpdatedEvent
import cccev.s2.evidence.type.domain.command.list.EvidenceTypeListUpdatedEventDTO
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
interface EvidenceTypeListUpdateCommandDTO: EvidenceTypeListUpdateCommandDTO

/**
 * @d2 event
 * @parent [EvidenceTypeListUpdateFunction]
 */
@JsExport
@JsName("EvidenceTypeListUpdatedEventDTO")
interface EvidenceTypeListUpdatedEventDTO: EvidenceTypeListUpdatedEventDTO
