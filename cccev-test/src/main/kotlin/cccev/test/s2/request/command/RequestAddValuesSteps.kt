package cccev.test.s2.request.command

import cccev.projection.api.entity.request.RequestRepository
import cccev.s2.request.api.RequestAggregateService
import cccev.s2.request.domain.command.RequestAddValuesCommand
import cccev.test.CccevCucumberStepsDefinition
import cccev.test.s2.request.data.request
import io.cucumber.datatable.DataTable
import io.cucumber.java8.En
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.assertj.core.api.Assertions
import org.springframework.beans.factory.annotation.Autowired
import s2.bdd.assertion.AssertionBdd
import s2.bdd.data.TestContextKey
import s2.bdd.data.parser.safeExtract

class RequestAddValuesSteps: En, CccevCucumberStepsDefinition() {

    @Autowired
    private lateinit var requestAggregateService: RequestAggregateService

    @Autowired
    private lateinit var requestRepository: RequestRepository

    private lateinit var command: RequestAddValuesCommand

    init {
        DataTableType(::requestAddValuesParams)
        DataTableType(::requestAssertParams)

        When("I add values to the request:") { dataTable: DataTable ->
            step {
                dataTable.asList(RequestAddValuesParams::class.java)
                    .groupBy(RequestAddValuesParams::identifier)
                    .forEach { (identifier, params) ->
                        addValues(identifier, params.associate { it.concept to it.value })
                    }
            }
        }

        When("Some values are added to the request:") { dataTable: DataTable ->
            step {
                dataTable.asList(RequestAddValuesParams::class.java)
                    .groupBy(RequestAddValuesParams::identifier)
                    .forEach { (identifier, params) ->
                        addValues(identifier, params.associate { it.concept to it.value })
                    }
            }
        }

        Then("The request should contain the values") {
            step {
                val requestId = context.requestIds.lastUsed
                AssertionBdd.request(requestRepository).assertThatId(requestId)
                    .hasSupportedValues(command.values)
            }
        }

        Then("The request should contain the values:") { dataTable: DataTable ->
            step {
                dataTable.asList(RequestAssertParams::class.java)
                    .groupBy(RequestAssertParams::identifier)
                    .forEach { (identifier, params) ->
                        val requestId = context.requestIds.safeGet(identifier)
                        val request = requestRepository.findById(requestId).awaitSingleOrNull()
                        Assertions.assertThat(request).isNotNull

                        val supportedValues = params.associate { context.conceptIds.safeGet(it.concept) to it.value }
                        AssertionBdd.request(requestRepository).assertThatId(requestId)
                            .hasSupportedValues(supportedValues)
                    }
            }
        }
    }

    private suspend fun addValues(identifier: TestContextKey, values: Map<TestContextKey, String?>) {
        command = RequestAddValuesCommand(
            id = context.requestIds[identifier] ?: identifier,
            values = values.mapKeys { (conceptIdentifier) -> context.conceptIds.safeGet(conceptIdentifier) }
        )
        requestAggregateService.addValues(command)
    }

    private fun requestAddValuesParams(entry: Map<String, String>) = RequestAddValuesParams(
        identifier = entry["identifier"] ?: context.requestIds.lastUsedKey,
        concept = entry.safeExtract("concept"),
        value = entry["value"]
    )

    private data class RequestAddValuesParams(
        val identifier: TestContextKey,
        val concept: TestContextKey,
        val value: String?
    )

    private fun requestAssertParams(entry: Map<String, String>) = RequestAssertParams(
        identifier = entry["identifier"] ?: context.requestIds.lastUsedKey,
        concept = entry.safeExtract("concept"),
        value = entry.safeExtract("value")
    )

    private data class RequestAssertParams(
        val identifier: TestContextKey,
        val concept: TestContextKey,
        val value: String?
    )
}
