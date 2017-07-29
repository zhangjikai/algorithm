package com.zhangjikai.sort;

/**
 * Created by zhangjk on 2017/7/29.
 */
public class MergeSort {

    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public void mergeSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);
        merge(array, start, mid, end);
    }

    public void merge(int[] array, int start, int mid, int end) {
        int i = start, j = mid + 1;
        int[] copied = new int[end - start + 1];
        int index = 0;
        while (i <= mid && j <= end) {
            if (array[i] > array[j]) {
                copied[index++] = array[j++];
            } else {
                copied[index++] = array[i++];
            }
        }

        while (i <= mid) {
            copied[index++] = array[i++];
        }

        while (j <= end) {
            copied[index++] = array[j++];
        }

        for (i = start; i <= end; i++) {
            array[i] = copied[i - start];
        }
    }


    public static void main(String[] args) {
        new MergeSort().sort(new int[]{3, 2, 11, 4, 8, 2, 3, 1});
    }
}
