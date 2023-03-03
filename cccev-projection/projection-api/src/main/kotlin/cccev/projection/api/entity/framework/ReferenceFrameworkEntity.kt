package cccev.projection.api.entity.framework

import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import java.util.UUID

typealias ReferenceFrameworkId = String

@Node("ReferenceFramework")
class ReferenceFrameworkEntity {
    @Id
    val id: ReferenceFrameworkId = UUID.randomUUID().toString()

    var identifier: String? = null
}
