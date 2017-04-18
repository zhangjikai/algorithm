package com.zhangjikai.linkedlist;

/**
 * Created by Jikai Zhang on 2017/4/14.
 */
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head, slow = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                hasCycle = true;
                break;
            }
        }

        if(hasCycle) {
            fast = head;
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
                if(fast == slow) {
                    return  fast;
                }
            }
        }
        return null;
    }
}
