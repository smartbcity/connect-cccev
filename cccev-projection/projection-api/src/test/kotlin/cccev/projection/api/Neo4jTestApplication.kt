package cccev.projection.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories

@EntityScan("cccev.projection")
@EnableNeo4jRepositories("cccev.projection")
@SpringBootApplication(scanBasePackages = ["cccev.projection"])
class Neo4jTestApplication

fun main(args: Array<String>) {
	runApplication<Neo4jTestApplication>(*args)
}
