package com.lazarusx.leetcode;

import java.util.HashMap;

/**
 * Created by LazarusX on 15/8/9.
 */
public class CloneGraph {
    public static void main(String[] args) {
        UndirectedGraphNode node0 = new UndirectedGraphNode(0);
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        node0.neighbors.add(node1);
        node0.neighbors.add(node2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node2);

        UndirectedGraphNode clone = cloneGraph(node0);
    }

    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        HashMap<UndirectedGraphNode, UndirectedGraphNode> visited
                = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        return cloneGraphHelper(node, visited);
    }

    public static UndirectedGraphNode cloneGraphHelper(UndirectedGraphNode node,
                                                       HashMap<UndirectedGraphNode, UndirectedGraphNode> visited) {
        if (!visited.containsKey(node)) {
            UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
            visited.put(node, clone);

            for (UndirectedGraphNode neighbor : node.neighbors) {
                clone.neighbors.add(cloneGraphHelper(neighbor, visited));
            }

            return clone;
        } else {
            return visited.get(node);
        }
    }
}
