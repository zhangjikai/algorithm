package com.zhangjikai.tree;

/**
 * Created by zhangjk on 2017/7/29.
 */
public class BuildSegmentTree {

    public SegmentTreeNode build(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return null;
        }
        return recurBuild(A, 0, A.length - 1);
    }

    public SegmentTreeNode recurBuild(int[] A, int start, int end) {
        if (start == end) {
            return new SegmentTreeNode(start, end, A[start]);
        }
        int max = A[start];
        for (int i = start + 1; i <= end; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        SegmentTreeNode node = new SegmentTreeNode(start, end, max);
        int mid = (start + end) / 2;
        node.left = recurBuild(A, start, mid);
        node.right = recurBuild(A, mid + 1, end);
        return node;
    }
}
