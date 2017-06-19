package com.zhangjikai.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jikai Zhang on 2017/6/19.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> integers = new ArrayList<>();

        if (n == 0 || k == 0) {
            return integers;
        }
        int nums[] = new int[k];

        rec(n, k, 0, nums, 0, integers);
        return integers;
    }

    public void rec(int n, int k, int index, int[] nums, int count, List<List<Integer>> integers) {
        if (count == k) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            integers.add(list);
            return;
        }

        for (int i = index; i < n; i++) {
            nums[count] = i+1;
            count++;
            rec(n, k, i + 1, nums, count, integers);
            count--;
        }
    }
}
