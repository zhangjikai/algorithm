package com.zhangjikai.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jikai Zhang on 2017/6/10.
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> queens = new ArrayList<>();
        if (n == 0) {
            return queens;
        }

        int[] rowValues = new int[n];
        boolean[] columns = new boolean[n];
        boolean[] leftDiag = new boolean[2 * n - 1];
        boolean[] rightDiag = new boolean[2 * n - 1];
        solver(0, rowValues, columns, leftDiag, rightDiag, queens);
        return queens;
    }

    public boolean canSet(int i, int j, boolean[] columns, boolean[] leftDiag, boolean[] rightDiag) {
        return !(columns[j] || leftDiag[columns.length - i + j] || rightDiag[i + j]);
    }

    public void solver(int rowIndex, int[] rowValues, boolean[] columns, boolean[] leftDiag, boolean[] rightDiag, List<List<String>> queens) {
        if (rowIndex == columns.length) {
            StringBuilder builder;
            List<String> single = new ArrayList<>();
            for (int i = 0; i < rowValues.length; i++) {
                builder = new StringBuilder();
                for (int j = 0; j < rowValues.length; j++) {
                    if (j == rowValues[i]) {
                        builder.append('Q');
                    } else {
                        builder.append('.');
                    }
                }
                single.add(builder.toString());
            }
            queens.add(single);
        }

        for (int j = 0; j < columns.length; j++) {
            if (canSet(rowIndex, j, columns, leftDiag, rightDiag)) {
                columns[j] = true;
                leftDiag[columns.length - rowIndex + j] = true;
                rightDiag[rowIndex + j] = true;
                rowValues[rowIndex] = j;
                solver(rowIndex + 1, rowValues, columns, leftDiag, rightDiag, queens);
                columns[j] = false;
                leftDiag[columns.length - rowIndex + j] = false;
                rightDiag[rowIndex + j] = false;
            }
        }
    }
}
