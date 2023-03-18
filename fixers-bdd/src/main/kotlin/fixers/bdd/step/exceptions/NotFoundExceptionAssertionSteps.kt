package fixers.bdd.step.exceptions

import f2.spring.exception.NotFoundException
import fixers.bdd.CucumberStepsDefinition
import fixers.bdd.assertion.AssertionBdd
import fixers.bdd.assertion.exceptions
import fixers.bdd.data.TestContextKey
import fixers.bdd.data.parser.safeExtract
import io.cucumber.java8.En
class NotFoundExceptionAssertionSteps: En, CucumberStepsDefinition() {
    init {
        DataTableType(::notFoundParams)

        Then("The {string} should not be found") { objectName: String ->
            val lastUsedKey = context.testEntities<Any, Any>(objectName).lastUsedKey
            assert(lastUsedKey.toString())
        }

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
