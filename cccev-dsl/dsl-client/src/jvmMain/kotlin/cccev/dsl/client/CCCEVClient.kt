package cccev.dsl.client

import cccev.s2.requirement.client.requirementClient
import f2.client.F2Client
import f2.client.ktor.F2ClientBuilder
import f2.client.ktor.get

class CCCEVClient(f2Client: F2Client) {
    companion object {
        suspend operator fun invoke(url: String): CCCEVClient {
            val f2Client = F2ClientBuilder.get(url)
            return CCCEVClient(f2Client)
        }
    }
    val requirementClient = f2Client.requirementClient()
}
