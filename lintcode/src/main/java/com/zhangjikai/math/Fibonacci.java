package com.zhangjikai.math;

/**
 * Created by Jikai Zhang on 2017/7/1.
 */
public class Fibonacci {

    public int fibonacci(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int first = 0;
        int second = 1;
        int total = 0;
        for (int i = 2; i < n; i++) {
            total = first + second;
            first = second;
            second = total;

        }
        return total;
    }

}
