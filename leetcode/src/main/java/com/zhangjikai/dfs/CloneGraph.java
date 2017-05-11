package com.zhangjikai.dfs;

import java.util.*;

/**
 * Created by Jikai Zhang on 2017/5/8.
 */

public class CloneGraph {

    static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        public UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();

        }

        @Override
        public String toString() {
            return "UndirectedGraphNode{" +
                    "label=" + label +
                    ", neighbors=" + neighbors +
                    '}';
        }
    }

    static class Combine {
        UndirectedGraphNode realNode;
        UndirectedGraphNode copyNode;

        public Combine() {
        }

        public Combine(UndirectedGraphNode realNode, UndirectedGraphNode copyNode) {
            this.realNode = realNode;
            this.copyNode = copyNode;
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        Map<String, UndirectedGraphNode> graphMap = new HashMap<>();
        UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
        graphMap.put(String.valueOf(node.label), copyNode);

        Combine combine = new Combine(node, copyNode);
        Stack<Combine> stack = new Stack<>();
        stack.push(combine);

        while (!stack.isEmpty()) {
            Combine topCombine = stack.pop();
            UndirectedGraphNode realNode = topCombine.realNode;
            UndirectedGraphNode copyRootNode = topCombine.copyNode;


            for (UndirectedGraphNode undirectedGraphNode : realNode.neighbors) {


                if (graphMap.containsKey(String.valueOf(undirectedGraphNode.label))) {
                    UndirectedGraphNode tmpNode = graphMap.get(String.valueOf(undirectedGraphNode.label));
                    copyRootNode.neighbors.add(tmpNode);
                    continue;
                }

                UndirectedGraphNode tmpNode = new UndirectedGraphNode(undirectedGraphNode.label);
                copyRootNode.neighbors.add(tmpNode);

                Combine tmpCombine = new Combine(undirectedGraphNode, tmpNode);
                stack.push(tmpCombine);
                graphMap.put(String.valueOf(undirectedGraphNode.label), tmpNode);

            }
        }
        //System.out.println(copyNode);
        return copyNode;
    }

    public static void main(String[] args) {
        CloneGraph graph = new CloneGraph();
        UndirectedGraphNode node = new UndirectedGraphNode(0);
        node.neighbors.add(new UndirectedGraphNode(0));
        node.neighbors.add(new UndirectedGraphNode(0));
        UndirectedGraphNode node1 = graph.cloneGraph(node);
    }
}
