package cccev.f2.evidence.api.app

import cccev.core.dsl.EvidenceTypeId
import cccev.core.dsl.EvidenceTypeListId
import cccev.f2.evidence.api.app.model.toEvidenceTypeListChoices
import cccev.f2.evidence.api.app.service.EvidenceApiFinderService
import cccev.f2.evidence.api.domain.features.query.GetEvidenceTypeListsQueryFunction
import cccev.f2.evidence.api.domain.features.query.GetEvidenceTypeListsQueryResult
import cccev.f2.evidence.api.domain.model.EvidenceTypeListDTO
import cccev.f2.evidence.api.domain.model.EvidenceTypeListDTOBase
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
        val evidenceTypeLists = evidenceApiFinderService.getEvidenceTypeLists(
            requestId = query.id,
            requirementId = query.requirement,
            conceptId = query.concept,
            evidenceTypeId = query.evidenceType
        )

        GetEvidenceTypeListsQueryResult(
            evidenceTypeListMap = evidenceTypeLists.flatten().associateBy(EvidenceTypeListDTOBase::identifier),
            evidenceTypeListsOfEvidenceTypes = evidenceTypeLists.flatten().flatMap { evidenceTypeList ->
                evidenceTypeList.specifiesEvidenceType.map { evidenceType -> evidenceType.identifier to evidenceTypeList.identifier }
            }.groupBy(Pair<EvidenceTypeId, EvidenceTypeListId>::first, Pair<EvidenceTypeId, EvidenceTypeListId>::second),
            evidenceTypeLists = evidenceTypeLists.map(List<EvidenceTypeListDTO>::toEvidenceTypeListChoices)
        )
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
