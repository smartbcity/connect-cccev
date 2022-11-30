package cccev.f2.request.api.app

import cccev.f2.request.api.app.service.RequestApiFinderService
import cccev.f2.request.api.domain.features.RequestCommandApi
import cccev.f2.request.api.domain.features.RequestQueryApi
import cccev.f2.request.api.domain.features.command.RequestAuditCommandFunction
import cccev.f2.request.api.domain.features.command.RequestEvidenceAddCommandFunction
import cccev.f2.request.api.domain.features.command.RequestEvidenceRemoveCommandFunction
import cccev.f2.request.api.domain.features.command.RequestInitCommandFunction
import cccev.f2.request.api.domain.features.command.RequestRefuseCommandFunction
import cccev.f2.request.api.domain.features.command.RequestSendCommandFunction
import cccev.f2.request.api.domain.features.command.RequestSignCommandFunction
import cccev.f2.request.api.domain.features.command.RequestSupportedValueAddCommandFunction
import cccev.f2.request.api.domain.features.query.GetRequestScoreQueryFunction
import cccev.s2.request.app.RequestAggregateService
import f2.dsl.fnc.f2Function
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import s2.spring.utils.logger.Logger

@Configuration
class RequestApiEndpoint(
    private val requestAggregateService: RequestAggregateService,
    private val requestApiFinderService: RequestApiFinderService
): RequestCommandApi, RequestQueryApi {
    private val logger by Logger()

    @Bean
    override fun initRequest(): RequestInitCommandFunction = f2Function { cmd ->
        logger.info("Request [${cmd.id}]: init")
        requestAggregateService.init(cmd)
    }

    @Bean
    override fun addEvidence(): RequestEvidenceAddCommandFunction = f2Function { cmd ->
        logger.info("Request [${cmd.id}]: addEvidence")
        requestAggregateService.addEvidence(cmd)
    }

    @Bean
    override fun removeEvidence(): RequestEvidenceRemoveCommandFunction = f2Function { cmd ->
        logger.info("Request [${cmd.id}]: removeEvidence")
        requestAggregateService.removeEvidence(cmd)
    }

    @Bean
    override fun addSupportedValue(): RequestSupportedValueAddCommandFunction = f2Function { cmd ->
        logger.info("Request [${cmd.id}]: addSupportedValue")
        requestAggregateService.addSupportedValue(cmd)
    }

    @Bean
    override fun sendRequest(): RequestSendCommandFunction = f2Function { cmd ->
        logger.info("Request [${cmd.id}]: send")
        requestAggregateService.send(cmd)
    }

    @Bean
    override fun signRequest(): RequestSignCommandFunction = f2Function { cmd ->
        logger.info("Request [${cmd.id}]: sign")
        requestAggregateService.sign(cmd)
    }

    @Bean
    override fun auditRequest(): RequestAuditCommandFunction = f2Function { cmd ->
        logger.info("Request [${cmd.id}]: audit")
        requestAggregateService.audit(cmd)
    }

    @Bean
    override fun refuseRequest(): RequestRefuseCommandFunction = f2Function { cmd ->
        logger.info("Request [${cmd.id}]: refuse")
        requestAggregateService.refuse(cmd)
    }

    @Bean
    override fun getRequestScore(): GetRequestScoreQueryFunction = f2Function { query ->
        logger.info("Request [${query.requestId}]: get score")
        requestApiFinderService.getRequestScore(query.requestId)
    }
}
