package cccev.s2.requirement.client

import f2.client.ktor.F2ClientBuilder
import f2.client.ktor.Protocol
import f2.client.ktor.get
import f2.dsl.fnc.F2Supplier
import kotlin.js.Promise

@JsName("requirementClient")
@JsExport
actual fun requirementClient(protocol: Protocol, host: String, port: Int, path: String?): F2Supplier<RequirementClient> {
    return object : F2Supplier<RequirementClient> {
        override fun invoke(): Promise<Array<RequirementClient>> {
            return F2ClientBuilder.get(protocol, host, port, path).then { s2Client ->
                arrayOf(RequirementClient(s2Client))
            }
        }
    }
}
