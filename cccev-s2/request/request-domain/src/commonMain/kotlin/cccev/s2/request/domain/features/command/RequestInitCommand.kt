package cccev.s2.request.domain.features.command

import cccev.s2.request.domain.model.RequestId
import ccev.dsl.core.RequirementId
import s2.dsl.automate.S2InitCommand
import kotlin.js.JsExport
import kotlin.js.JsName

/**
 * Command to init a request.
 * @D2 command
 * @parent [RequestInitCommandFunction]
 */
@JsExport
@JsName("RequestInitCommandDTO")
interface RequestInitCommandDTO: S2InitCommand {
	/**
	 * The unique id of the request.
	 */
	val id: RequestId

	/**
	 * Identifier of the framework used for the request
	 */
	val frameworkId: RequirementId
}

/**
 * Event sent when a request has been created.
 * @D2 event
 * @parent [RequestInitCommandFunction]
 */
@JsExport
@JsName("RequestInitializedEventDTO")
interface RequestInitializedEventDTO {
	/**
	 * The unique id of the request.
	 */
	val id: RequestId
}

class RequestInitCommand(
	override val id: RequestId,
	override val frameworkId: RequirementId
): RequestInitCommandDTO

class RequestInitializedEvent(
	override val id: RequestId,
): RequestInitializedEventDTO
