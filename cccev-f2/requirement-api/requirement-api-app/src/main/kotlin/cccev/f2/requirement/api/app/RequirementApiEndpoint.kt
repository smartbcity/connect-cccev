package cccev.f2.requirement.api.app

import cccev.f2.requirement.api.domain.features.query.GetRequirementQueryFunction
import cccev.f2.requirement.api.domain.features.query.GetRequirementQueryResult
import cccev.s2.requirement.app.RequirementFinderService
import f2.dsl.fnc.f2Function
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RequirementApiEndpoint(
    private val requirementFinderService: RequirementFinderService
) {

    @Bean
    fun getRequirement(): GetRequirementQueryFunction = f2Function { query ->
        requirementFinderService.get(query.requirementId).let(::GetRequirementQueryResult)
    }
}
