package cccev.f2.evidence.type.api

import cccev.f2.evidence.type.api.service.EvidenceTypeF2AggregateService
import cccev.f2.evidence.type.api.service.EvidenceTypeF2FinderService
import cccev.f2.evidence.type.domain.D2EvidenceTypeF2Page
import cccev.f2.evidence.type.domain.command.list.EvidenceTypeListCreateFunction
import cccev.f2.evidence.type.domain.command.list.EvidenceTypeListUpdateFunction
import cccev.f2.evidence.type.domain.command.type.EvidenceTypeCreateFunction
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
) {
    private val logger by Logger()

    @Bean
    fun evidenceTypeCreate(): EvidenceTypeCreateFunction = f2Function { command ->
        logger.info("evidenceTypeCreate: $command")
        evidenceTypeF2AggregateService.create(command)
    }

    @Bean
    fun evidenceTypeListCreate(): EvidenceTypeListCreateFunction = f2Function { command ->
        logger.info("evidenceTypeListCreate: $command")
        evidenceTypeF2AggregateService.createList(command)
    }

    @Bean
    fun evidenceTypeListUpdate(): EvidenceTypeListUpdateFunction = f2Function { command ->
        logger.info("evidenceTypeListUpdate: $command")
        evidenceTypeF2AggregateService.updateList(command)
    }
}
