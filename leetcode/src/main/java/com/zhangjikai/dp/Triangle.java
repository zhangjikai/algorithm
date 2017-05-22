package com.zhangjikai.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jikai Zhang on 2017/5/22.
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        int size = triangle.size();
        int[][] matrix = new int[size][size];
        matrix[0][0] = triangle.get(0).get(0);

        List<Integer> list;
        for (int i = 1; i < size; i++) {
            list = triangle.get(i);

            matrix[i][0] = matrix[i - 1][0] + list.get(0);

            for (int j = 1; j < list.size() - 1; j++) {
                matrix[i][j] = Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]) + list.get(j);
            }

            matrix[i][list.size() - 1] = matrix[i - 1][list.size() - 2] + list.get(list.size() - 1);
        }

        int lastRow = size - 1;
        int min = matrix[lastRow][0];
        for (int i = 1; i < matrix[lastRow].length; i++) {
            if (matrix[lastRow][i] < min) {
                min = matrix[lastRow][i];
            }
        }

        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> allList = new ArrayList<>();
        List<Integer> list = new ArrayList();
        list.add(2);
        allList.add(list);
        list = new ArrayList<>();
        list.add(3);
        list.add(4);
        allList.add(list);
        list = new ArrayList<>();
        list.add(6);
        list.add(5);
        list.add(7);
        allList.add(list);

        list = new ArrayList<>();
        list.add(4);
        list.add(1);
        list.add(8);
        list.add(3);
        allList.add(list);

        System.out.println(new Triangle().minimumTotal(allList));


    }
}
