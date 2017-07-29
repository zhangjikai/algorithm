package com.zhangjikai.sort;

/**
 * Created by zhangjk on 2017/7/29.
 */
public class QuickSort {

    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public void quickSort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        int center = partition(array, left, right);
        quickSort(array, left, center-1);
        quickSort(array, center + 1, right);
    }

    public int partition(int[] array, int start, int end) {

        int target = array[start];
        while (start < end) {
            while (start < end && array[end] > target) {
                end--;
            }
            array[start] = array[end];
            while (start < end && array[start] <= target) {
                start++;
            }
            array[end] = array[start];
        }
        array[start] = target;
        return start;
    }

    public static void main(String[] args) {
        new QuickSort().sort(new int[]{0, 3, 2, 11, 4, 8, 2, 3, 1});
    }
}
