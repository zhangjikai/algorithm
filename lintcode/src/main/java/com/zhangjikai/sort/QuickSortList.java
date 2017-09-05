package com.zhangjikai.sort;

import java.util.List;

/**
 * Created by zhangjk on 2017/8/27.
 */
public class QuickSortList {

    public ListNode sortList(ListNode head) {

        if (head == null) {
            return head;
        }

        sort(head, null);

        return head;
    }

    public void sort(ListNode start, ListNode end) {
        if (start == end || start == null) {
            return;
        }
        int val = start.val;

        ListNode pos = start;
        ListNode next = start.next;
        while (next != null) {
            if (next.val < val) {
                pos = pos.next;
                swap(pos, next);
            }
            next = next.next;
        }
        swap(start, pos);

        sort(start, pos);
        sort(pos.next, end);

    }

    public void swap(ListNode node, ListNode node2) {
        int tmp = node.val;
        node.val = node2.val;
        node2.val = tmp;
    }


}
