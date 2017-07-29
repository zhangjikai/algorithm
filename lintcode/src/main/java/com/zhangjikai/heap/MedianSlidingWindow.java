package com.zhangjikai.heap;

import java.util.*;

/**
 * Created by zhangjk on 2017/7/3.
 */
public class MedianSlidingWindow {

    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> results = new ArrayList<>();
        if (nums == null || nums.length == 0 || k == 0) {
            return results;
        }

        if (nums.length < k) {
            int center = (nums.length - 1) / 2;
            results.add(nums[center]);
            return results;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        int maxHeapCount = (k + 1) / 2;
        int minHeapCount = k - maxHeapCount;
        for (int i = 0; i < nums.length; i++) {
            if ((maxHeap.size() == 0) || nums[i] <= maxHeap.peek()) {
                maxHeap.add(nums[i]);
            } else {
                minHeap.add(nums[i]);
            }
            // k = 2 时有可能出现 maxHeap 大于 minHeap
            if(minHeap.size() > 0 && maxHeap.peek() > minHeap.peek()) {
                minHeap.add(maxHeap.poll());
            }

            if (maxHeap.size() > maxHeapCount) {
                minHeap.add(maxHeap.poll());
            }

            if (minHeap.size() > minHeapCount) {
                maxHeap.add(minHeap.poll());
            }

            if (i >= k - 1) {
                results.add(maxHeap.peek());
                int previous = nums[i - k + 1];
                if(previous <= maxHeap.peek()) {
                    maxHeap.remove(previous);
                } else {
                    minHeap.remove(previous);
                }
            }

        }

        return results;
    }

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

    public ArrayList<Integer> medianSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> results = new ArrayList<Integer>();
        int[] tmpArray = new int[k];
        for (int i = 0; i <= nums.length - k; i++) {
            for (int j = i; j < i + k; j++) {
                tmpArray[j - i] = nums[j];
            }
            results.add(median(tmpArray));
        }
        return results;
    }

    public static void main(String[] args) {
        System.out.println(new MedianSlidingWindow().medianSlidingWindow(new int[]{1,2,7,7,2,10,3,4,5}, 2));
    }
}
