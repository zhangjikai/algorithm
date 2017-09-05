package com.zhangjikai.sort;

/**
 * Created by zhangjk on 2017/8/27.
 */
public class MergeSortList {
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode quickNode = head;
        ListNode slowNode = head;
        while (quickNode != null && quickNode.next != null) {
            quickNode = quickNode.next.next;
            slowNode = slowNode.next;
        }
        ListNode node = sortList(slowNode.next);
        slowNode.next = null;
        ListNode node2 = sortList(head);

        return mergeNode(node, node2);
    }

    public ListNode mergeNode(ListNode start, ListNode end) {
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while (start != null || end != null) {
            if (start.val < end.val) {
                tmp.next = start;
                start = start.next;
            } else {
                head.next = end;
                tmp = end.next;
            }
            tmp = tmp.next;

        }
        while (start != null) {
            tmp = start;
            tmp = tmp.next;
            start = start.next;
        }

        while (end != null) {
            tmp = end;
            tmp = tmp.next;
            end = end.next;
        }
        return head.next;
    }


}
