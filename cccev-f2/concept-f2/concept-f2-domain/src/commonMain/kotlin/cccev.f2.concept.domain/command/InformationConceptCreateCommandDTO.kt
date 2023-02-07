package cccev.f2.concept.domain.command

import cccev.f2.concept.domain.D2InformationConceptF2Page
import cccev.s2.concept.domain.command.InformationConceptCreateCommand
import cccev.s2.concept.domain.command.InformationConceptCreatedEvent
import f2.dsl.fnc.F2Function
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Create an information concept.
 * @d2 function
 * @parent [D2InformationConceptF2Page]
 */
typealias InformationConceptCreateFunction = F2Function<InformationConceptCreateCommand, InformationConceptCreatedEvent>

/**
 * @d2 command
 * @parent [InformationConceptCreateFunction]
 */
@JsExport
@JsName("InformationConceptCreateCommandDTO")
interface InformationConceptCreateCommandDTO: cccev.s2.concept.domain.command.InformationConceptCreateCommandDTO

/**
 * @d2 event
 * @parent [InformationConceptCreateFunction]
 */
@JsExport
@JsName("InformationConceptCreatedEventDTO")
interface InformationConceptCreatedEventDTO: cccev.s2.concept.domain.command.InformationConceptCreatedEventDTO
