package com.zhangjikai.sort;

/**
 * Created by zhangjk on 2017/8/26.
 */
public class QSort {

    public void sortInteger2(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public void sort(int[] src, int start, int end) {
        if (start >= end) {
            return;
        }
        int storeIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (src[i] < src[start]) {
                storeIndex++;
                swap(src, storeIndex, i);
            }
        }
        swap(src, start, storeIndex);
        sort(src, start, storeIndex - 1);
        sort(src, storeIndex + 1, end);
    }

    public void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
