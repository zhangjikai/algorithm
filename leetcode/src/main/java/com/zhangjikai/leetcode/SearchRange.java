package com.zhangjikai.leetcode;

/**
 * Created by Jikai Zhang on 2017/3/28.
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int end = nums.length - 1;
        int targetStart = -1;
        int targetEnd = -1;


        int index = search(start, end, target, nums);
        if (index != -1) {

            targetStart = index;
            targetEnd = index;
            while (targetStart > 0 && nums[targetStart-1] == target) {
                targetStart = search(start,targetStart-1, target, nums);
            }
            while (targetEnd < nums.length - 1 && nums[targetEnd + 1] == target) {
                targetEnd = search(targetEnd+1, end, target, nums);
            }

            /*while (targetStart > 0 && nums[targetStart - 1] == target) {
                targetStart--;
            }
            while (targetEnd < nums.length - 1 && nums[targetEnd + 1] == target) {
                targetEnd++;
            }*/
        }

        if (nums[0] == target) {
            targetStart = 0;
        }
        if (nums[nums.length - 1] == target) {
            targetEnd = nums.length - 1;
        }
        return new int[]{targetStart, targetEnd};
    }

    public int search(int start, int end, int target, int[] nums) {

        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{5, 7, 7, 8, 8, 10};
        nums = new int[]{2,2};
        SearchRange range = new SearchRange();
        int result[] = range.searchRange(nums, 2);
        System.out.println(result[0] + " " + result[1]);
    }
}
