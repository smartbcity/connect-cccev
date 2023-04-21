package cccev.test.s2.certification.command

import cccev.projection.api.entity.certification.CertificationRepository
import cccev.s2.certification.api.CertificationAggregateService
import cccev.s2.certification.domain.CertificationState
import cccev.s2.certification.domain.command.CertificationCreateCommand
import cccev.test.CccevCucumberStepsDefinition
import cccev.test.s2.certification.data.certification
import io.cucumber.datatable.DataTable
import io.cucumber.java8.En
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.assertj.core.api.Assertions
import org.springframework.beans.factory.annotation.Autowired
import s2.bdd.assertion.AssertionBdd
import s2.bdd.data.TestContextKey
import s2.bdd.data.parser.extractList
import java.util.UUID

class CertificationCreateSteps: En, CccevCucumberStepsDefinition() {

    @Autowired
    private lateinit var certificationAggregateService: CertificationAggregateService

    @Autowired
    private lateinit var certificationRepository: CertificationRepository

    private lateinit var command: CertificationCreateCommand

    init {
        DataTableType(::certificationCreateParams)
        DataTableType(::certificationAssertParams)

        When("I create a certification") {
            step {
                createCertification(certificationCreateParams(null))
            }
        }

        When("I create a certification:") { params: CertificationCreateParams ->
            step {
                createCertification(params)
            }
        }

        Given("A certification is created") {
            step {
                createCertification(certificationCreateParams(null))
            }
        }

        Given("A certification is created:") { params: CertificationCreateParams ->
            step {
                createCertification(params)
            }
        }

        Given("Some certifications are created:") { dataTable: DataTable ->
            step {
                dataTable.asList(CertificationCreateParams::class.java)
                    .forEach { createCertification(it) }
            }
        }

        Then("The certification should be created") {
            step {
                val certificationId = context.certificationIds.lastUsed
                AssertionBdd.certification(certificationRepository).assertThatId(certificationId).hasFields(
                    identifier = command.identifier,
                    status = CertificationState.CREATED,
                    name = command.name,
                    description = command.description,
                    requirements = command.requirements
                )
            }
        }

        Then("The certification should be created:") { params: CertificationAssertParams ->
            step {
                val certificationId = context.certificationIds.safeGet(params.identifier)
                val certification = certificationRepository.findById(certificationId).awaitSingleOrNull()
                Assertions.assertThat(certification).isNotNull

                AssertionBdd.certification(certificationRepository).assertThat(certification!!).hasFields(
                    status = CertificationState.CREATED,
                    name = params.name ?: certification.name,
                    description = params.description ?: certification.description,
                    requirements = params.requirements?.map(context.requirementIds::safeGet) ?: certification.requirements.map { it.id }
                )
            }
        }
    }

    private suspend fun createCertification(params: CertificationCreateParams) = context.certificationIds.register(params.identifier) {
        command = CertificationCreateCommand(
            identifier = "${params.identifier}_${UUID.randomUUID()}",
            name = params.name,
            description = params.description,
            requirements = params.requirements.map(context.requirementIds::safeGet),
        )
        certificationAggregateService.create(command).id
    }

    private fun certificationCreateParams(entry: Map<String, String>?) = CertificationCreateParams(
        identifier = entry?.get("identifier").orRandom(),
        name = entry?.get("name").orRandom(),
        description = entry?.get("description"),
        requirements = entry?.extractList("requirements").orEmpty()
    )

    private data class CertificationCreateParams(
        val identifier: TestContextKey,
        val name: String,
        val description: String?,
        val requirements: List<TestContextKey>,
    )

    private fun certificationAssertParams(entry: Map<String, String>) = CertificationAssertParams(
        identifier = entry["identifier"] ?: context.certificationIds.lastUsedKey,
        name = entry["name"],
        description = entry["description"],
        requirements = entry.extractList("requirements")
    )

    private data class CertificationAssertParams(
        val identifier: TestContextKey,
        val name: String?,
        val description: String?,
        val requirements: List<TestContextKey>?,
    )
}
