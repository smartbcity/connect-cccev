package cccev.f2.requirement.api.app

import cccev.f2.requirement.api.domain.RequirementApi
import cccev.f2.requirement.api.domain.features.query.GetRequirementListQueryFunction
import cccev.f2.requirement.api.domain.features.query.GetRequirementListQueryResult
import cccev.f2.requirement.api.domain.features.query.GetRequirementQueryFunction
import cccev.f2.requirement.api.domain.features.query.GetRequirementQueryResult
import cccev.s2.requirement.app.RequirementFinderService
import f2.dsl.fnc.f2Function
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RequirementApiEndpoint(
    private val requirementFinderService: RequirementFinderService
): RequirementApi {

    @Bean
    override fun getRequirement(): GetRequirementQueryFunction = f2Function { query ->
        requirementFinderService.get(query.requirementId).let(::GetRequirementQueryResult)
    }

    @Bean
    override fun getRequirements(): GetRequirementListQueryFunction = f2Function { query ->
        requirementFinderService.list(
            parent = query.parentId,
            concept = query.conceptId,
            evidenceType = query.evidenceTypeId
        ).let(::GetRequirementListQueryResult)
    }
}
