package cccev.f2.framework.client

import f2.client.F2Client
import f2.client.ktor.F2ClientBuilder
import f2.client.ktor.get
import f2.dsl.fnc.F2SupplierSingle
import f2.dsl.fnc.f2SupplierSingle

actual fun F2Client.frameworkClient(): F2SupplierSingle<FrameworkClient> = f2SupplierSingle {
    FrameworkClient(this)
}


actual fun frameworkClient(urlBase: String): F2SupplierSingle<FrameworkClient> = f2SupplierSingle {
    FrameworkClient(
        F2ClientBuilder.get(urlBase)
    )
}
