package cccev.s2.requirement.domain.command

import cccev.s2.requirement.domain.RequirementEvent
import cccev.s2.requirement.domain.RequirementId
import cccev.s2.requirement.domain.RequirementInitCommand
import cccev.s2.requirement.domain.model.RequirementKind
import kotlin.js.JsExport
import kotlin.js.JsName

data class RequirementCreateCommand(
    val kind: RequirementKind,
    val name: String?,
    val description: String?,
    val type: String?
): RequirementInitCommand

@JsExport
@JsName("RequirementCreatedEventDTO")
interface RequirementCreatedEventDTO: RequirementEvent

data class RequirementCreatedEvent(
    override val id: RequirementId,
): RequirementCreatedEventDTO
