package cccev.projection.api.entity.concept

import cccev.s2.concept.domain.InformationConceptId
import org.springframework.data.neo4j.repository.Neo4jRepository

interface InformationConceptRepository: Neo4jRepository<InformationConceptEntity, InformationConceptId>
