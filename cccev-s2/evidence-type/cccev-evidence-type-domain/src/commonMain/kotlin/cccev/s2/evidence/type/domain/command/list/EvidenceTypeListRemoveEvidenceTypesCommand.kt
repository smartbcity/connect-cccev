package cccev.s2.evidence.type.domain.command.list

import cccev.s2.evidence.type.domain.EvidenceTypeId
import cccev.s2.evidence.type.domain.EvidenceTypeListCommand
import cccev.s2.evidence.type.domain.EvidenceTypeListEvent
import cccev.s2.evidence.type.domain.EvidenceTypeListId
import kotlinx.serialization.Serializable

/**
 * Remove a list of evidence types from an evidence type list.
 * @d2 function
 * @parent [D2EvidenceTypeListPage]
 * @order 40
 */
interface EvidenceTypeListRemoveEvidenceTypesFunction

/**
 * @d2 command
 * @parent [EvidenceTypeListRemoveEvidenceTypesFunction]
 */
data class EvidenceTypeListRemoveEvidenceTypesCommand(
    /**
     * Id of the evidence type list to remove evidence types from.
     */
    override val id: EvidenceTypeListId,

    /**
     * Ids of the evidence types to remove.
     */
    val evidenceTypeIds: List<EvidenceTypeId>
): EvidenceTypeListCommand

/**
 * @d2 event
 * @parent [EvidenceTypeListRemoveEvidenceTypesFunction]
 */
@Serializable
data class EvidenceTypeListRemovedEvidenceTypesEvent(
    /** @ref [EvidenceTypeListRemoveEvidenceTypesCommand.id] */
    override val id: EvidenceTypeListId,

    /** @ref [EvidenceTypeListRemoveEvidenceTypesCommand.evidenceTypeIds] */
    val evidenceTypeIds: List<EvidenceTypeId> = emptyList()
): EvidenceTypeListEvent
