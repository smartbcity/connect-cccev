package cccev.s2.requirement.domain.features.command

import cccev.core.dsl.FrameworkId
import cccev.core.dsl.RequirementId
import s2.dsl.automate.S2InitCommand
import kotlin.js.JsExport
import kotlin.js.JsName
import s2.dsl.automate.Evt


@JsExport
@JsName("InformationRequirementInitCommandDTO")
interface InformationRequirementCreateCommandDTO: S2InitCommand {
	val id: RequirementId
	val frameworkId: FrameworkId
}

@JsExport
@JsName("InformationRequirementInitializedEventDTO")
interface InformationRequirementCreatedEventDTO: Evt {
	val id: RequirementId
}

/**
 * Command to init a request.
 * @D2 command
 */
class InformationRequirementCreateCommand(
	override val id: RequirementId,
	override val frameworkId: FrameworkId
): InformationRequirementCreateCommandDTO

/**
 * Event sent when a request has been created.
 * @D2 event
 */
class InformationRequirementInitializedEvent(
	/**
	 * The unique id of the request.
	 */
	override val id: RequirementId,
): InformationRequirementCreatedEventDTO
