package cccev.test.s2.request.command

import cccev.projection.api.entity.request.RequestRepository
import cccev.s2.request.api.RequestAggregateService
import cccev.s2.request.domain.command.RequestRemoveEvidenceCommand
import cccev.test.CccevCucumberStepsDefinition
import cccev.test.s2.request.data.request
import io.cucumber.datatable.DataTable
import io.cucumber.java8.En
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.assertj.core.api.Assertions
import org.springframework.beans.factory.annotation.Autowired
import s2.bdd.assertion.AssertionBdd
import s2.bdd.data.TestContextKey

class RequestRemoveEvidenceSteps: En, CccevCucumberStepsDefinition() {

    @Autowired
    private lateinit var requestAggregateService: RequestAggregateService

    @Autowired
    private lateinit var requestRepository: RequestRepository

    private lateinit var command: RequestRemoveEvidenceCommand

    init {
        DataTableType(::requestRemoveEvidenceParams)
        DataTableType(::requestAssertParams)

        When("I remove an evidence from the request:") { params: RequestRemoveEvidenceParams ->
            step {
                removeEvidence(params)
            }
        }

        Given("An evidence is removed from the request:") { params: RequestRemoveEvidenceParams ->
            step {
                removeEvidence(params)
            }
        }

        Given("Some evidences are removed from the requests:") { dataTable: DataTable ->
            step {
                dataTable.asList(RequestRemoveEvidenceParams::class.java)
                    .forEach { removeEvidence(it) }
            }
        }

        Then("The request should not contain the evidence") {
            step {
                val requestId = context.requestIds.lastUsed
                AssertionBdd.request(requestRepository).assertThatId(requestId)
                    .doesNotHaveEvidences(listOf(command.evidenceId))
            }
        }

        Then("The request should not contain the evidence:") { params: RequestAssertParams ->
            step {
                val requestId = context.requestIds.safeGet(params.identifier)
                val request = requestRepository.findById(requestId).awaitSingleOrNull()
                Assertions.assertThat(request).isNotNull

                AssertionBdd.request(requestRepository).assertThatId(requestId)
                    .doesNotHaveEvidences(listOf(context.evidenceIds.safeGet(params.evidence)))
            }
        }
    }

    private suspend fun removeEvidence(params: RequestRemoveEvidenceParams) {
        command = RequestRemoveEvidenceCommand(
            id = context.requestIds[params.identifier] ?: params.identifier,
            evidenceId = context.evidenceIds[params.evidence] ?: params.evidence
        )
        requestAggregateService.removeEvidence(command)
    }

    private fun requestRemoveEvidenceParams(entry: Map<String, String>) = RequestRemoveEvidenceParams(
        identifier = entry["identifier"] ?: context.requestIds.lastUsedKey,
        evidence = entry["evidence"] ?: context.evidenceIds.lastUsedKey,
    )

    private data class RequestRemoveEvidenceParams(
        val identifier: TestContextKey,
        val evidence: TestContextKey,
    )

    private fun requestAssertParams(entry: Map<String, String>) = RequestAssertParams(
        identifier = entry["identifier"] ?: context.requestIds.lastUsedKey,
        evidence = entry["evidence"] ?: context.evidenceIds.lastUsedKey,
    )

    private data class RequestAssertParams(
        val identifier: TestContextKey,
        val evidence: TestContextKey
    )
}
