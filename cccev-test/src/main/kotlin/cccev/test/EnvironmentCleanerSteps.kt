package cccev.test

import fixers.bdd.data.TestContext
import io.cucumber.java8.En
import org.springframework.data.mongodb.core.MongoTemplate

class EnvironmentCleanerSteps(
    private val context: TestContext,
    private val mongoTemplate: MongoTemplate,
): En {
    init {
        Before { _ ->
//            cleanFs()
            context.reset()
            cleanDb()
        }
    }

    // TODO activate when fs added
//    private fun cleanFs() = runBlocking {
//        context.filePaths.items
//            .ifEmpty { return@runBlocking  }
//            .let { fileClient.fileGet(it) }
//            .mapNotNull { it.file?.path }
//            .let { fileClient.fileDelete(it) }
//    }

    private fun cleanDb() {
        mongoTemplate.collectionNames.forEach(mongoTemplate::dropCollection)
    }
}
