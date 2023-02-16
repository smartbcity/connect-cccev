package cccev.f2.unit.api

import cccev.f2.unit.api.service.DataUnitF2AggregateService
import cccev.f2.unit.api.service.DataUnitF2FinderService
import cccev.f2.unit.domain.D2DataUnitF2Page
import cccev.f2.unit.domain.command.DataUnitCreateFunction
import cccev.f2.unit.domain.query.DataUnitGetFunction
import cccev.f2.unit.domain.query.DataUnitGetResultDTOBase
import f2.dsl.fnc.f2Function
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import s2.spring.utils.logger.Logger

/**
 * @d2 service
 * @parent [D2DataUnitF2Page]
 */
@Configuration
class DataUnitEndpoint(
    private val dataUnitF2AggregateService: DataUnitF2AggregateService,
    private val dataUnitF2FinderService: DataUnitF2FinderService
) {
    private val logger by Logger()

    @Bean
    fun dataUnitGet(): DataUnitGetFunction = f2Function { query ->
        logger.info("dataUnitGet: $query")
        dataUnitF2FinderService.getOrNull(query.id).let(::DataUnitGetResultDTOBase)
    }

    @Bean
    fun dataUnitCreate(): DataUnitCreateFunction = f2Function { command ->
        logger.info("dataUnitCreate: $command")
        dataUnitF2AggregateService.create(command)
    }
}
