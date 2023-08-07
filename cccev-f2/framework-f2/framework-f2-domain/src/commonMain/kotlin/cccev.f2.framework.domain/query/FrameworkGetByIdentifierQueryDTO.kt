package cccev.f2.framework.domain.query

import cccev.s2.framework.domain.FrameworkId
import cccev.s2.framework.domain.model.Framework
import cccev.s2.framework.domain.model.FrameworkDTO
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

typealias FrameworkGetByIdentifierFunction = F2Function<FrameworkGetByIdentifierQueryDTOBase, FrameworkGetByIdentifierResultDTOBase>

@JsExport
@JsName("FrameworkGetByIdentifierQueryDTO")
interface FrameworkGetByIdentifierQueryDTO {
    val identifier: FrameworkId
}

@Serializable
data class FrameworkGetByIdentifierQueryDTOBase(
    override val identifier: FrameworkId
): FrameworkGetByIdentifierQueryDTO

@JsExport
@JsName("FrameworkGetByIdentifierResultDTO")
interface FrameworkGetByIdentifierResultDTO {
    val item: FrameworkDTO?
}

@Serializable
data class FrameworkGetByIdentifierResultDTOBase(
    override val item: Framework?
): FrameworkGetByIdentifierResultDTO
