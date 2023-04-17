package cccev.test.s2.certification.command

import cccev.projection.api.entity.certification.CertificationRepository
import cccev.s2.certification.api.CertificationAggregateService
import cccev.s2.certification.domain.command.CertificationAddEvidenceCommand
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

class CertificationAddEvidenceSteps: En, CccevCucumberStepsDefinition() {

    @Autowired
    private lateinit var certificationAggregateService: CertificationAggregateService

    @Autowired
    private lateinit var certificationRepository: CertificationRepository

    private lateinit var command: CertificationAddEvidenceCommand

    init {
        DataTableType(::certificationAddEvidenceParams)
        DataTableType(::certificationAssertParams)

        When("I add an evidence to the certification") {
            step {
                addEvidence(certificationAddEvidenceParams(null))
            }
        }

        When("I add an evidence to the certification:") { params: CertificationAddEvidenceParams ->
            step {
                addEvidence(params)
            }
        }

        Given("An evidence is added to the certification") {
            step {
                addEvidence(certificationAddEvidenceParams(null))
            }
        }

        Given("An evidence is added to the certification:") { params: CertificationAddEvidenceParams ->
            step {
                addEvidence(params)
            }
        }

        Given("Some evidences are added to the certifications:") { dataTable: DataTable ->
            step {
                dataTable.asList(CertificationAddEvidenceParams::class.java)
                    .forEach { addEvidence(it) }
            }
        }

        Then("The certification should contain the evidence") {
            step {
                val certificationId = context.certificationIds.lastUsed
                val evidenceId = context.evidenceIds.lastUsed
                AssertionBdd.certification(certificationRepository)
                    .assertThatId(certificationId)
                    .assertThatEvidence(evidenceId)
                    .hasFields(
                        name = command.name,
                        isConformantTo = command.isConformantTo
                    )
            }
        }

        Then("The certification should contain the evidence:") { params: CertificationAssertParams ->
            step {
                assertCertification(params)
            }
        }

        Then("The certifications should contain the evidences:") { dataTable: DataTable ->
            step {
                dataTable.asList(CertificationAssertParams::class.java)
                    .forEach { assertCertification(it) }
            }
        }
    }

    private suspend fun addEvidence(params: CertificationAddEvidenceParams) = context.evidenceIds.register(params.evidence) {
        command = CertificationAddEvidenceCommand(
            id = context.certificationIds[params.identifier] ?: params.identifier,
            name = params.name,
            file = null,
            url = null,
            isConformantTo = params.isConformantTo.map(context.evidenceTypeIds::safeGet),
        )
        certificationAggregateService.addEvidence(command).evidenceId
    }

    private fun certificationAddEvidenceParams(entry: Map<String, String>?) = CertificationAddEvidenceParams(
        identifier = entry?.get("identifier") ?: context.certificationIds.lastUsedKey,
        evidence = entry?.get("evidence").orRandom(),
        name = entry?.get("name").orRandom(),
        isConformantTo = entry?.extractList("isConformantTo").orEmpty()
    )

    private data class CertificationAddEvidenceParams(
        val identifier: TestContextKey,
        val evidence: TestContextKey,
        val name: String,
        val isConformantTo: List<TestContextKey>,
    )

    private suspend fun assertCertification(params: CertificationAssertParams) {
        val certificationId = context.certificationIds.safeGet(params.identifier)
        val certification = certificationRepository.findById(certificationId).awaitSingleOrNull()
        Assertions.assertThat(certification).isNotNull

        val certificationAsserter = AssertionBdd.certification(certificationRepository).assertThat(certification!!)

        val evidenceId = context.evidenceIds.safeGet(params.evidence)
        certificationAsserter.hasEvidences(listOf(evidenceId))

        val evidence = certification.evidences.first { it.id == evidenceId }
        certificationAsserter.assertThatEvidence(evidenceId).hasFields(
            name = params.name ?: evidence.name,
            isConformantTo = params.isConformantTo?.map(context.evidenceTypeIds::safeGet) ?: evidence.isConformantTo.map { it.id }
        )
    }

    private fun certificationAssertParams(entry: Map<String, String>) = CertificationAssertParams(
        identifier = entry["identifier"] ?: context.certificationIds.lastUsedKey,
        evidence = entry["evidence"] ?: context.evidenceIds.lastUsedKey,
        name = entry["name"],
        isConformantTo = entry.extractList("isConformantTo")
    )

    private data class CertificationAssertParams(
        val identifier: TestContextKey,
        val evidence: TestContextKey,
        val name: String?,
        val isConformantTo: List<TestContextKey>?,
    )
}
