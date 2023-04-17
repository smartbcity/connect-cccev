package cccev.test.s2.certification.command

import cccev.projection.api.entity.certification.CertificationRepository
import cccev.s2.certification.api.CertificationAggregateService
import cccev.s2.certification.domain.command.CertificationAddValuesCommand
import cccev.test.CccevCucumberStepsDefinition
import cccev.test.s2.certification.data.certification
import io.cucumber.datatable.DataTable
import io.cucumber.java8.En
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.assertj.core.api.Assertions
import org.springframework.beans.factory.annotation.Autowired
import s2.bdd.assertion.AssertionBdd
import s2.bdd.data.TestContextKey
import s2.bdd.data.parser.safeExtract

class CertificationAddValuesSteps: En, CccevCucumberStepsDefinition() {

    @Autowired
    private lateinit var certificationAggregateService: CertificationAggregateService

    @Autowired
    private lateinit var certificationRepository: CertificationRepository

    private lateinit var command: CertificationAddValuesCommand

    init {
        DataTableType(::certificationAddValuesParams)
        DataTableType(::certificationAssertParams)

        When("I add values to the certification:") { dataTable: DataTable ->
            step {
                dataTable.asList(CertificationAddValuesParams::class.java)
                    .groupBy(CertificationAddValuesParams::identifier)
                    .forEach { (identifier, params) ->
                        addValues(identifier, params.associate { it.concept to it.value })
                    }
            }
        }

        When("Some values are added to the certification:") { dataTable: DataTable ->
            step {
                dataTable.asList(CertificationAddValuesParams::class.java)
                    .groupBy(CertificationAddValuesParams::identifier)
                    .forEach { (identifier, params) ->
                        addValues(identifier, params.associate { it.concept to it.value })
                    }
            }
        }

        Then("The certification should contain the values") {
            step {
                val certificationId = context.certificationIds.lastUsed
                AssertionBdd.certification(certificationRepository).assertThatId(certificationId)
                    .hasSupportedValues(command.values)
            }
        }

        Then("The certification should contain the values:") { dataTable: DataTable ->
            step {
                dataTable.asList(CertificationAssertParams::class.java)
                    .groupBy(CertificationAssertParams::identifier)
                    .forEach { (identifier, params) ->
                        val certificationId = context.certificationIds.safeGet(identifier)
                        val certification = certificationRepository.findById(certificationId).awaitSingleOrNull()
                        Assertions.assertThat(certification).isNotNull

                        val supportedValues = params.associate { context.conceptIds.safeGet(it.concept) to it.value }
                        AssertionBdd.certification(certificationRepository).assertThatId(certificationId)
                            .hasSupportedValues(supportedValues)
                    }
            }
        }
    }

    private suspend fun addValues(identifier: TestContextKey, values: Map<TestContextKey, String?>) {
        command = CertificationAddValuesCommand(
            id = context.certificationIds[identifier] ?: identifier,
            values = values.mapKeys { (conceptIdentifier) -> context.conceptIds.safeGet(conceptIdentifier) }
        )
        certificationAggregateService.addValues(command)
    }

    private fun certificationAddValuesParams(entry: Map<String, String>) = CertificationAddValuesParams(
        identifier = entry["identifier"] ?: context.certificationIds.lastUsedKey,
        concept = entry.safeExtract("concept"),
        value = entry["value"]
    )

    private data class CertificationAddValuesParams(
        val identifier: TestContextKey,
        val concept: TestContextKey,
        val value: String?
    )

    private fun certificationAssertParams(entry: Map<String, String>) = CertificationAssertParams(
        identifier = entry["identifier"] ?: context.certificationIds.lastUsedKey,
        concept = entry.safeExtract("concept"),
        value = entry.safeExtract("value")
    )

    private data class CertificationAssertParams(
        val identifier: TestContextKey,
        val concept: TestContextKey,
        val value: String?
    )
}
