//package cccev.s2.request.tasks.handler
//
//import cccev.commons.EventHandler
//import cccev.dsl.model.InformationConcept
//import cccev.dsl.model.SupportedValue
//import cccev.f2.concept.domain.query.GetInformationConceptsQuery
//import cccev.f2.concept.domain.query.GetInformationConceptsQueryFunction
//import cccev.projection.api.entity.request.RequestEntity
//import cccev.projection.api.entity.request.RequestRepository
//import cccev.projection.api.entity.request.toRequest
//import cccev.s2.request.api.RequestAggregateService
//import cccev.s2.request.domain.features.command.RequestSupportedValueAddCommand
//import cccev.s2.request.domain.features.command.RequestSupportedValueAddedEvent
//import f2.dsl.fnc.invoke
//import org.springframework.context.event.EventListener
//import org.springframework.stereotype.Component
//import java.util.UUID
//import javax.script.ScriptEngineManager
//import kotlinx.coroutines.reactor.awaitSingleOrNull
//
//@Component
//class ComputeExpectedValuesHandler(
//    private val getInformationConceptsQueryFunction: GetInformationConceptsQueryFunction,
//    private val requestRepository: RequestRepository,
//    private val requestAggregateService: RequestAggregateService
//): EventHandler() {
//
//    @EventListener
//    fun onSupportedValueAdded(event: RequestSupportedValueAddedEvent) = handleEvent(
//        "ComputeExpectedValuesHandler - onSupportedValueAdded - Request[${event.id}] " +
//                "InformationConcept[${event.supportedValue.providesValueFor}]"
//    ) {
//        val requestId = event.id
//        val supportedInfoConceptId = event.supportedValue.providesValueFor
//
//        val request = requestRepository.findById(requestId).awaitSingleOrNull()
//            ?: throw IllegalStateException("Request[$requestId] not found")
//
//        val query = GetInformationConceptsQuery(id = requestId, requirement = request.frameworkId)
//        val infoConcepts = getInformationConceptsQueryFunction.invoke(query).informationConcepts
//
//        val infoConceptsDependingOnNewValue = infoConcepts.filter { infoConcept ->
//            supportedInfoConceptId in infoConcept.dependsOn
//        }
//
//        infoConceptsDependingOnNewValue.filter { infoConcept ->
//            request.toRequest().supportedValues.keys.containsAll(infoConcept.dependsOn)
//        }.mapNotNull { infoConcept ->
//            infoConcept.computeSupportedValue(request)
//        }.map { value ->
//            RequestSupportedValueAddCommand(
//                id = requestId,
//                supportedValue = value
//            )
//        }.forEach { command ->
//            requestAggregateService.addSupportedValue(command)
//        }
//    }
//
//    private fun InformationConcept.computeSupportedValue(request: RequestEntity): SupportedValue? {
//        if (!everyDependenciesSatisfied(request)) return null
//
//        val engine = ScriptEngineManager().getEngineByName("kotlin")
//        dependsOn.forEach { infoConceptId ->
//            engine.eval("val `$infoConceptId` = ${request.toRequest().supportedValues[infoConceptId]!!.value}")
//        }
//
//        val value = engine.eval(expressionOfExpectedValue).toString()
//        return SupportedValue(
//            identifier = UUID.randomUUID().toString(),
//            value = value,
//            providesValueFor = identifier
//        )
//    }
//
//    private fun InformationConcept.everyDependenciesSatisfied(request: RequestEntity): Boolean {
//        return dependsOn.all { infoConceptId -> infoConceptId in request.toRequest().supportedValues.keys }
//    }
//}
