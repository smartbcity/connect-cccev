package cccev.f2.evidence.type.domain.query

import cccev.f2.evidence.type.domain.D2EvidenceTypeF2Page
import cccev.f2.evidence.type.domain.model.EvidenceTypeListDTO
import cccev.f2.evidence.type.domain.model.EvidenceTypeListDTOBase
import cccev.s2.evidence.type.domain.EvidenceTypeListIdentifier
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

/**
 * Get a data unit by its identifier.
 * @d2 function
 * @parent [D2EvidenceTypeF2Page]
 */
typealias EvidenceTypeListGetByIdentifierFunction
        = F2Function<EvidenceTypeListGetByIdentifierQueryDTOBase, EvidenceTypeListGetByIdentifierResultDTOBase>

/**
 * @d2 query
 * @parent [EvidenceTypeListGetByIdentifierFunction]
 */
@JsExport
@JsName("EvidenceTypeListGetByIdentifierQueryDTO")
interface EvidenceTypeListGetByIdentifierQueryDTO {
    /**
     * Identifier of the data unit to GetByIdentifier.
     */
    val identifier: EvidenceTypeListIdentifier
}

/**
 * @d2 inherit
 */
@Serializable
data class EvidenceTypeListGetByIdentifierQueryDTOBase(
    override val identifier: EvidenceTypeListIdentifier
): EvidenceTypeListGetByIdentifierQueryDTO

/**
 * @d2 result
 * @parent [EvidenceTypeListGetByIdentifierFunction]
 */
@JsExport
@JsName("EvidenceTypeListGetByIdentifierResultDTO")
interface EvidenceTypeListGetByIdentifierResultDTO {
    /**
     * The retrieved data unit.
     */
    val item: EvidenceTypeListDTO?
}

/**
 * @d2 inherit
 */
@Serializable
data class EvidenceTypeListGetByIdentifierResultDTOBase(
    override val item: EvidenceTypeListDTOBase? = null
): EvidenceTypeListGetByIdentifierResultDTO
