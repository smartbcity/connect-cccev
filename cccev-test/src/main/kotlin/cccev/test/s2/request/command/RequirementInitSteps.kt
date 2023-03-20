package cccev.test.s2.request.command

import cccev.dsl.model.FrameworkId
import cccev.projection.api.entity.request.RequestRepository
import cccev.s2.request.api.RequestAggregateService
import cccev.s2.request.domain.RequestState
import cccev.s2.request.domain.features.command.RequestInitCommand
import cccev.test.CccevCucumberStepsDefinition
import cccev.test.s2.request.data.request
import s2.bdd.assertion.AssertionBdd
import s2.bdd.data.TestContextKey
import s2.bdd.data.parser.extractList
import io.cucumber.datatable.DataTable
import io.cucumber.java8.En
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.assertj.core.api.Assertions
import org.springframework.beans.factory.annotation.Autowired
import java.util.UUID

class RequestInitSteps: En, CccevCucumberStepsDefinition() {

    @Autowired
    private lateinit var requestAggregateService: RequestAggregateService

    @Autowired
    private lateinit var requestRepository: RequestRepository

    private lateinit var command: RequestInitCommand

    init {
        DataTableType(::requestCreateParams)
        DataTableType(::requestAssertParams)

        When("I create a request") {
            step {
                createRequest(requestCreateParams(null))
            }
        }

        When("I create a request:") { params: RequestInitParams ->
            step {
                createRequest(params)
            }
        }

        Given("A request is created") {
            step {
                createRequest(requestCreateParams(null))
            }
        }

        Given("A request is created:") { params: RequestInitParams ->
            step {
                createRequest(params)
            }
        }

        Given("Some requests are created:") { dataTable: DataTable ->
            step {
                dataTable.asList(RequestInitParams::class.java)
                    .forEach { createRequest(it) }
            }
        }

        Then("The request should be created") {
            step {
                val requestId = context.requestIds.lastUsed
                AssertionBdd.request(requestRepository).assertThatId(requestId).hasFields(
                    status = RequestState.CREATED,
                    frameworkId = command.frameworkId,
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
                    frameworkId = params.frameworkId,
                )
            }
        }
    }

    private suspend fun createRequest(params: RequestInitParams) = context.requestIds.register(params.identifier) {
        command = RequestInitCommand(
            id = "${params.identifier}_${UUID.randomUUID()}",
            frameworkId = params.frameworkId
        )
        context.requestIds[params.identifier] = command.id
        requestAggregateService.init(command).id
    }

    private fun requestCreateParams(entry: Map<String, String>?) = RequestInitParams(
        identifier = entry?.get("identifier").orRandom(),
        frameworkId = entry?.get("frameworkId").orRandom(),
    )

    private data class RequestInitParams(
        val identifier: TestContextKey,
        val frameworkId: TestContextKey,
    )

    private fun requestAssertParams(entry: Map<String, String>) = RequestAssertParams(
        identifier = entry["identifier"] ?: context.conceptIds.lastUsedKey,
        frameworkId = entry["frameworkId"],
    )

    private data class RequestAssertParams(
        val identifier: TestContextKey,
        val frameworkId: TestContextKey?,
    )
}
