package cccev.f2.request.domain.query

import cccev.s2.request.domain.model.Request
import cccev.s2.request.domain.model.RequestDTO
import cccev.s2.request.domain.model.RequestId
import f2.dsl.fnc.F2Function
import kotlinx.serialization.Serializable
import kotlin.js.JsExport
import kotlin.js.JsName

typealias RequestGetFunction = F2Function<RequestGetQueryDTOBase, RequestGetResultDTOBase>

@JsExport
@JsName("RequestGetQueryDTO")
interface RequestGetQueryDTO {
    val id: RequestId
}

@Serializable
data class RequestGetQueryDTOBase(
    override val id: RequestId
): RequestGetQueryDTO

@JsExport
@JsName("RequestGetResultDTO")
interface RequestGetResultDTO {
    val item: RequestDTO?
}

@Serializable
data class RequestGetResultDTOBase(
    override val item: Request?
): RequestGetResultDTO
