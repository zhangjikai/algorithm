package com.zhangjikai.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhangjk on 2017/7/24.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (results.size() == 0) {
                results.add(nums[i]);
                continue;
            }
            int index = search(results, nums[i]);
            if(index == results.size()) {
                results.add(nums[i]);
            } else {
                results.set(index, nums[i]);
            }
        }
        System.out.println(results.size());
    }

    public static int search(List<Integer> results, int target) {
        int left = 0;
        int right = results.size();
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (results.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
