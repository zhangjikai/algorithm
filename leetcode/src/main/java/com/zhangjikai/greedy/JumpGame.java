package com.zhangjikai.greedy;

/**
 * Created by Jikai Zhang on 2017/6/26.
 *
 * https://leetcode.com/tag/greedy/
 */
public class JumpGame {


    public boolean canJump(int[] nums) {
        int reach = 0;
        for(int i = 0; i <= reach && i < nums.length; i++) {
            reach = Math.max(reach, nums[i] + i);
        }

        if( reach < nums.length - 1) {
            return false;
        }
        return true;
    }
    public boolean canJump2(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        if(nums.length == 1) {
            return true;
        }

        boolean hasZero = false;
        int zeroIndex = -1;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] == 0) {
                if(!hasZero) {
                    hasZero = true;
                    zeroIndex = i;

                }
                continue;
            }
            if(nums[i] > zeroIndex - i || (zeroIndex == nums.length-1 && nums[i] == zeroIndex - i)) {
                hasZero = false;
            }

        }
        return !hasZero;
    }
}
