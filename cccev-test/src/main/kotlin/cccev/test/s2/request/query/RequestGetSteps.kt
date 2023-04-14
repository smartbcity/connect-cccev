package cccev.test.s2.request.query

import cccev.projection.api.entity.request.RequestRepository
import cccev.s2.request.api.RequestFinderService
import cccev.test.CccevCucumberStepsDefinition
import io.cucumber.datatable.DataTable
import io.cucumber.java8.En
import org.assertj.core.api.Assertions
import org.springframework.beans.factory.annotation.Autowired
import s2.bdd.data.TestContextKey
import s2.bdd.data.parser.safeExtract

class RequestGetSteps: En, CccevCucumberStepsDefinition() {

    @Autowired
    private lateinit var requestFinderService: RequestFinderService

    @Autowired
    private lateinit var requestRepository: RequestRepository

    init {
        DataTableType(::requestGetParams)
        DataTableType(::requirementStatsAssertParams)

        When("I fetch the request") {
            step {
                fetchRequest(requestGetParams(null))
            }
        }

        When("I fetch the request:") { params: RequestGetParams ->
            step {
                fetchRequest(params)
            }
        }

        Then("I should receive the requirement stats of the request:") { dataTable: DataTable ->
            val params = dataTable.asList(RequirementStatsAssertParams::class.java)
            val request = context.fetched.request
            params.forEach { param ->
                val requirementId = context.requirementIds.safeGet(param.requirement)
                val stats = request.requirementStats[requirementId]
                Assertions.assertThat(stats).isNotNull
                Assertions.assertThat(stats!!.completion).isEqualTo(param.completion)
            }
        }
    }

    private suspend fun fetchRequest(params: RequestGetParams) {
        context.fetched.request = requestFinderService.get(context.requestIds[params.identifier] ?: params.identifier)
    }

    private fun requestGetParams(entry: Map<String, String>?) = RequestGetParams(
        identifier = entry?.get("identifier") ?: context.requestIds.lastUsedKey
    )

    private data class RequestGetParams(
        val identifier: TestContextKey
    )

    private fun requirementStatsAssertParams(entry: Map<String, String>) = RequirementStatsAssertParams(
        requirement = entry.safeExtract("requirement"),
        completion = entry.safeExtract("completion").toDouble()
    )

    private data class RequirementStatsAssertParams(
        val requirement: TestContextKey,
        val completion: Double
    )
}
