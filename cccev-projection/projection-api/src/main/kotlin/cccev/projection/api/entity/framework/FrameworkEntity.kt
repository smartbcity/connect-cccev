package cccev.projection.api.entity.framework

import cccev.dsl.model.FrameworkId
import cccev.projection.api.entity.EntityBase
import cccev.projection.api.entity.NodeLabel
import cccev.s2.framework.domain.FrameworkState
import org.springframework.data.neo4j.core.schema.Node

@Node(NodeLabel.FRAMEWORK)
class FrameworkEntity: EntityBase<FrameworkId, FrameworkState>() {
    var identifier: String? = null
    lateinit var name: String
}
