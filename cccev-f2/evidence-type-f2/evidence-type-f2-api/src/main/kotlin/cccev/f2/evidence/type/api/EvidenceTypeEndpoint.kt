package cccev.f2.evidence.type.api

import cccev.f2.evidence.type.api.service.EvidenceTypeF2AggregateService
import cccev.f2.evidence.type.api.service.EvidenceTypeF2FinderService
import cccev.f2.evidence.type.domain.D2EvidenceTypeF2Page
import cccev.f2.evidence.type.domain.EvidenceTypeApi
import cccev.f2.evidence.type.domain.command.list.EvidenceTypeListCreateFunction
import cccev.f2.evidence.type.domain.command.list.EvidenceTypeListUpdateFunction
import cccev.f2.evidence.type.domain.command.type.EvidenceTypeCreateFunction
import cccev.f2.evidence.type.domain.query.EvidenceTypeGetByIdentifierFunction
import cccev.f2.evidence.type.domain.query.EvidenceTypeGetFunction
import cccev.f2.evidence.type.domain.query.EvidenceTypeGetResultDTOBase
import cccev.f2.evidence.type.domain.query.EvidenceTypeGetByIdentifierResultDTOBase
import cccev.f2.evidence.type.domain.query.EvidenceTypeListGetByIdentifierFunction
import cccev.f2.evidence.type.domain.query.EvidenceTypeListGetByIdentifierResultDTOBase
import cccev.f2.evidence.type.domain.query.EvidenceTypeListGetFunction
import cccev.f2.evidence.type.domain.query.EvidenceTypeListGetResultDTOBase
import f2.dsl.fnc.f2Function
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import s2.spring.utils.logger.Logger

/**
 * @d2 service
 * @parent [D2EvidenceTypeF2Page]
 */
@Configuration
class EvidenceTypeEndpoint(
    private val evidenceTypeF2AggregateService: EvidenceTypeF2AggregateService,
    private val evidenceTypeF2FinderService: EvidenceTypeF2FinderService
): EvidenceTypeApi {
    private val logger by Logger()

    @Bean
    override fun evidenceTypeCreate(): EvidenceTypeCreateFunction = f2Function { command ->
        logger.info("evidenceTypeCreate: $command")
        evidenceTypeF2AggregateService.create(command)
    }

    @Bean
    override fun evidenceTypeListCreate(): EvidenceTypeListCreateFunction = f2Function { command ->
        logger.info("evidenceTypeListCreate: $command")
        evidenceTypeF2AggregateService.createList(command)
    }

    @Bean
    override fun evidenceTypeListUpdate(): EvidenceTypeListUpdateFunction = f2Function { command ->
        logger.info("evidenceTypeListUpdate: $command")
        evidenceTypeF2AggregateService.updateList(command)
    }

    @Bean
    override fun evidenceTypeGet(): EvidenceTypeGetFunction = f2Function { command ->
        logger.info("evidenceTypeGet: $command")
        evidenceTypeF2FinderService.getOrNull(command.id).let (::EvidenceTypeGetResultDTOBase)
    }

    @Bean
    override fun evidenceTypeGetByIdentifier(): EvidenceTypeGetByIdentifierFunction = f2Function { command ->
        logger.info("evidenceTypeGetByIdentifier: $command")
        evidenceTypeF2FinderService.getOrNullByIdentifier(command.identifier).let (::EvidenceTypeGetByIdentifierResultDTOBase)
    }

    @Bean
    override fun evidenceTypeListGet(): EvidenceTypeListGetFunction = f2Function { command ->
        logger.info("evidenceTypeListGet: $command")
        evidenceTypeF2FinderService.getListOrNull(command.id).let (::EvidenceTypeListGetResultDTOBase)
    }

    @Bean
    override fun evidenceTypeListGetByIdentifier(): EvidenceTypeListGetByIdentifierFunction = f2Function { command ->
        logger.info("evidenceTypeListGetByIdentifier: $command")
        evidenceTypeF2FinderService.getListOrNullByIdentifier(command.identifier).let (::EvidenceTypeListGetByIdentifierResultDTOBase)
    }

}
