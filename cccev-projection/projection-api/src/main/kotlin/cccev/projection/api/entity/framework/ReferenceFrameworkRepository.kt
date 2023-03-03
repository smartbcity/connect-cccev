package cccev.projection.api.entity.framework

import org.springframework.data.neo4j.repository.Neo4jRepository

interface ReferenceFrameworkRepository: Neo4jRepository<ReferenceFrameworkEntity, ReferenceFrameworkId>
