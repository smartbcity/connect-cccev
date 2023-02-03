package features.cccev.s2.request.tasks.handler

import cccev.core.dsl.RequirementId
import cccev.core.dsl.SupportedValue
import cccev.f2.concept.domain.features.query.GetInformationConceptsQuery
import cccev.f2.concept.domain.features.query.GetInformationConceptsQueryFunction
import cccev.s2.request.api.RequestAggregateService
import cccev.s2.request.api.entity.RequestEntity
import cccev.s2.request.domain.RequestState
import cccev.s2.request.domain.features.command.RequestSupportedValueAddCommand
import cccev.s2.request.domain.model.RequestId
import cccev.s2.requirement.api.RequirementFinderService
import f2.dsl.fnc.invoke
import io.cucumber.datatable.DataTable
import io.cucumber.java8.En
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions
import org.awaitility.Awaitility
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import java.util.UUID

class ComputeExpectedValuesHandlerSteps: En {

    @Autowired
    private lateinit var mongoTemplate: MongoTemplate
    @Autowired
    private lateinit var getInformationConceptsFunction: GetInformationConceptsQueryFunction
    @Autowired
    private lateinit var requestAggregateService: RequestAggregateService
    @Autowired
    private lateinit var requirementFinderService: RequirementFinderService

    private lateinit var frameworkId: RequirementId
    private lateinit var requestId: RequestId

    init {
        DataTableType { entry: Map<String, String> ->
            runBlocking {
                val query = GetInformationConceptsQuery(requestId, frameworkId, null)
                val infoConcept = getInformationConceptsFunction.invoke(query)
                    .informationConcepts
                    .firstOrNull { concept -> concept.name == entry["name"] }

                Assertions.assertThat(infoConcept).isNotNull

                SupportedValue(
                    identifier = UUID.randomUUID().toString(),
                    value = entry["value"],
                    providesValueFor = infoConcept!!.identifier
                )
            }
        }

        Given("The framework {string} is instantiated") { framework: RequirementId ->
            runBlocking {
                val requirement = requirementFinderService.get(framework)
                Assertions.assertThat(requirement?.identifier).isNotNull
                frameworkId = requirement!!.identifier!!
            }
        }

        Given("A request is instantiated on this framework") {
            val request = RequestEntity(
                frameworkId = frameworkId,
                status = RequestState.Created,
                evidences = mutableListOf(),
                supportedValues = mutableMapOf()
            )
            requestId = request.id
            mongoTemplate.save(request)
        }

        When("Some supported values are added") { dataTable: DataTable ->
            val supportedValues = dataTable.asList(SupportedValue::class.java)
            runBlocking {
                supportedValues.forEach { value ->
                    val command = RequestSupportedValueAddCommand(
                        id = requestId,
                        supportedValue = value
                    )
                    requestAggregateService.addSupportedValue(command)
                }
            }
        }

        Then("The value of the information concept is computed") { expectedValue: SupportedValue ->
            Awaitility.await().untilAsserted {
                val request = mongoTemplate.findById(requestId, RequestEntity::class.java)!!
                val computedValue = request.supportedValues[expectedValue.providesValueFor]

                Assertions.assertThat(computedValue).isNotNull
                Assertions.assertThat(computedValue!!.value).isEqualTo(expectedValue.value)
            }
        }
    }
}
