package features.cccev.test.entities.request

import cccev.s2.request.api.RequestAggregateService
import cccev.s2.request.domain.features.command.RequestInitCommand
import features.cccev.test.CucumberStepsDefinition
import fixers.bdd.exception.EntityNotInitializedException
import io.cucumber.java8.En
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Autowired
import java.util.UUID

class RequestInitSteps: En, CucumberStepsDefinition() {

    @Autowired
    private lateinit var requestService: RequestAggregateService

    init {
        Given("A request is instantiated from this requirement") {
            val requirementId = context.requirements.lastUsedKey
                ?: throw EntityNotInitializedException("lastCreated", "Requirement")

            val command = RequestInitCommand(
                id = UUID.randomUUID().toString(),
                frameworkId = requirementId
            )
            runBlocking {
                requestService.init(command)
            }
            context.requests += command.id
        }
    }
}
