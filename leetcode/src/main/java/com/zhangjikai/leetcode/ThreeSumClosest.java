package com.zhangjikai.leetcode;

import java.util.Arrays;

/**
 * Created by ZhangJikai on 2017/3/23.
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int targetMin;
        int absMin = Integer.MAX_VALUE;
        int tmp, tmpMin = target;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            targetMin = twoSum(nums, target - nums[i], i + 1);
            tmp = Math.abs(targetMin);
            //System.out.println(tmp);
            if (tmp < absMin) {
                absMin = tmp;
                tmpMin = targetMin;
            }
        }
        return target - tmpMin;
    }

    public int twoSum(int[] nums, int target, int preIndex) {
        int start = preIndex;
        int end = nums.length - 1;
        int min = Integer.MAX_VALUE;
        int targetMin = Integer.MAX_VALUE;
        int sum, tmp;
        while (start < end) {
            sum = nums[start] + nums[end];
            if(sum < target) {
                tmp = target -sum;
                if(tmp < min) {
                    min = tmp;
                    targetMin = tmp;
                }
                start++;
            } else {
                tmp = sum - target;
                if(tmp < min) {
                    min = tmp;
                    targetMin = -tmp;
                }
                end--;
            }
        }
        return targetMin;

    }

    public static void main(String[] args) {
        ThreeSumClosest closest = new ThreeSumClosest();
        int values[] = new int[]{-1, 2, 1, -4};
        int target = closest.threeSumClosest(values, 1);
        System.out.println(target);

    }
}
