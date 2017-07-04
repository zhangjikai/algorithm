package com.zhangjikai.heap;

/**
 * Created by zhangjk on 2017/7/3.
 */
public class Median {

    public int median(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int center = (nums.length - 1) / 2;

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int p = quickSearch(left, right, nums);
            if (p == center) {
                return nums[p];
            } else if (p < center) {
                left = p + 1;
            } else {
                right = p - 1;
            }
        }
        return -1;

    }

    public int quickSearch(int low, int high, int[] nums) {
        int selected = nums[low];

        while (low < high) {
            while (low < high && nums[high] >= selected) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= selected) {
                low++;
            }
            nums[high] = nums[low];
        }

        nums[low] = selected;
        return low;
    }


    public static void main(String[] args) {
        System.out.println(new Median().median(new int[]{-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-1000}));
    }
}
