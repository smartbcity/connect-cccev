package cccev.f2.certification.domain.query

import cccev.s2.certification.domain.model.Certification
import cccev.s2.certification.domain.model.CertificationDTO
import cccev.s2.certification.domain.model.CertificationIdentifier
import f2.dsl.fnc.F2Function
import kotlinx.serialization.Serializable
import kotlin.js.JsExport
import kotlin.js.JsName

typealias CertificationGetByIdentifierFunction
        = F2Function<CertificationGetByIdentifierQueryDTOBase, CertificationGetByIdentifierResultDTOBase>

@JsExport
@JsName("CertificationGetByIdentifierQueryDTO")
interface CertificationGetByIdentifierQueryDTO {
    val identifier: CertificationIdentifier
}

@Serializable
data class CertificationGetByIdentifierQueryDTOBase(
    override val identifier: CertificationIdentifier
): CertificationGetByIdentifierQueryDTO

@JsExport
@JsName("CertificationGetByIdentifierResultDTO")
interface CertificationGetByIdentifierResultDTO {
    val item: CertificationDTO?
}

@Serializable
data class CertificationGetByIdentifierResultDTOBase(
    override val item: Certification? = null
): CertificationGetByIdentifierResultDTO
