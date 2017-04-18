package com.zhangjikai.linkedlist;

/**
 * Created by Jikai Zhang on 2017/4/14.
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp = head;
        ListNode sorted = head;
        ListNode previous, previousSort = head;

        int value;
        while (sorted != null) {
            tmp = head;
            previous = head;


            while (tmp != sorted && tmp.val < sorted.val) {
                previous = tmp;
                tmp = tmp.next;
            }
            if (tmp != sorted) {

                previous.next = tmp;
                previousSort.next = sorted.next;
                sorted.next = tmp;
            }
            previousSort = sorted;
            sorted = sorted.next;
        }
        return head;
    }
}
