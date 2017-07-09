package com.zhangjikai.depth_width;

import java.util.ArrayList;

/**
 * Created by zhangjk on 2017/7/9.
 */

class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};

