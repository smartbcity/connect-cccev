package cccev.f2.framework.api

import cccev.f2.framework.api.service.FrameworkF2AggregateService
import cccev.f2.framework.api.service.FrameworkF2FinderService
import cccev.f2.framework.domain.FrameworkApi
import cccev.f2.framework.domain.command.FrameworkCreateFunction
import cccev.f2.framework.domain.query.FrameworkGetFunction
import cccev.f2.framework.domain.query.FrameworkGetResultDTOBase
import f2.dsl.fnc.f2Function
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import s2.spring.utils.logger.Logger

/**
 * @d2 api
 */
@Configuration
class FrameworkEndpoint(
    private val frameworkF2AggregateService: FrameworkF2AggregateService,
    private val frameworkF2FinderService: FrameworkF2FinderService
): FrameworkApi {
    private val logger by Logger()

    @Bean
    override fun frameworkGet(): FrameworkGetFunction = f2Function { query ->
        logger.info("frameworkGet: $query")
        frameworkF2FinderService.getOrNull(query.id).let(::FrameworkGetResultDTOBase)
    }

    @Bean
    override fun frameworkCreate(): FrameworkCreateFunction = f2Function { command ->
        logger.info("frameworkCreate: $command")
        frameworkF2AggregateService.create(command)
    }
}
