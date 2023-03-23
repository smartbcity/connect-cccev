package cccev.f2.request.api

import cccev.commons.utils.serveFile
import cccev.f2.request.api.service.RequestF2AggregateService
import cccev.f2.request.api.service.RequestF2FinderService
import cccev.f2.request.domain.RequestApi
import cccev.f2.request.domain.command.RequestAddEvidenceCommandDTOBase
import cccev.f2.request.domain.command.RequestAddRequirementsFunction
import cccev.f2.request.domain.command.RequestAddValuesFunction
import cccev.f2.request.domain.command.RequestCreateFunction
import cccev.f2.request.domain.command.RequestRemoveEvidenceFunction
import cccev.f2.request.domain.command.RequestRemoveRequirementsFunction
import cccev.f2.request.domain.query.RequestDownloadEvidenceQueryDTOBase
import cccev.f2.request.domain.query.RequestGetFunction
import cccev.f2.request.domain.query.RequestGetResultDTOBase
import cccev.s2.request.domain.command.RequestAddedEvidenceEvent
import city.smartb.fs.s2.file.client.FileClient
import f2.dsl.fnc.f2Function
import f2.spring.exception.NotFoundException
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.codec.multipart.FilePart
import org.springframework.http.server.reactive.ServerHttpResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import s2.spring.utils.logger.Logger

/**
 * @d2 api
 * @parent [D2RequestApiPage]
 */
@RestController
@RequestMapping
@Configuration
class RequestEndpoint(
    private val fileClient: FileClient,
    private val requestF2AggregateService: RequestF2AggregateService,
    private val requestF2FinderService: RequestF2FinderService
): RequestApi {
    private val logger by Logger()

    @Bean
    override fun requestGet(): RequestGetFunction = f2Function { query ->
        logger.info("requestGet: $query")
        requestF2FinderService.getOrNull(query.id).let(::RequestGetResultDTOBase)
    }

    /** Download an evidence of a request */
    @PostMapping("/requestDownloadEvidence")
    suspend fun requestDownloadEvidence(
        @RequestBody query: RequestDownloadEvidenceQueryDTOBase,
        response: ServerHttpResponse
    ) = response.serveFile(fileClient) {
        logger.info("requestDownloadEvidence: $query")
        val request = requestF2FinderService.get(query.id)
        val evidence = request.evidences.firstOrNull { it.id == query.evidenceId }
            ?: throw NotFoundException("Evidence", query.evidenceId)

        evidence.file
    }

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

    /** Add an evidence to a request */
    @PostMapping("/requestAddEvidence")
    suspend fun requestAddEvidence(
        @RequestPart("command") command: RequestAddEvidenceCommandDTOBase,
        @RequestPart("file", required = false) file: FilePart?,
    ): RequestAddedEvidenceEvent {
        logger.info("requestAddEvidence: $command")
        return requestF2AggregateService.addEvidence(command, file)
    }

    @Bean
    override fun requestRemoveEvidence(): RequestRemoveEvidenceFunction = f2Function { command ->
        logger.info("requestRemoveEvidence: $command")
        requestF2AggregateService.removeEvidence(command)
    }
}
