package com.zhangjikai.array;

/**
 * Created by zhangjk on 2017/7/29.
 */
public class FastPower {

    public int fastPower(int a, int b, int n) {
        return (int) power(a, b, n) % b;
    }

    public int power(int a, int b, int n) {
        if (n == 1) {
            return a;
        }

        if (n == 0) {
            return 1;
        }

        long num = power(a, b, n / 2);
        num = (num * num) % b;
        if ((n & 0x1) == 1) {
            num = num * a % b;
        }
        return (int) num;
    }
}
