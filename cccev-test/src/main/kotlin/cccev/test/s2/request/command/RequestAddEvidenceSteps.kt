package cccev.test.s2.request.command

import cccev.projection.api.entity.request.RequestRepository
import cccev.s2.request.api.RequestAggregateService
import cccev.s2.request.domain.command.RequestAddEvidenceCommand
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

class RequestAddEvidenceSteps: En, CccevCucumberStepsDefinition() {

    @Autowired
    private lateinit var requestAggregateService: RequestAggregateService

    @Autowired
    private lateinit var requestRepository: RequestRepository

    private lateinit var command: RequestAddEvidenceCommand

    init {
        DataTableType(::requestAddEvidenceParams)
        DataTableType(::requestAssertParams)

        When("I add an evidence to the request") {
            step {
                addEvidence(requestAddEvidenceParams(null))
            }
        }

        When("I add an evidence to the request:") { params: RequestAddEvidenceParams ->
            step {
                addEvidence(params)
            }
        }

        Given("An evidence is added to the request") {
            step {
                addEvidence(requestAddEvidenceParams(null))
            }
        }

        Given("An evidence is added to the request:") { params: RequestAddEvidenceParams ->
            step {
                addEvidence(params)
            }
        }

        Given("Some evidences are added to the requests:") { dataTable: DataTable ->
            step {
                dataTable.asList(RequestAddEvidenceParams::class.java)
                    .forEach { addEvidence(it) }
            }
        }

        Then("The request should contain the evidence") {
            step {
                val requestId = context.requestIds.lastUsed
                val evidenceId = context.evidenceIds.lastUsed
                AssertionBdd.request(requestRepository)
                    .assertThatId(requestId)
                    .assertThatEvidence(evidenceId)
                    .hasFields(
                        name = command.name,
                        isConformantTo = command.isConformantTo
                    )
            }
        }

        Then("The request should contain the evidence:") { params: RequestAssertParams ->
            step {
                assertRequest(params)
            }
        }

        Then("The requests should contain the evidences:") { dataTable: DataTable ->
            step {
                dataTable.asList(RequestAssertParams::class.java)
                    .forEach { assertRequest(it) }
            }
        }
    }

    private suspend fun addEvidence(params: RequestAddEvidenceParams) = context.evidenceIds.register(params.evidence) {
        command = RequestAddEvidenceCommand(
            id = context.requestIds[params.identifier] ?: params.identifier,
            name = params.name,
            file = null,
            url = null,
            isConformantTo = params.isConformantTo.map(context.evidenceTypeIds::safeGet),
        )
        requestAggregateService.addEvidence(command).evidenceId
    }

    private fun requestAddEvidenceParams(entry: Map<String, String>?) = RequestAddEvidenceParams(
        identifier = entry?.get("identifier") ?: context.requestIds.lastUsedKey,
        evidence = entry?.get("evidence").orRandom(),
        name = entry?.get("name").orRandom(),
        isConformantTo = entry?.extractList("isConformantTo").orEmpty()
    )

    private data class RequestAddEvidenceParams(
        val identifier: TestContextKey,
        val evidence: TestContextKey,
        val name: String,
        val isConformantTo: List<TestContextKey>,
    )

    private suspend fun assertRequest(params: RequestAssertParams) {
        val requestId = context.requestIds.safeGet(params.identifier)
        val request = requestRepository.findById(requestId).awaitSingleOrNull()
        Assertions.assertThat(request).isNotNull

        val requestAsserter = AssertionBdd.request(requestRepository).assertThat(request!!)

        val evidenceId = context.evidenceIds.safeGet(params.evidence)
        requestAsserter.hasEvidences(listOf(evidenceId))

        val evidence = request.evidences.first { it.id == evidenceId }
        requestAsserter.assertThatEvidence(evidenceId).hasFields(
            name = params.name ?: evidence.name,
            isConformantTo = params.isConformantTo?.map(context.evidenceTypeIds::safeGet) ?: evidence.isConformantTo.map { it.id }
        )
    }

    private fun requestAssertParams(entry: Map<String, String>) = RequestAssertParams(
        identifier = entry["identifier"] ?: context.requestIds.lastUsedKey,
        evidence = entry["evidence"] ?: context.evidenceIds.lastUsedKey,
        name = entry["name"],
        isConformantTo = entry.extractList("isConformantTo")
    )

    private data class RequestAssertParams(
        val identifier: TestContextKey,
        val evidence: TestContextKey,
        val name: String?,
        val isConformantTo: List<TestContextKey>?,
    )
}
