package graph;

import java.util.*;
import common.*;

/**
 *
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


 OJ's undirected graph serialization:
 Nodes are labeled uniquely.

 We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 As an example, consider the serialized graph {0,1,2#1,2#2,2}.

 The graph has a total of three nodes, and therefore contains three parts as separated by #.

 First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 Second node is labeled as 1. Connect node 1 to node 2.
 Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 Visually, the graph looks like the following:

 1
 / \
 /   \
 0 --- 2
 / \
 \_/
 * Created by xingyun on 15/6/30.
 */



public class LC_133_CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> nodeMap = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();
        stack.push(node); // stack存放graphnode

       UndirectedGraphNode nnd = new UndirectedGraphNode(node.label);
       nodeMap.put(node, nnd);

        while(!stack.empty()) {
            UndirectedGraphNode nd = stack.pop();

            for(UndirectedGraphNode neighbor : nd.neighbors) {
                if(nodeMap.get(neighbor) == null) {
                    stack.add(neighbor);
                    UndirectedGraphNode tmp = new UndirectedGraphNode(neighbor.label);
                    nodeMap.put(neighbor, tmp);
                    nodeMap.get(nd).neighbors.add(tmp);
                } else {
                    nodeMap.get(nd).neighbors.add(nodeMap.get(neighbor));
                }
            }
        }

        return nnd;
    }

    private void printGraph(UndirectedGraphNode node, Set<UndirectedGraphNode> graphNodes) {

        if(graphNodes.contains(node)) return;

        System.out.println(node.label);
        graphNodes.add(node);

        for(UndirectedGraphNode neighbor:node.neighbors) {
            System.out.println("--" + neighbor.label);
        }
        for(UndirectedGraphNode neighbor:node.neighbors) {
            if(neighbor != node) {
                printGraph(neighbor, graphNodes);
            }
        }
    }

    public static void main(String[] args) {
        UndirectedGraphNode node0 = new UndirectedGraphNode(0);
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        node0.neighbors.add(node1);
        node0.neighbors.add(node2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node2);

        LC_133_CloneGraph inst = new LC_133_CloneGraph();
        System.out.println("original:");
        inst.printGraph(node0, new HashSet<UndirectedGraphNode>());

        UndirectedGraphNode node00 = inst.cloneGraph(node0);

        System.out.println("copy");
        inst.printGraph(node00,new HashSet<UndirectedGraphNode>());
    }
}
