package cccev.s2.request.domain.features.command

import cccev.dsl.model.FrameworkId
import cccev.dsl.model.RequirementId
import cccev.s2.request.domain.RequestEvent
import cccev.s2.request.domain.RequestState
import cccev.s2.request.domain.model.RequestId
import s2.dsl.automate.S2InitCommand
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable
import s2.dsl.automate.Evt


@JsExport
@JsName("RequestInitCommandDTO")
interface RequestInitCommandDTO: S2InitCommand {
	val id: RequestId
	val frameworkId: FrameworkId
}

@JsExport
@JsName("RequestInitializedEventDTO")
interface RequestInitializedEventDTO: RequestEvent {
	override val id: RequestId
	val frameworkId: RequirementId
}

/**
 * Command to init a request.
 * @D2 command
 */
@Serializable
class RequestInitCommand(
	override val id: RequestId,
	override val frameworkId: RequirementId
): RequestInitCommandDTO

/**
 * Event sent when a request has been created.
 * @D2 event
 */
@Serializable
class RequestInitializedEvent(
	/**
	 * The unique id of the request.
	 */
	override val id: RequestId,
	override val type: RequestState,
	override val frameworkId: RequirementId
): RequestInitializedEventDTO
