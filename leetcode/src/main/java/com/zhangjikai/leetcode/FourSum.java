package com.zhangjikai.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ZhangJikai on 2017/3/27.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> threeList = threeSum(nums, target - nums[i], i + 1);
            for (List<Integer> list : threeList) {
                list.add(nums[i]);
                results.add(list);
            }

            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }

        }
        return results;
    }

    public List<List<Integer>> threeSum(int[] nums, int target, int start) {
        List<List<Integer>> results = new ArrayList<>();
        for (int i = start; i < nums.length; i++) {
            List<List<Integer>> twoList = twoSum(nums, target - nums[i], i + 1);
            for (List<Integer> list : twoList) {
                list.add(nums[i]);
                results.add(list);
            }

            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return results;
    }

    public List<List<Integer>> twoSum(int[] nums, int target, int start) {
        int end = nums.length - 1;
        int sum = 0;
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> tmp;
        while (start < end) {
            sum = nums[start] + nums[end];


            if (sum > target) {
                end--;
                while (start < end && end < nums.length - 1 && nums[end] == nums[end + 1]) {
                    end--;
                }
            }
            if (sum < target) {
                start++;
                while (start < end && nums[start] == nums[start - 1]) {
                    start++;
                }
            }
            if (sum == target) {
                tmp = new ArrayList<>();
                tmp.add(nums[start]);
                tmp.add(nums[end]);
                results.add(tmp);
                start++;
                end--;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int array[] = new int[]{1, 0, -1, 0, -2, 2};

        array = new int[]{-1,2,2,-5,0,-1,4};
        System.out.println(new FourSum().fourSum(array, 3));
    }
}
