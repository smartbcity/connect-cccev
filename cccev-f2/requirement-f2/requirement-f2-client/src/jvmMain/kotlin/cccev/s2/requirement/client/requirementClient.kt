package cccev.s2.requirement.client

import f2.client.ktor.F2ClientBuilder
import f2.client.ktor.Protocol
import f2.client.ktor.get
import f2.dsl.fnc.F2Supplier
import kotlinx.coroutines.flow.flow

actual fun requirementClient(
    protocol: Protocol,
    host: String,
    port: Int,
    path: String?,
): F2Supplier<RequirementClient> {
    return F2Supplier {
        flow {
            F2ClientBuilder.get(protocol, host, port, path).let { s2Client ->
                emit(RequirementClient(s2Client))
            }
        }
    }
}
