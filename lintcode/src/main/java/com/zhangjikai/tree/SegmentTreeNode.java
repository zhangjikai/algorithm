package com.zhangjikai.tree;

/**
 * Created by zhangjk on 2017/7/29.
 */
public class SegmentTreeNode {
    public int start, end, max;
    public SegmentTreeNode left, right;

    public SegmentTreeNode(int start, int end, int max) {
        this.start = start;
        this.end = end;
        this.max = max;
        this.left = this.right = null;
    }

}
