package cccev.f2.concept.domain.query

import cccev.f2.concept.domain.D2InformationConceptF2Page
import cccev.f2.concept.domain.model.InformationConceptDTO
import cccev.f2.concept.domain.model.InformationConceptDTOBase
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

/**
 * Get an information concept by its identifier.
 * @d2 function
 * @parent [D2InformationConceptF2Page]
 */
typealias InformationConceptGetByIdentifierFunction
        = F2Function<InformationConceptGetByIdentifierQueryDTOBase, InformationConceptGetByIdentifierResultDTOBase>

/**
 * @d2 query
 * @parent [InformationConceptGetByIdentifierFunction]
 */
@JsExport
@JsName("InformationConceptGetByIdentifierQueryDTO")
interface InformationConceptGetByIdentifierQueryDTO {
    /**
     * Identifier of the information concept to get.
     */
    val identifier: String
}

/**
 * @d2 inherit
 */
@Serializable
data class InformationConceptGetByIdentifierQueryDTOBase(
    override val identifier: String
): InformationConceptGetByIdentifierQueryDTO

/**
 * @d2 result
 * @parent [InformationConceptGetByIdentifierFunction]
 */
@JsExport
@JsName("InformationConceptGetByIdentifierResultDTO")
interface InformationConceptGetByIdentifierResultDTO {
    /**
     * The retrieved information concept.
     */
    val item: InformationConceptDTO?
}

/**
 * @d2 inherit
 */
@Serializable
data class InformationConceptGetByIdentifierResultDTOBase(
    override val item: InformationConceptDTOBase?
): InformationConceptGetByIdentifierResultDTO
