package com.zhangjikai.sort;

import java.util.Comparator;
import java.util.List;

/**
 * Created by ZhangJikai on 2017/2/28.
 */
public interface Sort<T extends Comparable> {
    public List<T> sort(List<T> randomData);
}
