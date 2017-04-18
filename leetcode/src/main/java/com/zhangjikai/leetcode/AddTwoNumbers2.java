package com.zhangjikai.leetcode;

/**
 * Created by ZhangJikai on 2016/10/18.
 */
public class AddTwoNumbers2 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;

        ListNode p = l1, q = l2;
        int carry = 0, a, b, c;
        while (p != null || q != null) {
            a = p != null ? p.val : 0;
            b = q != null ? q.val : 0;
            c = a + b + carry;
            carry = c / 10;
            curr.next = new ListNode(c % 10);
            curr = curr.next;
            if(p != null ) p = p.next;
            if(q != null) q = q.next;
        }
        if(carry == 1) {
            curr.next = new ListNode(1);
        }
        return head.next;
    }
}
