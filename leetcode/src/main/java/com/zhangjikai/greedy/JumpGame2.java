package com.zhangjikai.greedy;

/**
 * Created by Jikai Zhang on 2017/6/29.
 */
public class JumpGame2 {

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int maxDis = nums[0];
        int jumpCount = 1;
        int start = 0, end = 0;

        while (maxDis < nums.length - 1) {
            end = maxDis;
            for (int i = start; i <= end; i++) {
                maxDis = Math.max(maxDis, nums[i] + i);
            }
            start = end + 1;
            jumpCount++;


        }
        return jumpCount;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame2().jump(new int[]{2,3,2,4,1,3,1,2,4,5,1,2,3,1,2,3,4}));
    }
}
