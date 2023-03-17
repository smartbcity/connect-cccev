package cccev.test

import fixers.bdd.data.TestContext
import io.cucumber.java8.En
import kotlinx.coroutines.runBlocking
import org.springframework.data.neo4j.core.Neo4jClient

class EnvironmentCleanerSteps(
    private val context: TestContext,
    private val neo4jTemplate: Neo4jClient
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

    private fun cleanDb() = runBlocking {
        neo4jTemplate.query("MATCH ()-[r]-() DELETE r").run()
        neo4jTemplate.query("MATCH (n) DELETE n").run()
    }
}
