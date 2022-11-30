package cccev.s2.request.domain.features.command

import cccev.core.dsl.InformationConceptId
import cccev.core.dsl.SupportedValue
import cccev.core.dsl.SupportedValueDTO
import cccev.s2.request.domain.RequestCommand
import cccev.s2.request.domain.RequestEvent
import cccev.s2.request.domain.RequestState
import cccev.s2.request.domain.model.RequestId
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
@JsName("RequestSupportedValueAddCommandDTO")
interface RequestSupportedValueAddCommandDTO: RequestCommand {
	override val id: RequestId
	val supportedValue: SupportedValueDTO
}


@JsExport
@JsName("RequestSupportedValueAddedEventDto")
interface RequestSupportedValueAddedEventDTO: RequestEvent {
	override val id: RequestId
	override val type: RequestState.Created
	val providesValueFor: InformationConceptId
}

/**
 * Command to add a supported Value to a request.
 * @D2 command
 */
class RequestSupportedValueAddCommand(
	override val id: RequestId,
	/**
	 * The supported value to add.
	 */
	override val supportedValue: SupportedValue,
): RequestSupportedValueAddCommandDTO

/**
 * Event sent when a supported Value has been added to a request.
 * @D2 event
 */
class RequestSupportedValueAddedEvent(
	override val id: RequestId,

	/**
	 * The current state of the request.
	 * @example "Created"
	 */
	override val type: RequestState.Created = RequestState.Created,

	/**
	 * Identifier of the information concept for which the newly added supported value provides a value.
	 */
	override val providesValueFor: InformationConceptId,
): RequestSupportedValueAddedEventDTO
