package com.zhangjikai.linkedlist;

/**
 * Created by Jikai Zhang on 2017/4/14.
 */



public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode fastNode, slowNode;
        fastNode = head;
        slowNode = head;
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (fastNode == slowNode) {
                return true;
            }
        }
        return false;
    }
}
