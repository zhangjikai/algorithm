package com.zhangjikai.pinduoduo;

/**
 * Created by zhangjk on 2017/7/12.
 */
public class Three {

    public int[][] genMatrix(int n) {
        int[][] result = new int[n][n];


        int layer;
        int k;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                layer = layer(i, j, n);
                k = n * n - (n - 2 * layer) * (n - 2 * layer) + 1;
                result[i][j] = k;
                if (i == layer) {
                    result[i][j] = k + j - layer;
                } else if (j == n - layer - 1) {
                    result[i][j] = k + (n - 2 * layer - 1) + i - layer;
                } else if (i == n - layer - 1) {
                    result[i][j] = k + 3 * (n - 2 * layer - 1) - (j - layer);
                } else {
                    result[i][j] = k + 4 * (n - 2 * layer - 1) - (i - layer);
                }
            }
        }

        return result;
    }

    public int layer(int x, int y, int n) {
        x = x < n - 1 - x ? x : n - 1 - x;
        y = y < n - 1 - y ? y : n - 1 - y;
        return x < y ? x : y;
    }

    public static void main(String[] args) {
        int[][] results = new Three().genMatrix(4);

        for(int i = 0; i < results.length; i++) {
            for(int j = 0; j < results[0].length; j++) {
                System.out.print(results[i][j] + " ");
            }
            System.out.println();
        }
    }
}
