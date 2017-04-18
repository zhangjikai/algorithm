package com.zhangjikai.leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangJikai on 2016/10/18.
 */
public class AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        ListNode node = l1;

        List<Integer> inputListA = new ArrayList<Integer>();
        List<Integer> inputListB = new ArrayList<Integer>();
        List<Integer> outputList = new ArrayList<Integer>();


        while (node != null) {

            inputListA.add(node.val);
            node = node.next;
        }



        //node = l2;
        //builder = new StringBuilder();
        node = l2;
        while (node != null) {

            inputListB.add(node.val);
            node = node.next;
        }


        int indexA, indexB, tmpIndex;
        int a, b, c, sign = 0;

        for(indexA = 0, indexB = 0;indexA < inputListA.size() && indexB < inputListB.size(); indexA++, indexB++) {
            a = inputListA.get(indexA);
            b = inputListB.get(indexB);
            c = a + b + sign;
            if(c > 9) {
                c = c -10;
                sign = 1;
            } else {
                sign = 0;
            }
            outputList.add(c);
        }

        if(sign == 1) {
            if(indexA == inputListA.size() && indexB == inputListB.size()) {
                outputList.add(1);
                sign = 0;
            } else if(indexA < inputListA.size() ) {
                for(tmpIndex = indexA; tmpIndex < inputListA.size(); tmpIndex++) {
                    a = inputListA.get(tmpIndex);
                    c = a + sign;
                    if(c > 9) {
                        c = c - 10;
                        sign = 1;
                    } else {
                        sign = 0;
                    }
                    outputList.add(c);
                }
            } else if(indexB < inputListB.size() ) {
                for(tmpIndex = indexB; tmpIndex < inputListB.size(); tmpIndex++) {
                    a = inputListB.get(tmpIndex);
                    c = a + sign;
                    if(c > 9) {
                        c = c - 10;
                        sign = 1;
                    } else {
                        sign = 0;
                    }
                    outputList.add(c);
                }
            }

            if(sign == 1) {
                outputList.add(1);
            }
        } else {
            if(indexA < inputListA.size() ) {
                for(tmpIndex = indexA; tmpIndex< inputListA.size(); tmpIndex++) {
                    outputList.add(inputListA.get(tmpIndex));
                }
            } else if(indexB < inputListB.size() ) {
                for(tmpIndex = indexA; tmpIndex< inputListB.size(); tmpIndex++) {
                    outputList.add(inputListB.get(tmpIndex));
                }
            }
        }



        ListNode firstNode = null;
        ListNode prevNode = null;
        ListNode lastNode = null;
        for (int i = 0; i < outputList.size(); i++) {
            if (i == 0) {
                firstNode = new ListNode(outputList.get(i));
                prevNode = firstNode;
            } else {
                lastNode = new ListNode(outputList.get(i));
                prevNode.next = lastNode;
                prevNode = lastNode;
            }
        }
        return firstNode;


    }

    public static void main(String[] args) {

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
