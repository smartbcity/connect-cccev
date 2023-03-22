package cccev.f2.request.api

import cccev.f2.request.api.service.RequestF2AggregateService
import cccev.f2.request.api.service.RequestF2FinderService
import cccev.f2.request.domain.RequestCommandApi
import cccev.f2.request.domain.RequestQueryApi
import cccev.f2.request.domain.command.RequestAddEvidenceFunction
import cccev.f2.request.domain.command.RequestAddRequirementsFunction
import cccev.f2.request.domain.command.RequestAddValuesFunction
import cccev.f2.request.domain.command.RequestCreateFunction
import cccev.f2.request.domain.command.RequestRemoveEvidenceFunction
import cccev.f2.request.domain.command.RequestRemoveRequirementsFunction
import f2.dsl.fnc.f2Function
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import s2.spring.utils.logger.Logger

@Configuration
class RequestEndpoint(
    private val requestF2AggregateService: RequestF2AggregateService,
    private val requestF2FinderService: RequestF2FinderService
): RequestCommandApi, RequestQueryApi {
    private val logger by Logger()

    @Bean
    override fun requestCreate(): RequestCreateFunction = f2Function { command ->
        logger.info("requestCreate: $command")
        requestF2AggregateService.create(command)
    }

    @Bean
    override fun requestAddRequirements(): RequestAddRequirementsFunction = f2Function { command ->
        logger.info("requestAddRequirements: $command")
        requestF2AggregateService.addRequirements(command)
    }

    @Bean
    override fun requestRemoveRequirements(): RequestRemoveRequirementsFunction = f2Function { command ->
        logger.info("requestRemoveRequirements: $command")
        requestF2AggregateService.removeRequirements(command)
    }

    @Bean
    override fun requestAddValues(): RequestAddValuesFunction = f2Function { command ->
        logger.info("requestAddValues: $command")
        requestF2AggregateService.addValues(command)
    }

    @Bean
    override fun requestAddEvidence(): RequestAddEvidenceFunction = f2Function { command ->
        logger.info("requestAddEvidence: $command")
        requestF2AggregateService.addEvidence(command)
    }

    @Bean
    override fun requestRemoveEvidence(): RequestRemoveEvidenceFunction = f2Function { command ->
        logger.info("requestRemoveEvidence: $command")
        requestF2AggregateService.removeEvidence(command)
    }
}
