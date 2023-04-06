package cccev.s2.framework.domain.command

import cccev.s2.framework.domain.FrameworkEvent
import cccev.s2.framework.domain.FrameworkId
import cccev.s2.framework.domain.FrameworkInitCommand
import kotlinx.serialization.Serializable
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
@JsName("FrameworkCreateCommandDTO")
interface FrameworkCreateCommandDTO: FrameworkInitCommand {
    val identifier: String?
    val name: String
}

data class FrameworkCreateCommand(
    override val identifier: String?,
    override val name: String
): FrameworkCreateCommandDTO

@JsExport
@JsName("FrameworkCreatedEventDTO")
interface FrameworkCreatedEventDTO: FrameworkEvent {
    override val id: FrameworkId
    val identifier: String?
    val name: String
}

@Serializable
data class FrameworkCreatedEvent(
    override val id: FrameworkId,
    override val identifier: String?,
    override val name: String
): FrameworkCreatedEventDTO
