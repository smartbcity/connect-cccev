package cccev.projection.api.entity.evidencetype

import cccev.s2.evidence.domain.EvidenceTypeId
import org.springframework.data.neo4j.repository.Neo4jRepository

interface EvidenceTypeRepository: Neo4jRepository<EvidenceTypeEntity, EvidenceTypeId>
