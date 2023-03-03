package cccev.projection.api.entity.requirement

import cccev.s2.requirement.domain.RequirementId
import org.springframework.data.neo4j.repository.Neo4jRepository

interface RequirementRepository: Neo4jRepository<RequirementEntity, RequirementId>
