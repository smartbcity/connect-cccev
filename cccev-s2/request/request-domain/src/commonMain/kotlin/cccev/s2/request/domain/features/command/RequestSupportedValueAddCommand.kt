package cccev.s2.request.domain.features.command

import cccev.dsl.model.SupportedValue
import cccev.dsl.model.SupportedValueDTO
import cccev.s2.request.domain.RequestCommand
import cccev.s2.request.domain.RequestEvent
import cccev.s2.request.domain.RequestState
import cccev.s2.request.domain.model.RequestId
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlinx.serialization.Serializable

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
	override val type: RequestState
	val supportedValue: SupportedValue
}

/**
 * Command to add a supported Value to a request.
 * @D2 command
 */
@Serializable
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
@Serializable
class RequestSupportedValueAddedEvent(
    override val id: RequestId,

    /**
	 * The current state of the request.
	 * @example "Created"
	 */
	override val type: RequestState = RequestState.CREATED,

	override val supportedValue: SupportedValue
): RequestSupportedValueAddedEventDTO
