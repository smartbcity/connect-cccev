package cccev.test

import fixers.bdd.CucumberStepsDefinition
import org.springframework.beans.factory.annotation.Autowired

open class CccevCucumberStepsDefinition: CucumberStepsDefinition() {

    @Autowired
    override lateinit var context: CccevTestContext
}
