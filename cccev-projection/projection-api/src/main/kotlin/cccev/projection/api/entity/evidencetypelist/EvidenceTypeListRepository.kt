package cccev.projection.api.entity.evidencetypelist

import cccev.s2.evidence.domain.EvidenceTypeListId
import org.springframework.data.neo4j.repository.Neo4jRepository

interface EvidenceTypeListRepository: Neo4jRepository<EvidenceTypeListEntity, EvidenceTypeListId>
