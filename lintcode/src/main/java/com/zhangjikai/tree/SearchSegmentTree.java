package com.zhangjikai.tree;

import com.zhangjikai.dp.Match;
import com.zhangjikai.test.Main;

/**
 * Created by zhangjk on 2017/7/29.
 */
public class SearchSegmentTree {

    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        if (start < root.start) {
            start = root.start;
        }
        if (end > root.end) {
            end = root.end;
        }

        if (root.start == start && root.end == end) {
            return root.max;
        }

        int mid = (root.start + root.end) / 2;

        return Math.max(query(root.left, start, Math.min(mid, end)), query(root.right, Math.max(mid + 1, start), end));


    }
}
