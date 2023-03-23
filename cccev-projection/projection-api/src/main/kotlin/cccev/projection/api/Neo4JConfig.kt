package cccev.projection.api

import cccev.projection.api.converter.FilePathConverter
import org.neo4j.driver.Driver
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.neo4j.core.ReactiveDatabaseSelectionProvider
import org.springframework.data.neo4j.core.convert.Neo4jConversions
import org.springframework.data.neo4j.core.transaction.ReactiveNeo4jTransactionManager

@Configuration
class Neo4JConfig {

    @Bean
    fun reactiveTransactionManager(
        driver: Driver,
        databaseNameProvider: ReactiveDatabaseSelectionProvider,
    ): ReactiveNeo4jTransactionManager? {
        return ReactiveNeo4jTransactionManager(driver, databaseNameProvider)
    }

    @Bean
    fun neo4jConversions() = Neo4jConversions(listOf(
        FilePathConverter()
    ))
}
