package cccev.s2.framework.domain.model

import cccev.s2.framework.domain.FrameworkId
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

@JsExport
@JsName("FrameworkDTO")
interface FrameworkDTO {
    /**
     *
     */
    val id: FrameworkId
    val identifier: String?
    val name: String
}

@Serializable
data class Framework(
    override val id: FrameworkId,
    override val identifier: String? = null,
    override val name: String
): FrameworkDTO
