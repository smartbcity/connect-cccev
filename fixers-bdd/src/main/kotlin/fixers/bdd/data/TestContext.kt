package fixers.bdd.data

import city.smartb.im.commons.auth.AuthedUser
import f2.dsl.cqrs.Event

typealias TestContextKey = String

open class TestContext {
    protected val entityLists = mutableListOf<TestEntities<*, *>>()

    var authedUser: AuthedUser? = null

    val errors = ExceptionList()
    val events = mutableListOf<Event>()

    protected fun <K: Any, V> testEntities(name: String) = TestEntities<K, V>(name)
        .also(entityLists::add)

    fun reset() {
        resetEnv()
        entityLists.forEach(TestEntities<*, *>::reset)
        errors.reset()
        events.clear()
    }

    open fun resetEnv() = Unit
}
