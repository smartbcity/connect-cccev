package cccev.f2.evidence.api.app

import cccev.f2.evidence.api.app.service.EvidenceApiFinderService
import cccev.f2.evidence.api.domain.features.query.GetEvidenceTypeListsQueryFunction
import cccev.f2.evidence.api.domain.features.query.GetEvidenceTypeListsQueryResult
import f2.dsl.fnc.f2Function
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import s2.spring.utils.logger.Logger

@Configuration
class EvidenceApiEndpoint(
    private val evidenceApiFinderService: EvidenceApiFinderService
) {
    private val logger by Logger()

    @Bean
    fun getEvidenceTypeLists(): GetEvidenceTypeListsQueryFunction = f2Function { query ->
        logger.info("Request [${query.id}]: GetEvidenceTypeLists")
        evidenceApiFinderService.getEvidenceTypeLists(query.id, query.requirement)
            .let(::GetEvidenceTypeListsQueryResult)
    }

}

//fun fcn(): List<List<EvidenceTypeList>> {
//    return listOf(
//        listOf(
//            ETL1,
//            // OR
//            ETL2
//        ),
//        // AND
//        listOf(ETL3),
//        // AND
//        listOf(ETL4),
//    )
//}
