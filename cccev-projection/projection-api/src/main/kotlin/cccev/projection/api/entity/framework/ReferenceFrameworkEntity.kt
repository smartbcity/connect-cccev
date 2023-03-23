package cccev.projection.api.entity.framework

import cccev.projection.api.entity.NodeLabel
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import java.util.UUID

typealias ReferenceFrameworkId = String

@Node(NodeLabel.REFERENCE_FRAMEWORK)
class ReferenceFrameworkEntity {
    @Id
    val id: ReferenceFrameworkId = UUID.randomUUID().toString()

    var identifier: String? = null
}
