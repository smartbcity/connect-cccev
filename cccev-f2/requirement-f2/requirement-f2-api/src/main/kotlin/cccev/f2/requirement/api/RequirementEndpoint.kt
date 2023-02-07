package cccev.f2.requirement.api

import cccev.f2.requirement.api.service.RequirementF2AggregateService
import cccev.f2.requirement.api.service.RequirementF2FinderService
import cccev.f2.requirement.domain.RequirementApi
import cccev.f2.requirement.domain.command.ConstraintCreateFunction
import cccev.f2.requirement.domain.command.CriterionCreateFunction
import cccev.f2.requirement.domain.command.InformationRequirementCreateFunction
import cccev.f2.requirement.domain.command.RequirementUpdateFunction
import cccev.f2.requirement.domain.query.GetRequirementListQueryFunction
import cccev.f2.requirement.domain.query.GetRequirementListQueryResult
import cccev.f2.requirement.domain.query.GetRequirementQueryFunction
import cccev.f2.requirement.domain.query.GetRequirementQueryResult
import cccev.f2.requirement.domain.query.RequirementGetFunction
import cccev.f2.requirement.domain.query.RequirementGetResultDTOBase
import cccev.s2.requirement.api.DeprecatedRequirementFinderService
import f2.dsl.fnc.f2Function
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import s2.spring.utils.logger.Logger

@Configuration
class RequirementEndpoint(
    private val requirementF2AggregateService: RequirementF2AggregateService,
    private val requirementF2FinderService: RequirementF2FinderService,
    private val deprecatedRequirementFinderService: DeprecatedRequirementFinderService
): RequirementApi {
    private val logger by Logger()

    @Bean
    override fun requirementGet(): RequirementGetFunction = f2Function { query ->
        logger.info("requirementGet: $query")
        requirementF2FinderService.getOrNull(query.id).let(::RequirementGetResultDTOBase)
    }

    @Bean
    override fun getRequirement(): GetRequirementQueryFunction = f2Function { query ->
        deprecatedRequirementFinderService.get(query.requirementId).let(::GetRequirementQueryResult)
    }

    @Bean
    override fun getRequirements(): GetRequirementListQueryFunction = f2Function { query ->
        deprecatedRequirementFinderService.list(
            parent = query.parentId,
            concept = query.conceptId,
            evidenceType = query.evidenceTypeId
        ).let(::GetRequirementListQueryResult)
    }

    @Bean
    override fun constraintCreate(): ConstraintCreateFunction = f2Function { command ->
        logger.info("constraintCreate: $command")
        requirementF2AggregateService.create(command)
    }

    @Bean
    override fun criterionCreate(): CriterionCreateFunction = f2Function { command ->
        logger.info("criterionCreate: $command")
        requirementF2AggregateService.create(command)
    }

    @Bean
    override fun informationRequirementCreate(): InformationRequirementCreateFunction = f2Function { command ->
        logger.info("informationRequirementCreate: $command")
        requirementF2AggregateService.create(command)
    }

    @Bean
    override fun requirementUpdate(): RequirementUpdateFunction = f2Function { command ->
        logger.info("requirementCreate: $command")
        requirementF2AggregateService.update(command)
    }
}
