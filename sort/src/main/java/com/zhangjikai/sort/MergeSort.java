package com.zhangjikai.sort;

import java.util.List;

/**
 * Created by Jikai Zhang on 2017/3/31.
 */
public class MergeSort<T extends Comparable> implements Sort<T> {

    @Override
    public List<T> sort(List<T> randomData) {

        mSort(randomData, 0, randomData.size() - 1);
        return randomData;
    }

    private void mSort(List<T> randomData, int start, int end) {
        if (start >= end) {
            return;
        }
        int center = (start + end) / 2;
        mSort(randomData, start, center);
        mSort(randomData, center + 1, end);
        merge(randomData, start, center, end);
        //System.out.println(randomData);

    }

    private void merge(List<T> randomData, int start, int center, int end) {
        T copies[] = (T[]) new Comparable[end - start + 1];
        int i = start, j = center + 1;
        int index = 0;
        T left, right;
        while (i <= center && j <= end) {
            left = randomData.get(i);
            right = randomData.get(j);
            if (left.compareTo(right) <= 0) {
                copies[index++] = left;
                i++;
            } else {
                copies[index++] = right;
                j++;
            }
        }

        while (i <= center) {
            copies[index++] = randomData.get(i++);
        }
        while (j <= end) {
            copies[index++] = randomData.get(j++);
        }


        System.out.printf("%d %d %d copies: ", start, center, end);
        for (T t : copies) {
            System.out.print(t + " ");
        }
        System.out.println();

        index = 0;
        for (i = start; i <= end; i++) {
            randomData.set(i, copies[index++]);
        }

    }
}
