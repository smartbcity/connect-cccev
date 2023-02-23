package cccev.f2.concept.domain.query

import cccev.f2.concept.domain.D2InformationConceptF2Page
import cccev.f2.concept.domain.model.InformationConceptDTO
import cccev.f2.concept.domain.model.InformationConceptDTOBase
import cccev.s2.concept.domain.InformationConceptId
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

/**
 * Get an information concept by its id.
 * @d2 function
 * @parent [D2InformationConceptF2Page]
 */
typealias InformationConceptGetFunction = F2Function<InformationConceptGetQueryDTOBase, InformationConceptGetResultDTOBase>

/**
 * @d2 query
 * @parent [InformationConceptGetFunction]
 */
@JsExport
@JsName("InformationConceptGetQueryDTO")
interface InformationConceptGetQueryDTO {
    /**
     * Identifier of the information concept to get.
     */
    val id: InformationConceptId
}

/**
 * @d2 inherit
 */
@Serializable
data class InformationConceptGetQueryDTOBase(
    override val id: InformationConceptId
): InformationConceptGetQueryDTO

/**
 * @d2 result
 * @parent [InformationConceptGetFunction]
 */
@JsExport
@JsName("InformationConceptGetResultDTO")
interface InformationConceptGetResultDTO {
    /**
     * The retrieved information concept.
     */
    val item: InformationConceptDTO?
}

/**
 * @d2 inherit
 */
@Serializable
data class InformationConceptGetResultDTOBase(
    override val item: InformationConceptDTOBase?
): InformationConceptGetResultDTO
