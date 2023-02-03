package cccev.f2.concept.api

import cccev.f2.concept.api.service.ConceptApiFinderService
import cccev.f2.concept.domain.ConceptQueryApi
import cccev.f2.concept.domain.features.query.GetInformationConceptsQueryFunction
import cccev.f2.concept.domain.features.query.GetInformationConceptsQueryResult
import f2.dsl.fnc.f2Function
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import s2.spring.utils.logger.Logger

@Configuration
class ConceptApiEndpoint(
    private val conceptApiFinderService: ConceptApiFinderService
): ConceptQueryApi {
    private val logger by Logger()

    @Bean
    override fun getInformationConcepts(): GetInformationConceptsQueryFunction = f2Function { query ->
        logger.info("Request [${query.id}]: GetInformationConcepts")
        conceptApiFinderService.getInformationConcepts(
            requestId = query.id,
            requirementId = query.requirement,
            evidenceTypeId = query.evidenceType
        ).let(::GetInformationConceptsQueryResult)
    }
}
