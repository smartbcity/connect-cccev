package cccev.f2.request.client

import cccev.f2.request.domain.RequestApi
import cccev.f2.request.domain.command.RequestAddEvidenceFunction
import cccev.f2.request.domain.command.RequestAddRequirementsFunction
import cccev.f2.request.domain.command.RequestAddValuesFunction
import cccev.f2.request.domain.command.RequestCreateFunction
import cccev.f2.request.domain.command.RequestRemoveEvidenceFunction
import cccev.f2.request.domain.command.RequestRemoveRequirementsFunction
import f2.client.F2Client
import f2.client.function
import f2.dsl.fnc.F2SupplierSingle
import kotlin.js.JsExport
import kotlin.js.JsName

expect fun F2Client.requestClient(): F2SupplierSingle<RequestClient>
expect fun requestClient(urlBase: String): F2SupplierSingle<RequestClient>

@JsExport
@JsName("RequestClient")
open class RequestClient constructor(private val client: F2Client) : RequestApi {
    override fun requestCreate(): RequestCreateFunction = client.function(this::requestCreate.name)
    override fun requestAddRequirements(): RequestAddRequirementsFunction = client.function(this::requestAddRequirements.name)
    override fun requestRemoveRequirements(): RequestRemoveRequirementsFunction = client.function(this::requestRemoveRequirements.name)
    override fun requestAddValues(): RequestAddValuesFunction = client.function(this::requestAddValues.name)
    override fun requestAddEvidence(): RequestAddEvidenceFunction = client.function(this::requestAddEvidence.name)
    override fun requestRemoveEvidence(): RequestRemoveEvidenceFunction = client.function(this::requestRemoveEvidence.name)
}
