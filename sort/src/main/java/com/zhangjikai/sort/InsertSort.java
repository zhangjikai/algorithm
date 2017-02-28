package com.zhangjikai.sort;

import java.util.List;

/**
 * ≤Â»Î≈≈–Ú
 */
public class InsertSort<T extends Comparable> implements Sort<T> {


    @Override
    public List<T> sort(List<T> randomData) {
        T tmp, tmp2;
        int i, j;
        for (i = 1; i < randomData.size(); i++) {
            tmp = randomData.get(i);
            for (j = i - 1; j >= 0; j--) {
                tmp2 = randomData.get(j);
                if (tmp.compareTo(tmp2) >= 0) {

                    break;
                }
                randomData.set(j + 1, tmp2);
            }
            randomData.set(j + 1, tmp);
            // System.out.println(randomData);
        }
        return randomData;
    }
}
