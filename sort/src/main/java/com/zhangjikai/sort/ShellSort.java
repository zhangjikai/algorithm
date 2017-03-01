package com.zhangjikai.sort;

import java.util.List;

/**
 * 希尔排序
 */
public class ShellSort<T extends Comparable> implements Sort<T> {
    @Override
    public List<T> sort(List<T> randomData) {
        int increase = randomData.size() / 2;

        T tmpI, tmpJ;
        int i, j, k;
        while (increase >= 1) {
            for (k = 0; k < increase; k++) {
                for (i = k; i < randomData.size(); i += increase) {
                    tmpI = randomData.get(i);
                    for (j = i - increase; j >= 0; j -= increase) {
                        tmpJ = randomData.get(j);
                        if (tmpI.compareTo(tmpJ) > 0) {
                            break;
                        }
                        randomData.set(j + increase, tmpJ);
                    }
                    randomData.set(j + increase, tmpI);
                }

            }
            //System.out.println(randomData);
            increase /= 2;
        }
        return randomData;
    }
}
