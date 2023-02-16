package cccev.test.generics.exceptions

import cccev.test.CccevCucumberStepsDefinition
import f2.spring.exception.ConflictException
import f2.spring.exception.ForbiddenAccessException
import f2.spring.exception.MessageConverterException
import f2.spring.exception.NotFoundException
import fixers.bdd.assertion.AssertionBdd
import fixers.bdd.assertion.exceptions
import fixers.bdd.data.parser.safeExtract
import io.cucumber.java8.En

class ExceptionAssertionSteps: En, CccevCucumberStepsDefinition() {
    init {
        DataTableType(::exceptionAssertionParams)

        Then("An exception should be thrown:") { params: ExceptionAssertionParams ->
            step {
                AssertionBdd.exceptions(context)
                    .assertThat(params.code.toExceptionClass())
                    .hasBeenThrown(params.times)
            }
        }

        Then("No exception should be thrown:") { params: ExceptionAssertionParams ->
            step {
                AssertionBdd.exceptions(context)
                    .assertThat(params.code.toExceptionClass())
                    .hasNotBeenThrown()
            }
        }
    }

    private fun Int.toExceptionClass() = when (this) {
        400 -> MessageConverterException::class
        403 -> ForbiddenAccessException::class
        404 -> NotFoundException::class
        409 -> ConflictException::class
        else -> throw IllegalArgumentException("Unknown exception code [$this]")
    }

    private fun exceptionAssertionParams(entry: Map<String, String>) = ExceptionAssertionParams(
        code = entry.safeExtract("code").toInt(),
        times = entry["times"]?.toInt() ?: 1
    )

    private data class ExceptionAssertionParams(
        val code: Int,
        val times: Int
    )
}
