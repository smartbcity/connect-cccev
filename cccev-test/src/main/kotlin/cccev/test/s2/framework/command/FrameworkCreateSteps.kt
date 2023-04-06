package cccev.test.s2.framework.command

import cccev.projection.api.entity.framework.FrameworkRepository
import cccev.s2.framework.api.FrameworkAggregateService
import cccev.s2.framework.domain.FrameworkState
import cccev.s2.framework.domain.command.FrameworkCreateCommand
import cccev.test.CccevCucumberStepsDefinition
import cccev.test.s2.framework.data.framework
import io.cucumber.datatable.DataTable
import io.cucumber.java8.En
import kotlinx.coroutines.reactor.awaitSingleOrNull
import net.datafaker.Faker
import org.assertj.core.api.Assertions
import org.springframework.beans.factory.annotation.Autowired
import s2.bdd.assertion.AssertionBdd
import s2.bdd.data.TestContextKey

class FrameworkCreateSteps: En, CccevCucumberStepsDefinition() {

    @Autowired
    private lateinit var frameworkAggregateService: FrameworkAggregateService

    @Autowired
    private lateinit var frameworkRepository: FrameworkRepository

    private lateinit var command: FrameworkCreateCommand

    init {
        DataTableType(::frameworkCreateParams)
        DataTableType(::frameworkAssertParams)

        When("I create a framework") {
            step {
                createFramework(frameworkCreateParams(null))
            }
        }

        When("I create a framework:") { params: FrameworkCreateParams ->
            step {
                createFramework(params)
            }
        }

        Given("A framework is created") {
            step {
                createFramework(frameworkCreateParams(null))
            }
        }

        Given("A framework is created:") { params: FrameworkCreateParams ->
            step {
                createFramework(params)
            }
        }

        Given("Some frameworks are created:") { dataTable: DataTable ->
            step {
                dataTable.asList(FrameworkCreateParams::class.java)
                    .forEach { createFramework(it) }
            }
        }

        Then("The framework should be created") {
            step {
                val frameworkId = context.frameworkIds.lastUsed
                AssertionBdd.framework(frameworkRepository).assertThatId(frameworkId).hasFields(
                    status = FrameworkState.CREATED,
                    identifier = command.identifier,
                    name = command.name,
                )
            }
        }

        Then("The framework should be created:") { params: FrameworkAssertParams ->
            step {
                val frameworkId = context.frameworkIds.safeGet(params.identifier)
                val framework = frameworkRepository.findById(frameworkId).awaitSingleOrNull()
                Assertions.assertThat(framework).isNotNull

                AssertionBdd.framework(frameworkRepository).assertThat(framework!!).hasFields(
                    status = FrameworkState.CREATED,
                    identifier = params.identifier,
                    name = params.name ?: framework.name,
                )
            }
        }
    }

    private suspend fun createFramework(params: FrameworkCreateParams) = context.frameworkIds.register(params.identifier) {
        command = FrameworkCreateCommand(
            identifier = params.identifier,
            name = params.name,
        )
        frameworkAggregateService.create(command).id
    }

    private fun frameworkCreateParams(entry: Map<String, String>?) = FrameworkCreateParams(
        identifier = entry?.get("identifier").orRandom(),
        name = entry?.get("name") ?: Faker().chess().opening(),
    )

    private data class FrameworkCreateParams(
        val identifier: TestContextKey,
        val name: String,
    )

    private fun frameworkAssertParams(entry: Map<String, String>) = FrameworkAssertParams(
        identifier = entry["identifier"] ?: context.frameworkIds.lastUsedKey,
        name = entry["name"],
    )

    private data class FrameworkAssertParams(
        val identifier: TestContextKey,
        val name: String?,
    )
}
