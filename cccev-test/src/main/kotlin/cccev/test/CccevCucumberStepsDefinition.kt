package cccev.test

import s2.bdd.CucumberStepsDefinition
import org.springframework.beans.factory.annotation.Autowired

open class CccevCucumberStepsDefinition: s2.bdd.CucumberStepsDefinition() {

    @Autowired
    override lateinit var context: CccevTestContext
}
