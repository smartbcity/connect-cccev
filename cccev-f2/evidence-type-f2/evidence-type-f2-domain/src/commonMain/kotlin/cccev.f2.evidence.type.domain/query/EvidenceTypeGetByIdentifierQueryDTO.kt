package cccev.f2.evidence.type.domain.query

import cccev.f2.evidence.type.domain.D2EvidenceTypeF2Page
import cccev.f2.evidence.type.domain.model.EvidenceTypeDTO
import cccev.f2.evidence.type.domain.model.EvidenceTypeDTOBase
import cccev.s2.evidence.type.domain.EvidenceTypeId
import cccev.s2.evidence.type.domain.EvidenceTypeIdentifier
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

/**
 * Get a data unit by its identifier.
 * @d2 function
 * @parent [D2EvidenceTypeF2Page]
 */
typealias EvidenceTypeGetByIdentifierFunction
        = F2Function<EvidenceTypeGetByIdentifierQueryDTOBase, EvidenceTypeGetByIdentifierResultDTOBase>

/**
 * @d2 query
 * @parent [EvidenceTypeGetByIdentifierFunction]
 */
@JsExport
@JsName("EvidenceTypeGetByIdentifierQueryDTO")
interface EvidenceTypeGetByIdentifierQueryDTO {
    /**
     * Identifier of the data unit to GetByIdentifier.
     */
    val identifier: EvidenceTypeIdentifier
}

/**
 * @d2 inherit
 */
@Serializable
data class EvidenceTypeGetByIdentifierQueryDTOBase(
    override val identifier: EvidenceTypeIdentifier
): EvidenceTypeGetByIdentifierQueryDTO

/**
 * @d2 result
 * @parent [EvidenceTypeGetByIdentifierFunction]
 */
@JsExport
@JsName("EvidenceTypeGetByIdentifierResultDTO")
interface EvidenceTypeGetByIdentifierResultDTO {
    /**
     * The retrieved data unit.
     */
    val item: EvidenceTypeDTO?
}

/**
 * @d2 inherit
 */
@Serializable
data class EvidenceTypeGetByIdentifierResultDTOBase(
    override val item: EvidenceTypeDTOBase? = null
): EvidenceTypeGetByIdentifierResultDTO
