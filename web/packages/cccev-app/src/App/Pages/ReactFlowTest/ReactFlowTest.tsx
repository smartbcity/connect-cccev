import { useNodesState, useEdgesState, ReactFlow } from "reactflow"
import { cccev, requirementsToNodes, requirementsToEdges } from './cccev';
import 'reactflow/dist/style.css';
import { CustomNode } from "./CustomNode";

const nodeTypes = {
    custom: CustomNode,
};

export const ReactFlowTest = () => {
    const [nodes, _, onNodesChange] = useNodesState(requirementsToNodes(cccev));
    const [edges, , onEdgesChange] = useEdgesState(requirementsToEdges(cccev));
    return (
        <main
            style={{
                width: "100vw",
                height: "100vh"
            }}
        >
            <ReactFlow
                nodes={nodes}
                edges={edges}
                onNodesChange={onNodesChange}
                onEdgesChange={onEdgesChange}
                nodeTypes={nodeTypes}
                fitView
                attributionPosition="bottom-left"
            ></ReactFlow>
        </main>
    )
}
