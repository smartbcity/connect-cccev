package cccev.test

import cccev.s2.unit.domain.DataUnitId
import fixers.bdd.data.TestContext
import fixers.bdd.data.TestContextKey
import org.springframework.stereotype.Component

@Component
class CccevTestContext: TestContext() {
    val unitIds = testEntities<TestContextKey, DataUnitId>("Unit")

    final var fetched = FetchContext()
        private set

    override fun resetEnv() {
        fetched = FetchContext()
    }

    class FetchContext {
//    lateinit var traces: List<TraceEntity>
    }
}
