package com.zhangjikai.array;

/**
 * Created by zhangjk on 2017/7/9.
 */
public class BinarySearch2 {
    public int binarySearch(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        int targetPos = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                targetPos = mid;
            }
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }


        while (targetPos > 0 && nums[targetPos] == nums[targetPos - 1]) {
            targetPos--;
        }

        return targetPos;
    }
}
