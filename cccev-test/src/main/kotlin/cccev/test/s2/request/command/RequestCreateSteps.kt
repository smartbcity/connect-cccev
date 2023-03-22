package cccev.test.s2.request.command

import cccev.projection.api.entity.request.RequestRepository
import cccev.s2.request.api.RequestAggregateService
import cccev.s2.request.domain.RequestState
import cccev.s2.request.domain.command.RequestCreateCommand
import cccev.test.CccevCucumberStepsDefinition
import cccev.test.s2.request.data.request
import io.cucumber.datatable.DataTable
import io.cucumber.java8.En
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.assertj.core.api.Assertions
import org.springframework.beans.factory.annotation.Autowired
import s2.bdd.assertion.AssertionBdd
import s2.bdd.data.TestContextKey
import s2.bdd.data.parser.extractList

class RequestCreateSteps: En, CccevCucumberStepsDefinition() {

    @Autowired
    private lateinit var requestAggregateService: RequestAggregateService

    @Autowired
    private lateinit var requestRepository: RequestRepository

    private lateinit var command: RequestCreateCommand

    init {
        DataTableType(::requestCreateParams)
        DataTableType(::requestAssertParams)

        When("I create a request") {
            step {
                createRequest(requestCreateParams(null))
            }
        }

        When("I create a request:") { params: RequestCreateParams ->
            step {
                createRequest(params)
            }
        }

        Given("A request is created") {
            step {
                createRequest(requestCreateParams(null))
            }
        }

        Given("A request is created:") { params: RequestCreateParams ->
            step {
                createRequest(params)
            }
        }

        Given("Some requests are created:") { dataTable: DataTable ->
            step {
                dataTable.asList(RequestCreateParams::class.java)
                    .forEach { createRequest(it) }
            }
        }

        Then("The request should be created") {
            step {
                val requestId = context.requestIds.lastUsed
                AssertionBdd.request(requestRepository).assertThatId(requestId).hasFields(
                    status = RequestState.CREATED,
                    name = command.name,
                    description = command.description,
                    requirements = command.requirements
                )
            }
        }

        Then("The request should be created:") { params: RequestAssertParams ->
            step {
                val requestId = context.requestIds.safeGet(params.identifier)
                val request = requestRepository.findById(requestId).awaitSingleOrNull()
                Assertions.assertThat(request).isNotNull

                AssertionBdd.request(requestRepository).assertThat(request!!).hasFields(
                    status = RequestState.CREATED,
                    name = params.name ?: request.name,
                    description = params.description ?: request.description,
                    requirements = params.requirements?.map(context.requirementIds::safeGet) ?: request.requirements.map { it.id }
                )
            }
        }
    }

    private suspend fun createRequest(params: RequestCreateParams) = context.requestIds.register(params.identifier) {
        command = RequestCreateCommand(
            name = params.name,
            description = params.description,
            requirements = params.requirements.map(context.requirementIds::safeGet),
        )
        requestAggregateService.create(command).id
    }

    private fun requestCreateParams(entry: Map<String, String>?) = RequestCreateParams(
        identifier = entry?.get("identifier").orRandom(),
        name = entry?.get("name").orRandom(),
        description = entry?.get("description"),
        requirements = entry?.extractList("requirements").orEmpty()
    )

    private data class RequestCreateParams(
        val identifier: TestContextKey,
        val name: String,
        val description: String?,
        val requirements: List<TestContextKey>,
    )

    private fun requestAssertParams(entry: Map<String, String>) = RequestAssertParams(
        identifier = entry["identifier"] ?: context.requestIds.lastUsedKey,
        name = entry["name"],
        description = entry["description"],
        requirements = entry.extractList("requirements")
    )

    private data class RequestAssertParams(
        val identifier: TestContextKey,
        val name: String?,
        val description: String?,
        val requirements: List<TestContextKey>?,
    )
}
