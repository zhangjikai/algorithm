package com.zhangjikai.wangyi;

import java.util.Scanner;

/**
 * Created by zhangjk on 2017/8/12.
 */
public class Three2 {

    static int totalN;
    static long totalCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        totalN = n;
        totalCount = 0;
        for(int i = 1; i <= k; i++) {
            cal(k, 1, i);
        }
        System.out.println(totalCount % 1000000007);
    }

    public static void cal(int k, int n, int num) {
        if (n == totalN) {
            totalCount++;
            return;
        }

        for (int i = 1; i <= k; i++) {
            if ( num <= i || num % i != 0) {
                cal(k, n + 1, i);
            }
        }

    }
}
