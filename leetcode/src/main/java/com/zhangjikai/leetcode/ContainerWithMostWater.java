package com.zhangjikai.leetcode;

/**
 * Created by ZhangJikai on 2017/2/17.
 */
public class ContainerWithMostWater {


    /**
     * O(n)
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int area = 0;

        int length = height.length;
        int i = 0, j = length - 1;
        while (i < j) {

            if(height[i] < height[j]) {
                // 假设 i 是短板，那么我们不会再找到一个 jj 比 j 更大，所以 i 的最大值已经找到了
                area = (j - i) * height[i];
                i++;
            } else if(height[i] > height[j]) {
                area = (j - i) * height[j];
                j--;
            } else {
                area = (j - i) * height[i];
                i++;
                j--;
            }

            if(area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    /**
     * 暴力解法，超时
     *
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int length = height.length;
        int maxArea = 0;
        int area = 0;
        int minHeight;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                minHeight = height[i] > height[j] ? height[j] : height[i];
                area = (j - i) * minHeight;
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }
}
