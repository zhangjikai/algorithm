package com.zhangjikai.depth_width;

import java.util.ArrayList;

/**
 * Created by zhangjk on 2017/7/9.
 */
public class DirectedGraphNode {

    int label;
    ArrayList<DirectedGraphNode> neighbors;

    DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<DirectedGraphNode>();
    }
}
