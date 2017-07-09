package com.zhangjikai.depth_width;

import java.util.*;

/**
 * Created by zhangjk on 2017/7/9.
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        Queue<UndirectedGraphNode> nodeQueue = new LinkedList<>();
        Queue<UndirectedGraphNode> cloneNodeQueue = new LinkedList<>();
        Set<UndirectedGraphNode> clonedGraphSet = new HashSet<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> cloneGraphMap = new HashMap<>();
        nodeQueue.add(node);
        UndirectedGraphNode root, topNode, topCloneNode;
        root = new UndirectedGraphNode(node.label);
        cloneNodeQueue.add(root);
        cloneGraphMap.put(node, root);

        while (!nodeQueue.isEmpty()) {
            topNode = nodeQueue.poll();
            topCloneNode = cloneNodeQueue.poll();
            if (clonedGraphSet.contains(topNode)) {
                continue;
            }
            for (UndirectedGraphNode graphNode : topNode.neighbors) {
                UndirectedGraphNode tmp;
                if (cloneGraphMap.containsKey(graphNode)) {
                    tmp = cloneGraphMap.get(graphNode);
                } else {
                    tmp = new UndirectedGraphNode(graphNode.label);
                    cloneGraphMap.put(graphNode, tmp);
                }
                topCloneNode.neighbors.add(tmp);
                if (topNode == graphNode) {
                    continue;
                }
                nodeQueue.add(graphNode);
                cloneNodeQueue.add(tmp);
            }
            clonedGraphSet.add(topNode);
        }
        return root;
    }
}
