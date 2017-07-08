package com.zhangjikai.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangjk on 2017/7/8.
 */
public class Inorder {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> results = new ArrayList<>();
        if(root == null) {
            return results;
        }
        inorder(root, results);
        return results;
    }

    public void inorder(TreeNode node, ArrayList<Integer> results) {
        if(node == null) {
            return;
        }

        if(node.left != null) {
            inorder(node.left, results);
        }
        results.add(node.val);
        if(node.right != null) {
            inorder(node.right, results);
        }
    }
}
