package features.cccev.test.entities.supportedvalue

import cccev.dsl.model.InformationConceptId
import cccev.dsl.model.SupportedValueId
import cccev.s2.request.api.RequestAggregateService
import cccev.s2.request.domain.features.command.RequestSupportedValueAddCommand
import cccev.s2.request.domain.model.RequestId
import features.cccev.test.CucumberStepsDefinition
import features.cccev.test.data.DataTest
import s2.bdd.exception.EntityNotInitializedException
import io.cucumber.datatable.DataTable
import io.cucumber.java8.En
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Autowired

class SupportedValueSteps: En, CucumberStepsDefinition() {

    @Autowired
    private lateinit var requestAggregateService: RequestAggregateService

    init {
        DataTableType { entry: Map<String, String> ->
            SupportedValueInitParams(
                requestId = entry["request"],
                identifier = entry["identifier"].orRandom(),
                value = entry["value"],
                informationConcept = entry.safeExtract("informationConcept")
            )
        }

        When("Some supported values are added to this request") { dataTable: DataTable ->
            val lastRequestId = context.requests.lastCreated
                ?: throw EntityNotInitializedException("lastCreated", "Request")

            val paramList = dataTable.asList(SupportedValueInitParams::class.java)
                .map { params -> params.copy(requestId = lastRequestId) }

            initSupportedValues(paramList)
        }
    }

    private fun initSupportedValues(paramsList: List<SupportedValueInitParams>) = runBlocking {
        paramsList.map { params ->
            RequestSupportedValueAddCommand(
                id = params.requestId!!,
                supportedValue = params.toSupportedValue()
            )
        }.forEach { command ->
            requestAggregateService.addSupportedValue(command)
        }
    }

    private fun SupportedValueInitParams.toSupportedValue() = DataTest.supportedValue(
        identifier = identifier,
        value = value,
        providesValueFor = informationConcept
    )

    private data class SupportedValueInitParams(
        val identifier: SupportedValueId,
        val requestId: RequestId?,
        val informationConcept: InformationConceptId,
        val value: String?
    )
}
