package cccev.f2.certification.domain.query

import cccev.s2.certification.domain.model.Certification
import cccev.s2.certification.domain.model.CertificationDTO
import cccev.s2.certification.domain.model.CertificationId
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

typealias CertificationGetFunction = F2Function<CertificationGetQueryDTOBase, CertificationGetResultDTOBase>

@JsExport
@JsName("CertificationGetQueryDTO")
interface CertificationGetQueryDTO {
    val id: CertificationId
}

@Serializable
data class CertificationGetQueryDTOBase(
    override val id: CertificationId
): CertificationGetQueryDTO

@JsExport
@JsName("CertificationGetResultDTO")
interface CertificationGetResultDTO {
    val item: CertificationDTO?
}

@Serializable
data class CertificationGetResultDTOBase(
    override val item: Certification?
): CertificationGetResultDTO
