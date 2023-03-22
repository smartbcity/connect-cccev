package cccev.f2.request.client

import f2.client.F2Client
import f2.client.ktor.F2ClientBuilder
import f2.client.ktor.get
import f2.dsl.fnc.F2SupplierSingle
import f2.dsl.fnc.f2SupplierSingle

actual fun F2Client.requestClient(): F2SupplierSingle<RequestClient> = f2SupplierSingle {
    RequestClient(this)
}

actual fun requestClient(
    urlBase: String
): F2SupplierSingle<RequestClient> = f2SupplierSingle {
    RequestClient(
        F2ClientBuilder.get(urlBase)
    )
}
