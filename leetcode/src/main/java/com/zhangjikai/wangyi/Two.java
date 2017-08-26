package com.zhangjikai.wangyi;


import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhangjk on 2017/8/12.
 */
public class Two {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] xPoints = new int[n];
        int[] yPoints = new int[n];

        for (int i = 0; i < n; i++) {
            xPoints[i] = scanner.nextInt();

        }

        for (int i = 0; i < n; i++) {
            yPoints[i] = scanner.nextInt();
        }

        long[][] distance = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                distance[i][j] = Math.abs(xPoints[i] - xPoints[j]) + Math.abs(yPoints[i] - yPoints[j]);
                distance[j][i] = distance[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            Arrays.sort(distance[i]);
        }

        System.out.print(0);
        for (int max = 2; max <= n; max++) {
            long min = Long.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                long count = 0;
                for (int j = 1; j < max; j++) {
                    count += distance[i][j];
                }
                min = Math.min(min, count);
            }
            System.out.print(" " + min);
        }
        System.out.println();
    }
}
