package cccev.s2.request.domain.features.command

import cccev.core.dsl.FrameworkId
import cccev.core.dsl.RequirementId
import cccev.s2.request.domain.model.RequestId
import s2.dsl.automate.S2InitCommand
import kotlin.js.JsExport
import kotlin.js.JsName
import s2.dsl.automate.Evt


@JsExport
@JsName("RequestInitCommandDTO")
interface RequestInitCommandDTO: S2InitCommand {
	val id: RequestId
	val frameworkId: FrameworkId
}

@JsExport
@JsName("RequestInitializedEventDTO")
interface RequestInitializedEventDTO: Evt {
	val id: RequestId
}

/**
 * Command to init a request.
 * @D2 command
 */
class RequestInitCommand(
	override val id: RequestId,
	override val frameworkId: RequirementId
): RequestInitCommandDTO

/**
 * Event sent when a request has been created.
 * @D2 event
 */
class RequestInitializedEvent(
	/**
	 * The unique id of the request.
	 */
	override val id: RequestId,
): RequestInitializedEventDTO
