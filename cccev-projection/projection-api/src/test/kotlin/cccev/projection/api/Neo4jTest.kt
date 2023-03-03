package cccev.projection.api

import cccev.projection.api.entity.requirement.RequirementEntity
import cccev.projection.api.entity.requirement.RequirementRepository
import cccev.s2.requirement.domain.model.RequirementKind
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest(classes = [Neo4jTestApplication::class])
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension::class)
class Neo4jTest {

    @Autowired
    private lateinit var requirementRepository: RequirementRepository

    @Test
    fun test() {
        val requirement = RequirementEntity().apply {
            kind = RequirementKind.INFORMATION
            identifier = "P"
            name = "Protocol"
            hasRequirement = listOf(
                RequirementEntity().apply {
                    kind = RequirementKind.INFORMATION
                    identifier = "PoP"
                    name = "ProtocolOfProtocol"
                    hasRequirement = listOf(
                        RequirementEntity().apply {
                            kind = RequirementKind.INFORMATION
                            identifier = "PoPinP"
                            name = "ProtocolOfProtocolInProtocol"
                        }
                    )
                }
            )
        }
        requirementRepository.save(requirement)
    }
}
