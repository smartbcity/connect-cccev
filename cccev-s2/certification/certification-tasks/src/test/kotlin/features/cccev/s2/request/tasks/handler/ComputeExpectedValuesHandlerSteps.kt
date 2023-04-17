//package features.cccev.s2.request.tasks.handler
//
//import cccev.dsl.model.RequirementId
//import cccev.dsl.model.SupportedValue
//import cccev.f2.concept.domain.query.GetInformationConceptsQuery
//import cccev.f2.concept.domain.query.GetInformationConceptsQueryFunction
//import cccev.projection.api.entity.request.RequestEntity
//import cccev.projection.api.entity.request.RequestRepository
//import cccev.s2.request.api.RequestAggregateService
//import cccev.s2.request.domain.RequestState
//import cccev.s2.request.domain.model.RequestId
//import cccev.s2.requirement.api.RequirementFinderService
//import f2.dsl.fnc.invoke
//import io.cucumber.datatable.DataTable
//import io.cucumber.java8.En
//import kotlinx.coroutines.runBlocking
//import org.assertj.core.api.Assertions
//import org.awaitility.Awaitility
//import org.springframework.beans.factory.annotation.Autowired
//import java.util.UUID
//import kotlinx.coroutines.reactor.awaitSingle
//import kotlinx.coroutines.reactor.awaitSingleOrNull
//
//class ComputeExpectedValuesHandlerSteps: En {
//
//    @Autowired
//    private lateinit var requestRepository: RequestRepository
//    @Autowired
//    private lateinit var getInformationConceptsFunction: GetInformationConceptsQueryFunction
//    @Autowired
//    private lateinit var requestAggregateService: RequestAggregateService
//    @Autowired
//    private lateinit var requirementFinderService: RequirementFinderService
//
//    private lateinit var frameworkId: RequirementId
//    private lateinit var requestId: RequestId
//
//    init {
//        DataTableType { entry: Map<String, String> ->
//            runBlocking {
//                val query = GetInformationConceptsQuery(requestId, frameworkId, null)
//                val infoConcept = getInformationConceptsFunction.invoke(query)
//                    .informationConcepts
//                    .firstOrNull { concept -> concept.name == entry["name"] }
//
//                Assertions.assertThat(infoConcept).isNotNull
//
//                SupportedValue(
//                    identifier = UUID.randomUUID().toString(),
//                    value = entry["value"],
//                    providesValueFor = infoConcept!!.identifier
//                )
//            }
//        }
//
//        Given("The framework {string} is instantiated") { framework: RequirementId ->
//            runBlocking {
//                val requirement = requirementFinderService.get(framework)
//                Assertions.assertThat(requirement?.identifier).isNotNull
//                frameworkId = requirement!!.identifier!!
//            }
//        }
//
//        Given("A request is instantiated on this framework") {
//            val request = RequestEntity().apply {
//                frameworkId = frameworkId
//                status = RequestState.CREATED
//                evidences = mutableListOf()
////                supportedValues = mutableMapOf()
//            }
//            requestId = request.id
//            runBlocking {
//                requestRepository.save(request).awaitSingle()
//            }
//        }
//
//        When("Some supported values are added") { dataTable: DataTable ->
//            val supportedValues = dataTable.asList(SupportedValue::class.java)
//            runBlocking {
//                supportedValues.forEach { value ->
//                    val command = RequestSupportedValueAddCommand(
//                        id = requestId,
//                        supportedValue = value
//                    )
//                    requestAggregateService.addSupportedValue(command)
//                }
//            }
//        }
//
//        Then("The value of the information concept is computed") { expectedValue: SupportedValue ->
//            Awaitility.await().untilAsserted {
//                runBlocking {
//                    val request = requestRepository.findById(requestId).awaitSingleOrNull()
//
//                    Assertions.assertThat(request).isNotNull
//
//                    val computedValue = request!!.toRequest().supportedValues[expectedValue.providesValueFor]
//                    Assertions.assertThat(computedValue!!.value).isEqualTo(expectedValue.value)
//                }
//            }
//        }
//    }
//}
