package com.zhangjikai.leetcode;

/**
 * Created by ZhangJikai on 2017/2/16.
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }
        int preX = x;
        int result = 0;
        while (x > 0) {
            result *= 10;
            result += (x % 10) ;
            x = x / 10;
        }

        if (result == preX) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean flag = new PalindromeNumber().isPalindrome(1001);
        System.out.println(flag);
    }
}
