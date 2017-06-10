package com.zhangjikai.dp;

import java.util.*;

/**
 * Created by Jikai Zhang on 2017/5/26.
 */
public class SubSets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<Integer>());
        if (nums.length == 0) {
            return subsets;
        }

        Arrays.sort(nums);
        Set<String> set = new HashSet<>();
        String key;
        List<Integer> tmp;
        int length;
        for (int i = 0; i < nums.length; i++) {
            //System.out.println(subsets.size());
            length = subsets.size();

            for (int j = 0; j < length; j++) {
                tmp = new ArrayList<>(subsets.get(j));
                tmp.add(nums[i]);
                key = listToString(tmp);
                if(!set.contains(key)) {
                    subsets.add(tmp);
                    set.add(key);
                }

            }
        }
        return subsets;
    }

    public static String listToString(List<Integer> list) {
        StringBuilder builder = new StringBuilder();
        for(Integer integer : list) {
            builder.append(integer);
            builder.append(" ");
        }
        return builder.toString();
    }
}
