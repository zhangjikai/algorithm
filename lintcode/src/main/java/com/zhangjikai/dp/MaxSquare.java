package com.zhangjikai.dp;

/**
 * Created by zhangjk on 2017/8/27.
 */
public class MaxSquare {
    public int maxSquare(int[][] matrix) {
        // write your code here
        if (matrix == null) {
            return 0;
        }
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return 0;
        }

        int res = -1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = min3(matrix[i - 1][j - 1], matrix[i - 1][j], matrix[i][j - 1]) + 1;
                }
                res = Math.max(res, matrix[i][j]);
            }
        }
        return res * res;
    }

    public int min3(int a, int b, int c) {
        if (a < b && a < c) {
            return a;
        } else if (b < c) {
            return b;
        } else {
            return c;
        }
    }
}
