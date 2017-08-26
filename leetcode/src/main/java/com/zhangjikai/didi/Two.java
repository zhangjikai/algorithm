package com.zhangjikai.didi;

import java.util.*;

/**
 * Created by zhangjk on 2017/8/26.
 */
public class Two {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        String s = scanner.nextLine();
        String kStr = scanner.nextLine();
        String[] array = s.split(" ");

        int[] nums = new int[array.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(array[i]);
        }
        int k = Integer.parseInt(kStr);
        //Arrays.sort(nums);
        System.out.println(find(k, nums));

    }

    public static int find(int k, int[] nums) {
        if (null == nums || k <= 0 || nums.length < k) return Integer.MIN_VALUE;
        findKMax(nums, 0, nums.length - 1, k);
        return nums[k - 1];
    }

    public static void findKMax(int[] nums, int left, int right, int k) {
        int mid = partition(nums, left, right);
        if (mid == k - 1) {
            return;
        }
        if (mid > k - 1) {
            findKMax(nums, left, mid - 1, k);
        } else {
            findKMax(nums, mid + 1, right, k);
        }
    }

    public static int partition(int[] nums, int left, int right) {
        int privot = nums[left];
        while (left < right) {
            while (left < right && nums[right] <= privot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] > privot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = privot;
        return left;
    }


}
