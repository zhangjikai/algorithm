package com.zhangjikai.linkedlist;

import com.zhangjikai.leetcode.PalindromeNumber;

/**
 * Created by Jikai Zhang on 2017/4/18.
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return true;
        }
        if(head.next.next == null) {
            return head.val == head.next.val;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode previous = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            previous = slow;
            slow = slow.next;

        }

        ListNode center = previous;

        previous = previous.next;
        ListNode current = previous.next;
        center.next = null;



        ListNode tmp;
        while (current != null) {
            if (current.next == null) {
                current.next = previous;
                break;
            }
            tmp = current.next;
            current.next = previous;
            previous = current;
            current = tmp;
        }

        ListNode start = head, end = current;

        while (start != null && end != null) {

            if (start.val != end.val) {

                return false;
            }
            start = start.next;
            end = end.next;
        }
        return true;
    }

    public static void main(String[] args) {
        int values[] = new int[]{1,2,3,4,5,6,7,8,7,6,5,4,3,2,1};
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for(int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        System.out.println(new PalindromeLinkedList().isPalindrome(head));
    }
}
