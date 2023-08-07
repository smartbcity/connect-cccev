package cccev.f2.evidence.type.domain.query

import cccev.f2.evidence.type.domain.D2EvidenceTypeF2Page
import cccev.f2.evidence.type.domain.model.EvidenceTypeDTO
import cccev.f2.evidence.type.domain.model.EvidenceTypeDTOBase
import cccev.s2.evidence.type.domain.EvidenceTypeId
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

/**
 * Get a data unit by its id.
 * @d2 function
 * @parent [D2EvidenceTypeF2Page]
 */
typealias EvidenceTypeGetFunction = F2Function<EvidenceTypeGetQueryDTOBase, EvidenceTypeGetResultDTOBase>

/**
 * @d2 query
 * @parent [EvidenceTypeGetFunction]
 */
@JsExport
@JsName("EvidenceTypeGetQueryDTO")
interface EvidenceTypeGetQueryDTO {
    /**
     * Identifier of the data unit to get.
     */
    val id: EvidenceTypeId
}

/**
 * @d2 inherit
 */
@Serializable
data class EvidenceTypeGetQueryDTOBase(
    override val id: EvidenceTypeId
): EvidenceTypeGetQueryDTO

/**
 * @d2 result
 * @parent [EvidenceTypeGetFunction]
 */
@JsExport
@JsName("EvidenceTypeGetResultDTO")
interface EvidenceTypeGetResultDTO {
    /**
     * The retrieved data unit.
     */
    val item: EvidenceTypeDTO?
}

/**
 * @d2 inherit
 */
@Serializable
data class EvidenceTypeGetResultDTOBase(
    override val item: EvidenceTypeDTOBase? = null
): EvidenceTypeGetResultDTO
