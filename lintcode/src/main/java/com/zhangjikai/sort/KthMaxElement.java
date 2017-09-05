package com.zhangjikai.sort;

/**
 * Created by zhangjk on 2017/8/21.
 */
public class KthMaxElement {
    public int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;
        int target = nums[0];

        while (true) {
            while (start < end) {
                while (start < end && nums[end] >= target) {
                    end--;
                }
                nums[start] = nums[end];
                while (start < end && nums[start] < target) {
                    start++;
                }

                nums[end] = nums[start];
            }
            nums[start] = target;
            if (start > k) {
                start = 0;
                end = start;
            }
            if (start < k) {
                end = nums.length - 1;
            }
            if (start == k) {
                return nums[start];
            }
        }
    }
}
