package cccev.f2.evidence.type.domain.query

import cccev.f2.evidence.type.domain.D2EvidenceTypeF2Page
import cccev.f2.evidence.type.domain.model.EvidenceTypeListDTO
import cccev.f2.evidence.type.domain.model.EvidenceTypeListDTOBase
import cccev.s2.evidence.type.domain.EvidenceTypeListId
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

/**
 * Get a data unit by its id.
 * @d2 function
 * @parent [D2EvidenceTypeF2Page]
 */
typealias EvidenceTypeListGetFunction = F2Function<EvidenceTypeListGetQueryDTOBase, EvidenceTypeListGetResultDTOBase>

/**
 * @d2 query
 * @parent [EvidenceTypeListGetFunction]
 */
@JsExport
@JsName("EvidenceTypeListGetQueryDTO")
interface EvidenceTypeListGetQueryDTO {
    /**
     * Identifier of the data unit to get.
     */
    val id: EvidenceTypeListId
}

/**
 * @d2 inherit
 */
@Serializable
data class EvidenceTypeListGetQueryDTOBase(
    override val id: EvidenceTypeListId
): EvidenceTypeListGetQueryDTO

/**
 * @d2 result
 * @parent [EvidenceTypeListGetFunction]
 */
@JsExport
@JsName("EvidenceTypeListGetResultDTO")
interface EvidenceTypeListGetResultDTO {
    /**
     * The retrieved data unit.
     */
    val item: EvidenceTypeListDTO?
}

/**
 * @d2 inherit
 */
@Serializable
data class EvidenceTypeListGetResultDTOBase(
    override val item: EvidenceTypeListDTOBase? = null
): EvidenceTypeListGetResultDTO
