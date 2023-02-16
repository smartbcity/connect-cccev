package cccev.test.generics.exceptions

import cccev.test.CccevCucumberStepsDefinition
import f2.spring.exception.NotFoundException
import fixers.bdd.assertion.AssertionBdd
import fixers.bdd.assertion.exceptions
import fixers.bdd.data.TestContextKey
import fixers.bdd.data.parser.safeExtract
import io.cucumber.java8.En

class NotFoundExceptionAssertionSteps: En, CccevCucumberStepsDefinition() {
    init {
        DataTableType(::notFoundParams)

        Then("The data unit should not be found") { assert(context.unitIds.lastUsedKey) }
    }

    private fun assert(id: String) = step {
        AssertionBdd.exceptions(context)
            .assertThat(NotFoundException::class)
            .hasBeenThrown(1) { e -> id in e.message.orEmpty() }
    }

    private fun notFoundParams(entry: Map<String, String>) = NotFoundParams(
        identifier = entry.safeExtract("identifier")
    )

    private data class NotFoundParams(
        val identifier: TestContextKey
    )
}
