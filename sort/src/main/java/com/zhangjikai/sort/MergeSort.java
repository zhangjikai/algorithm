package com.zhangjikai.sort;

import java.util.List;

/**
 * Created by Jikai Zhang on 2017/3/31.
 */
public class MergeSort<T extends Comparable> implements Sort<T> {

    @Override
    public List<T> sort(List<T> randomData) {

        //recursiveSort(randomData, 0, randomData.size() - 1);


        nonRecursiveSort(randomData);
        return randomData;
    }

    /**
     * 递归实现
     *
     * @param randomData
     * @param start
     * @param end
     */
    private void recursiveSort(List<T> randomData, int start, int end) {
        if (start >= end) {
            return;
        }
        int center = (start + end) / 2;
        recursiveSort(randomData, start, center);
        recursiveSort(randomData, center + 1, end);
        merge(randomData, start, center, end);
        //System.out.println(randomData);
    }

    /**
     * 非递归实现
     *
     * @param randomData
     */
    private void nonRecursiveSort(List<T> randomData) {

        int interval = 1;
        int size = randomData.size();
        int start, end;
        int len;
        while (interval <= size) {
            start = 0;
            len = interval * 2;

            while (start + len < randomData.size()) {
                merge(randomData, start, start + interval - 1, start + len - 1);
                start += len;
            }

            // 最后剩余的不等长的两个区间进行合并
            if (start + interval < randomData.size()) {
                merge(randomData, start, start + interval - 1, randomData.size() - 1);
            }


            interval *= 2;
        }
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

        index = 0;
        for (i = start; i <= end; i++) {
            randomData.set(i, copies[index++]);
        }
    }
}
