package cccev.s2.evidence.type.domain.command.type

import cccev.s2.evidence.type.domain.D2EvidenceTypePage
import cccev.s2.evidence.type.domain.EvidenceTypeEvent
import cccev.s2.evidence.type.domain.EvidenceTypeId
import cccev.s2.evidence.type.domain.EvidenceTypeIdentifier
import cccev.s2.evidence.type.domain.EvidenceTypeInitCommand
import cccev.s2.evidence.type.domain.EvidenceTypeState
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

/**
 * Create a new evidence type.
 * @d2 function
 * @parent [D2EvidenceTypePage]
 * @order 10
 */
interface EvidenceTypeCreateFunction

@JsExport
@JsName("EvidenceTypeCreateCommandDTO")
interface EvidenceTypeCreateCommandDTO: EvidenceTypeInitCommand {
    /**
     * Custom identifier of the evidence type.
     * @example [cccev.s2.evidence.domain.model.EvidenceType.name]
     */
    val identifier: String?

    /**
     * Name of the evidence type.
     * @example [cccev.s2.evidence.domain.model.EvidenceType.name]
     */
    val name: String

    /**
     * Description of the evidence type.
     * @example [cccev.s2.evidence.domain.model.EvidenceType.description]
     */
    val description: String

    /**
     * How long (in milliseconds) an evidence of this type is considered as valid after it has been issued, if applicable.
     * @example [cccev.s2.evidence.domain.model.EvidenceType.validityPeriodConstraint]
     */
    val validityPeriodConstraint: Long?
}

/**
 * @d2 command
 * @parent [EvidenceTypeCreateFunction]
 */
@Serializable
data class EvidenceTypeCreateCommand(
    override val identifier: EvidenceTypeIdentifier? = null,
    override val name: String,
    override val description: String,
    override val validityPeriodConstraint: Long? = null
): EvidenceTypeCreateCommandDTO

@JsExport
@JsName("EvidenceTypeCreatedEventDTO")
interface EvidenceTypeCreatedEventDTO: EvidenceTypeEvent {
    /**
     * Identifier of the created evidence type.
     */
    val id: EvidenceTypeId

    /**
     * Custom identifier of the evidence type.
     * @example [cccev.s2.evidence.domain.model.EvidenceType.name]
     */
    val identifier: EvidenceTypeIdentifier?

    /**
     * Name of the evidence type.
     * @example [cccev.s2.evidence.domain.model.EvidenceType.name]
     */
    val name: String

    /**
     * Description of the evidence type.
     * @example [cccev.s2.evidence.domain.model.EvidenceType.description]
     */
    val description: String

    /**
     * How long (in milliseconds) an evidence of this type is considered as valid after it has been issued, if applicable.
     * @example [cccev.s2.evidence.domain.model.EvidenceType.validityPeriodConstraint]
     */
    val validityPeriodConstraint: Long?

    val status: EvidenceTypeState
}

/**
 * @d2 event
 * @parent [EvidenceTypeCreateFunction]
 */
@Serializable
data class EvidenceTypeCreatedEvent(
    override val id: EvidenceTypeId,
    override val identifier: String? = null,
    override val name: String,
    override val description: String,
    override val validityPeriodConstraint: Long? = null,
    override val status: EvidenceTypeState
): EvidenceTypeCreatedEventDTO {
    override fun s2Id() = id
}
