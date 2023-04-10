package cccev.s2.evidence.domain.command.list

import cccev.s2.evidence.domain.D2EvidenceTypePage
import cccev.s2.evidence.domain.EvidenceTypeId
import cccev.s2.evidence.domain.EvidenceTypeListEvent
import cccev.s2.evidence.domain.EvidenceTypeListId
import cccev.s2.evidence.domain.EvidenceTypeListInitCommand
import cccev.s2.evidence.domain.EvidenceTypeListState
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

/**
 * Create a new evidence type list.
 * @d2 function
 * @parent [D2EvidenceTypePage]
 * @order 100
 */
interface EvidenceTypeListCreateFunction

@JsExport
@JsName("EvidenceTypeListCreateCommandDTO")
interface EvidenceTypeListCreateCommandDTO: EvidenceTypeListInitCommand {
    /**
     * Custom identifier of the evidence type list.
     * @example [cccev.s2.evidence.domain.model.EvidenceTypeList.name]
     */
    val identifier: String?

    /**
     * Name of the evidence type list.
     * @example [cccev.s2.evidence.domain.model.EvidenceTypeList.name]
     */
    val name: String

    /**
     * Description of the evidence type list.
     * @example [cccev.s2.evidence.domain.model.EvidenceTypeList.description]
     */
    val description: String

    /**
     *
     * @example [cccev.s2.evidence.domain.model.EvidenceTypeList.specifiesEvidenceType]
     */
    val specifiesEvidenceType: List<EvidenceTypeId>
}

/**
 * @d2 command
 * @parent [EvidenceTypeListCreateFunction]
 */
@Serializable
data class EvidenceTypeListCreateCommand(
    override val identifier: String?,
    override val name: String,
    override val description: String,
    override val specifiesEvidenceType: List<EvidenceTypeId>
): EvidenceTypeListCreateCommandDTO

@JsExport
@JsName("EvidenceTypeListCreatedEventDTO")
interface EvidenceTypeListCreatedEventDTO: EvidenceTypeListEvent {
    /**
     * Identifier of the created evidence type list.
     */
    override val id: EvidenceTypeListId

    /**
     * Custom identifier of the evidence type list.
     * @example [cccev.s2.evidence.domain.model.EvidenceTypeList.name]
     */
    val identifier: String?

    /**
     * Name of the evidence type list.
     * @example [cccev.s2.evidence.domain.model.EvidenceTypeList.name]
     */
    val name: String

    /**
     * Description of the evidence type list.
     * @example [cccev.s2.evidence.domain.model.EvidenceTypeList.description]
     */
    val description: String

    /**
     *
     * @example [cccev.s2.evidence.domain.model.EvidenceTypeList.specifiesEvidenceType]
     */
    val specifiesEvidenceType: List<EvidenceTypeId>

    val status: EvidenceTypeListState
}

/**
 * @d2 event
 * @parent [EvidenceTypeListCreateFunction]
 */
@Serializable
data class EvidenceTypeListCreatedEvent(
    override val id: EvidenceTypeListId,
    override val identifier: String?,
    override val name: String,
    override val description: String,
    override val specifiesEvidenceType: List<EvidenceTypeId>,
    override val status: EvidenceTypeListState
): EvidenceTypeListCreatedEventDTO {
    override fun s2Id() = id
}
