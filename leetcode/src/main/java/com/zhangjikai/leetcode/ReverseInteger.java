package com.zhangjikai.leetcode;

/**
 * Created by ZhangJikai on 2017/2/15.
 */
public class ReverseInteger {

    public int reverse(int x) {
        int newValue = 0;
        int oldValue = 0;
        while (x != 0) {
            newValue = newValue * 10 + x % 10;
            if (newValue / 10 != oldValue) {

                return 0;
            }
            oldValue = newValue;
            x = x / 10;
        }
        return newValue;
    }

    public int reverse2(int x) {

        String text = String.valueOf(x);
        char c = text.charAt(0);
        int end = 0;
        StringBuilder builder = new StringBuilder();
        if (c == '-') {
            builder.append("-");
            end = 1;
        }

        for (int i = text.length() - 1; i >= end; i--) {
            builder.append(text.charAt(i));
        }

        int result = 0;
        try {
            result = Integer.parseInt(builder.toString());
        } catch (Exception e) {
            result = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int i = new ReverseInteger().reverse(-123);
        System.out.println(i);
    }


}
