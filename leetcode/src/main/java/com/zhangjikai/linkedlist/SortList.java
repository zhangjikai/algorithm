package com.zhangjikai.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Jikai Zhang on 2017/3/31.
 */
public class SortList {


    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            //System.out.println(1111);
            return head;
        }
        //System.out.println(head.val);

        ListNode fastNode = head, slowNode = head;
        while (fastNode.next != null && fastNode.next.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        //System.out.println(slowNode.val);

        ListNode rightNode = sortList(slowNode.next);
        slowNode.next = null;
        ListNode leftNode = sortList(head);
        head = merge(leftNode, rightNode);
        return head;
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                tmp.next = left;
                left = left.next;

            } else {
                tmp.next = right;
                right = right.next;
            }
            tmp = tmp.next;
        }

        if (left != null) {
            tmp.next = left;
        }

        if (right != null) {
            tmp.next = right;
        }
        return head.next;
    }

    public ListNode sortList2(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            list.add(tmp.val);
            tmp = tmp.next;
        }
        Collections.sort(list);

        tmp = head;
        int index = 0;
        while (tmp != null) {
            tmp.val = list.get(index++);
            tmp = tmp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{3, 2, 1, 4};

        ListNode node = new ListNode(0);
        ListNode tmp = node;
        for (int i : arr) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }
        ListNode results = new SortList().sortList(node.next);
        while (results != null) {
            System.out.println(results.val);
            results = results.next;
        }
    }
}
