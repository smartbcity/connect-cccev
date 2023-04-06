package cccev.s2.framework.domain.model

import cccev.s2.framework.domain.FrameworkId
import kotlin.js.JsExport
import kotlin.js.JsName

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

data class Framework(
    override val id: FrameworkId,
    override val identifier: String?,
    override val name: String
): FrameworkDTO
