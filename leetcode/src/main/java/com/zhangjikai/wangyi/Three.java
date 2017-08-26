package com.zhangjikai.wangyi;

import java.util.Scanner;

/**
 * Created by zhangjk on 2017/8/12.
 */
public class Three {

    static long modNum = 0;
    static long kNum = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        modNum = calModNum(k);
        kNum = (k * k + k) / 2;
        long result = cal(n, k);
        System.out.println(result % 1000000007);
    }


    public static  long cal(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return cal(n - 1, k) + modNum + kNum;
    }

    public static long calModNum(int k) {
        long total = 0;
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j != 0) {
                    total++;
                }
            }
        }
        return total;


    }
}
