package com.zhangjikai.leetcode;

/**
 * Created by ZhangJikai on 2016/10/12.
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    indices[0] = i;
                    indices[1] = j;
                    return indices;
                }
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        int [] indices = new TwoSum().twoSum(nums, target);
        System.out.println(indices[0] + " " + indices[1]);
    }

}
