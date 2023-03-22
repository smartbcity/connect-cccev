package cccev.test.s2.request.command

import cccev.projection.api.entity.request.RequestRepository
import cccev.s2.request.api.RequestAggregateService
import cccev.s2.request.domain.command.RequestRemoveRequirementsCommand
import cccev.test.CccevCucumberStepsDefinition
import cccev.test.s2.request.data.request
import io.cucumber.java8.En
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.assertj.core.api.Assertions
import org.springframework.beans.factory.annotation.Autowired
import s2.bdd.assertion.AssertionBdd
import s2.bdd.data.TestContextKey
import s2.bdd.data.parser.safeExtractList

class RequestRemoveRequirementsSteps: En, CccevCucumberStepsDefinition() {

    @Autowired
    private lateinit var requestAggregateService: RequestAggregateService

    @Autowired
    private lateinit var requestRepository: RequestRepository

    private lateinit var command: RequestRemoveRequirementsCommand

    init {
        DataTableType(::requestRemoveRequirementsParams)
        DataTableType(::requestAssertParams)

        When("I remove requirements from the request:") { params: RequestRemoveRequirementsParams ->
            step {
                removeRequirements(params)
            }
        }

        Given("Some requirements are remove from the request:") { params: RequestRemoveRequirementsParams ->
            step {
                removeRequirements(params)
            }
        }

        Then("The request should not contain the requirements") {
            step {
                val requestId = context.requestIds.lastUsed
                AssertionBdd.request(requestRepository).assertThatId(requestId)
                    .doesNotHaveRequirements(command.requirementIds)
            }
        }

        Then("The request should not contain the requirements:") { params: RequestAssertParams ->
            step {
                val requestId = context.requestIds.safeGet(params.identifier)
                val request = requestRepository.findById(requestId).awaitSingleOrNull()
                Assertions.assertThat(request).isNotNull

                AssertionBdd.request(requestRepository).assertThatId(requestId)
                    .doesNotHaveRequirements(params.requirements.map(context.requirementIds::safeGet))
            }
        }
    }

    private suspend fun removeRequirements(params: RequestRemoveRequirementsParams) {
        command = RequestRemoveRequirementsCommand(
            id = context.requestIds[params.identifier] ?: params.identifier,
            requirementIds = params.requirements.map(context.requirementIds::safeGet),
        )
        requestAggregateService.removeRequirements(command)
    }

    private fun requestRemoveRequirementsParams(entry: Map<String, String>) = RequestRemoveRequirementsParams(
        identifier = entry["identifier"] ?: context.requestIds.lastUsedKey,
        requirements = entry.safeExtractList("requirements")
    )

    private data class RequestRemoveRequirementsParams(
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
