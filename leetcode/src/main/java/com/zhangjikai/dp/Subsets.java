package com.zhangjikai.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jikai Zhang on 2017/5/23.
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        if(nums ==null ) {
            return new ArrayList<>();
        }
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<Integer>());
        if(nums.length == 0) {
            return subsets;
        }

        List<Integer> tmp;
        int length;
        for(int i = 0; i < nums.length; i++) {
            //System.out.println(subsets.size());
            length = subsets.size();
            for(int j = 0; j < length; j++) {
                tmp = new ArrayList<>(subsets.get(j));
                tmp.add(nums[i]);
                subsets.add(tmp);
            }
        }
        return subsets;
    }

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1,2,3}));
    }
}
