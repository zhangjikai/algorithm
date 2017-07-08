package com.zhangjikai.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhangjk on 2017/7/8.
 */
public class LevelOrder {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return null;
        }
        TreeNode split = new TreeNode(Integer.MAX_VALUE);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(split);
        TreeNode node;
        ArrayList<ArrayList<Integer>> reuslts = new ArrayList<>();
        ArrayList<Integer> single = new ArrayList<>();
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node != split) {
                single.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {
                reuslts.add(single);
                single = new ArrayList<>();
                if (queue.size() > 0)
                    queue.add(split);
            }
        }

        return reuslts;
    }

    public static void main(String[] args) {

    }

}
