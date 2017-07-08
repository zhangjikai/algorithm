package com.zhangjikai.tree;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhangjk on 2017/7/8.
 */
public class CommonAncestor {

    class TreeNodeWithParent {
        public TreeNode treeNode;
        public TreeNodeWithParent parent;

        public TreeNodeWithParent(TreeNodeWithParent parent, TreeNode treeNode) {
            this.parent = parent;
            this.treeNode = treeNode;
        }
    }

    TreeNodeWithParent nodeA;
    TreeNodeWithParent nodeB;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null || A == null || B == null) {
            return null;
        }

        preOrder(null, root, A, B);
        Set<TreeNodeWithParent> set = new HashSet<>();

        while (nodeA != null) {
            if (nodeA == nodeB) {
                return nodeB.treeNode;
            } else {
                set.add(nodeA);
            }
            nodeA = nodeA.parent;
        }
        while (nodeB != null) {
            if(set.contains(nodeB)) {
                return nodeB.treeNode;
            }
            nodeB = nodeB.parent;
        }
        return null;
    }

    public void preOrder(TreeNodeWithParent parent, TreeNode node, TreeNode A, TreeNode B) {
        if (node == null) {
            return;
        }

        TreeNodeWithParent nodeWithParent = new TreeNodeWithParent(parent, node);
        if (node == A) {
            nodeA = nodeWithParent;
        }
        if (node == B) {
            nodeB = nodeWithParent;
        }

        if (node.left != null) {
            preOrder(nodeWithParent, node.left, A, B);
        }

        if (node.right != null) {
            preOrder(nodeWithParent, node.right, A, B);
        }
    }


}
