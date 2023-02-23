package features.cccev.test.entities.requirement

import cccev.dsl.model.EvidenceTypeListBase
import cccev.dsl.model.InformationConceptBase
import cccev.dsl.model.Requirement
import cccev.dsl.model.RequirementId
import cccev.s2.requirement.api.DeprecatedRequirementFinderService
import features.cccev.test.CucumberStepsDefinition
import features.cccev.test.data.DataTest
import io.cucumber.datatable.DataTable
import io.cucumber.java8.En

class RequirementInitSteps: En, CucumberStepsDefinition() {

    init {
        DataTableType { entry: Map<String, String> ->
            RequirementInitParams(
                identifier = entry["identifier"].orRandom(),
                informationConcepts = entry["informationConcepts"].orEmpty().toListOf(context.informationConcepts),
                evidenceTypeLists = entry["evidenceTypeLists"].orEmpty().toListOf(context.evidenceTypeLists),
                requirements = entry["requirements"].orEmpty().toListOf(context.requirements)
            )
        }

        Given("A requirement is created") { params: RequirementInitParams ->
            initRequirements(listOf(params))
        }

        Given("Some requirements are created") { dataTable: DataTable ->
            dataTable.asList(RequirementInitParams::class.java)
                .let(::initRequirements)
        }
    }

    private fun initRequirements(paramsList: List<RequirementInitParams>) {
        paramsList.associate { params -> params.identifier to params.toRequirement() }
            .also(context.requirements::putAll)
            // TODO remove this when requirements will be saved in db
            .also(DeprecatedRequirementFinderService.AVAILABLE_REQUIREMENTS::putAll)
    }

    private fun RequirementInitParams.toRequirement() = DataTest.informationRequirement(
        identifier = identifier,
        hasConcept = informationConcepts,
        hasEvidenceTypeList = evidenceTypeLists,
        hasRequirement = requirements
    )

    private data class RequirementInitParams(
        val identifier: RequirementId,
        val informationConcepts: List<InformationConceptBase>,
        val evidenceTypeLists: List<EvidenceTypeListBase>,
        val requirements: List<Requirement>
    )
}
