package com.zhangjikai.array;

/**
 * Created by zhangjk on 2017/7/5.
 */
public class MergeSortedArray {

    public int[] mergeSortedArray(int[] A, int[] B) {

        if(A == null || A.length == 0) {
            return B;
        }

        if(B == null || B.length == 0) {
            return A;
        }
        int i = 0, j = 0;
        int[] sortedArray = new int[A.length +B.length];
        int index = 0;
        while (i < A.length && j < B.length) {
            if(A[i] < B[j]) {
                sortedArray[index++] = A[i];
                i++;
            } else {
                sortedArray[index++] = B[j];
                j++;
            }
        }

        while (i < A.length) {
            sortedArray[index++] = A[i++];
        }

        while (j < B.length) {
            sortedArray[index++] = B[j++];
        }
        return sortedArray;
    }
}
