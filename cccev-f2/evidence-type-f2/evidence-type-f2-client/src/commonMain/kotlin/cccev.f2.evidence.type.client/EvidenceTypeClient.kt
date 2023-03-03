package cccev.f2.evidence.type.client

import cccev.f2.evidence.type.domain.EvidenceTypeApi
import cccev.f2.evidence.type.domain.command.list.EvidenceTypeListCreateFunction
import cccev.f2.evidence.type.domain.command.list.EvidenceTypeListUpdateFunction
import cccev.f2.evidence.type.domain.command.type.EvidenceTypeCreateFunction
import f2.client.F2Client
import f2.client.function
import f2.dsl.fnc.F2SupplierSingle
import kotlin.js.JsExport
import kotlin.js.JsName

expect fun F2Client.evidenceTypeClient(): F2SupplierSingle<EvidenceTypeClient>
expect fun evidenceTypeClient(urlBase: String): F2SupplierSingle<EvidenceTypeClient>

@JsName("EvidenceTypeClient")
@JsExport
open class EvidenceTypeClient constructor(private val client: F2Client) : EvidenceTypeApi {
    override fun evidenceTypeCreate(): EvidenceTypeCreateFunction  = client.function(this::evidenceTypeCreate.name)
    override fun evidenceTypeListCreate(): EvidenceTypeListCreateFunction  = client.function(this::evidenceTypeListCreate.name)
    override fun evidenceTypeListUpdate(): EvidenceTypeListUpdateFunction  = client.function(this::evidenceTypeListUpdate.name)
}
