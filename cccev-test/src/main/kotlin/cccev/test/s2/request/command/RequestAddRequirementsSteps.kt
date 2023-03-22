package cccev.test.s2.request.command

import cccev.projection.api.entity.request.RequestRepository
import cccev.s2.request.api.RequestAggregateService
import cccev.s2.request.domain.command.RequestAddRequirementsCommand
import cccev.test.CccevCucumberStepsDefinition
import cccev.test.s2.request.data.request
import io.cucumber.java8.En
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.assertj.core.api.Assertions
import org.springframework.beans.factory.annotation.Autowired
import s2.bdd.assertion.AssertionBdd
import s2.bdd.data.TestContextKey
import s2.bdd.data.parser.safeExtractList

class RequestAddRequirementsSteps: En, CccevCucumberStepsDefinition() {

    @Autowired
    private lateinit var requestAggregateService: RequestAggregateService

    @Autowired
    private lateinit var requestRepository: RequestRepository

    private lateinit var command: RequestAddRequirementsCommand

    init {
        DataTableType(::requestAddRequirementsParams)
        DataTableType(::requestAssertParams)

        When("I add requirements to the request:") { params: RequestAddRequirementsParams ->
            step {
                addRequirements(params)
            }
        }

        Given("Some requirements are added to the request:") { params: RequestAddRequirementsParams ->
            step {
                addRequirements(params)
            }
        }

        Then("The request should contain the requirements") {
            step {
                val requestId = context.requestIds.lastUsed
                AssertionBdd.request(requestRepository).assertThatId(requestId)
                    .hasRequirements(command.requirementIds)
            }
        }

        Then("The request should contain the requirements:") { params: RequestAssertParams ->
            step {
                val requestId = context.requestIds.safeGet(params.identifier)
                val request = requestRepository.findById(requestId).awaitSingleOrNull()
                Assertions.assertThat(request).isNotNull

                AssertionBdd.request(requestRepository).assertThatId(requestId)
                    .hasRequirements(params.requirements.map(context.requirementIds::safeGet))
            }
        }
    }

    private suspend fun addRequirements(params: RequestAddRequirementsParams) {
        command = RequestAddRequirementsCommand(
            id = context.requestIds[params.identifier] ?: params.identifier,
            requirementIds = params.requirements.map(context.requirementIds::safeGet),
        )
        requestAggregateService.addRequirements(command)
    }

    private fun requestAddRequirementsParams(entry: Map<String, String>) = RequestAddRequirementsParams(
        identifier = entry["identifier"] ?: context.requestIds.lastUsedKey,
        requirements = entry.safeExtractList("requirements")
    )

    private data class RequestAddRequirementsParams(
        val identifier: TestContextKey,
        val requirements: List<TestContextKey>
    )

    private fun requestAssertParams(entry: Map<String, String>) = RequestAssertParams(
        identifier = entry["identifier"] ?: context.requestIds.lastUsedKey,
        requirements = entry.safeExtractList("requirements")
    )

    private data class RequestAssertParams(
        val identifier: TestContextKey,
        val requirements: List<TestContextKey>
    )
}
