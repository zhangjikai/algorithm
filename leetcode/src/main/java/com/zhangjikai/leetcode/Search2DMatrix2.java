package com.zhangjikai.leetcode;

/**
 * Created by Jikai Zhang on 2017/6/22.
 */
public class Search2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null)
            return false;
        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }
        int columns = matrix[0].length;
        if(columns == 0) {
            return false;
        }

        int i = 0;
        int j = columns - 1;
        while (i < rows && j >= 0) {
            if(matrix[i][j] == target) {
                return true;
            }
            if(matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
