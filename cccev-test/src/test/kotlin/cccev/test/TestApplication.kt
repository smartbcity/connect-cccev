package cccev.test

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.neo4j.config.EnableReactiveNeo4jAuditing
import org.springframework.data.neo4j.repository.config.EnableReactiveNeo4jRepositories
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@EntityScan("cccev")
@EnableReactiveNeo4jAuditing
@EnableReactiveNeo4jRepositories("cccev")
@SpringBootApplication(scanBasePackages = ["cccev", "s2.bdd"])
class TestApplication
