package com.zhangjikai.leetcode;

/**
 * Created by Jikai Zhang on 2017/6/22.
 */
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        if (rows == 0 || columns == 0) {
            return false;
        }

        int start = 0;
        int end = rows - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (matrix[mid][columns - 1] == target) {
                return true;
            }
            if (matrix[mid][columns - 1] > target) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }

        int targetRow = mid;
        start = 0;
        end = columns - 1;
        while (start <= end) {
            mid = (start + end) / 2;
            if(matrix[targetRow][mid] == target) {
                return true;
            }
            if(matrix[targetRow][mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        targetRow += 1;
        if(targetRow >= rows) {
            return false;
        }
        start = 0;
        end = columns - 1;
        while (start <= end) {
            mid = (start + end) / 2;
            if(matrix[targetRow][mid] == target) {
                return true;
            }
            if(matrix[targetRow][mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
