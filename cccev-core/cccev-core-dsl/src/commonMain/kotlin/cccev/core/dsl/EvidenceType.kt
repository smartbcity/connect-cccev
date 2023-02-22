package cccev.core.dsl

import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * The unique id of the evidence type list.
 * @visual json "bf92ba66-de62-41dc-af93-bd645b4f5bcb"
 * @parent [D2DslPage]
 * @d2 model
 */
typealias EvidenceTypeListId = String

/**
 * The unique id of the evidence type.
 * @visual json "082f9b5b-4ffa-4e95-8288-2de2972cade5"
 * @parent [D2DslPage]
 * @d2 model
 */
typealias EvidenceTypeId = String

@JsExport
@JsName("EvidenceTypeList")
interface EvidenceTypeList {
	val description: String
	val identifier: EvidenceTypeListId
	val name: String
	val specifiesEvidenceType: List<EvidenceType>
}

open class EvidenceTypeListBase(
	override val description: String,
	override val identifier: EvidenceTypeListId,
	override val name: String,
	override val specifiesEvidenceType: List<EvidenceTypeBase>
): EvidenceTypeList

@JsExport
@JsName("EvidenceType")
interface EvidenceType {
	val identifier: EvidenceTypeId
	val name: String
	val evidenceTypeClassification: Code
	val validityPeriodConstraint: PeriodOfTime?
	val issuingPlace: CoreLocationLocation?
}

open class EvidenceTypeBase(
	override val identifier: EvidenceTypeId,
	override val name: String,
	override val evidenceTypeClassification: Code,
	override val validityPeriodConstraint: PeriodOfTime? = null,
	override val issuingPlace: CoreLocationLocation? = null
): EvidenceType

@JsExport
open class CoreLocationLocation

@JsExport
open class PeriodOfTime(
	duration: String? = null,
	endTime: Int? = null,
	startTime: Int? = null,
)
