package com.zhangjikai.sort;

/**
 * Created by zhangjk on 2017/8/21.
 */
public class SortInteger {

    public void sortInteger2(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int start = 0, end = array.length - 1;

        quickSort(array, start, end);
    }

    public void quickSort(int[] array, int start, int end) {
        if (start > end) {
            return;
        }
        int center = partition(array, start, end);
        quickSort(array, start, center - 1);
        quickSort(array, center + 1, end);
    }

    public int partition(int[] array, int start, int end) {
        int target = array[start];
        while (start < end) {
            while (start < end && array[end] >= target) {
                end--;
            }
            array[start++] = array[end];
            while (start < end && array[start] < target) {
                start++;
            }
            array[end--] = array[start];
        }
        array[start] = target;
        return start;
    }
}
