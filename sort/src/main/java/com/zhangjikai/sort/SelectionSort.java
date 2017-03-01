package com.zhangjikai.sort;

import java.util.List;

/**
 * 选择排序
 */
public class SelectionSort<T extends Comparable> implements Sort<T> {
    @Override
    public List<T> sort(List<T> randomData) {

        int minPos;
        T tmp;
        for(int i = 0; i < randomData.size(); i++) {
            minPos = i;
            for(int j = i + 1; j < randomData.size(); j++) {
                if(randomData.get(j).compareTo(randomData.get(minPos)) < 0) {
                    minPos = j;
                }
            }
            tmp = randomData.get(i);
            randomData.set(i, randomData.get(minPos));
            randomData.set(minPos, tmp);
        }
        return randomData;
    }
}
