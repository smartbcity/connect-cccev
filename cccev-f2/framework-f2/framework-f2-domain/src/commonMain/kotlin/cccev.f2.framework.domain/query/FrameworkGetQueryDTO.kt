package cccev.f2.framework.domain.query

import cccev.s2.framework.domain.FrameworkId
import cccev.s2.framework.domain.model.Framework
import cccev.s2.framework.domain.model.FrameworkDTO
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

typealias FrameworkGetFunction = F2Function<FrameworkGetQueryDTOBase, FrameworkGetResultDTOBase>

@JsExport
@JsName("FrameworkGetQueryDTO")
interface FrameworkGetQueryDTO {
    val id: FrameworkId
}

data class FrameworkGetQueryDTOBase(
    override val id: FrameworkId
): FrameworkGetQueryDTO

@JsExport
@JsName("FrameworkGetResultDTO")
interface FrameworkGetResultDTO {
    val item: FrameworkDTO?
}

@Serializable
data class FrameworkGetResultDTOBase(
    override val item: Framework?
): FrameworkGetResultDTO
