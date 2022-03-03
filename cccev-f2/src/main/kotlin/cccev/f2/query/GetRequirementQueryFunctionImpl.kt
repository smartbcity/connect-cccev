package cccev.f2.query

import cccev.dsl.dto.query.GetRequirementQueryFunction
import cccev.dsl.dto.query.GetRequirementQueryResult
import ccev.dsl.core.Requirement
import ccev.dsl.core.RequirementId
import f2.dsl.fnc.f2Function
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GetRequirementQueryFunctionImpl {

    companion object {
        val AVAILABLE_REQUIREMENTS = mutableMapOf<RequirementId, Requirement>() // will be removed when requirements are stored in db
    }

    @Bean
    fun getRequirementQueryFunction(): GetRequirementQueryFunction = f2Function { query ->
        GetRequirementQueryResult(query.requirementId.toRequirement())
    }

    private fun RequirementId.toRequirement() = AVAILABLE_REQUIREMENTS[this]
}
