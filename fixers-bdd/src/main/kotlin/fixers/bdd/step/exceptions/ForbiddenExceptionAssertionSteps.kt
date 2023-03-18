package fixers.bdd.step.exceptions

import f2.spring.exception.ForbiddenAccessException
import fixers.bdd.CucumberStepsDefinition
import fixers.bdd.assertion.AssertionBdd
import fixers.bdd.assertion.exceptions
import io.cucumber.java8.En

class ForbiddenExceptionAssertionSteps: En, CucumberStepsDefinition() {
    init {
        Then("I should be forbidden to do so") {
            step {
                AssertionBdd.exceptions(context)
                    .assertThat(ForbiddenAccessException::class)
                    .hasBeenThrown(1)
            }
        }

        Then("I should not be forbidden to do so") {
            step {
                AssertionBdd.exceptions(context)
                    .assertThat(ForbiddenAccessException::class)
                    .hasNotBeenThrown()
            }
        }
    }
}
