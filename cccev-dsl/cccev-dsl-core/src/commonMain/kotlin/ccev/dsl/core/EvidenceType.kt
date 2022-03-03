package ccev.dsl.core

import kotlin.js.JsExport
import kotlin.js.JsName

typealias EvidenceTypeListId = String
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
