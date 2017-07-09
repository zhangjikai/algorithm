package com.zhangjikai.depth_width;

import java.util.*;

/**
 * Created by zhangjk on 2017/7/9.
 */
public class TopologicalSorting {
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here

        ArrayList<DirectedGraphNode> results = new ArrayList<>();
        if (graph == null) {
            return results;
        }

        Map<DirectedGraphNode, Integer> nodeCount = new HashMap<>();
        Queue<DirectedGraphNode> nodeQueue = new LinkedList<>();
        DirectedGraphNode topNode;
        for (DirectedGraphNode node : graph) {
            nodeQueue.add(node);
            while (!nodeQueue.isEmpty()) {
                topNode = nodeQueue.poll();
                for (DirectedGraphNode neighbor : topNode.neighbors) {
                    if (nodeCount.containsKey(neighbor)) {
                        nodeCount.put(neighbor, nodeCount.get(neighbor) + 1);
                    } else {
                        nodeCount.put(neighbor, 1);
                    }
                }
            }
        }

        Queue<DirectedGraphNode> zeroInNodeQueue = new LinkedList<>();
        for(DirectedGraphNode node : graph) {
            if(!nodeCount.containsKey(node)) {
                zeroInNodeQueue.add(node);
            }
        }

        while (!zeroInNodeQueue.isEmpty()) {
            topNode = zeroInNodeQueue.poll();
            results.add(topNode);
            for(DirectedGraphNode node : topNode.neighbors) {
                int count = nodeCount.get(node) - 1;
                if(count == 0) {
                    zeroInNodeQueue.add(node);
                }
                nodeCount.put(node, count);
            }
        }
        return results;
    }
}
