package com.zhangjikai.greedy;

/**
 * Created by Jikai Zhang on 2017/6/25.
 */
public class BusSellStock {
    public int maxProfit(int[] prices) {

        if(prices.length == 0) {
            return 0;
        }

        int diff = 0;
        int maxDiff = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < min) {
                min = prices[i];
            }
            diff = prices[i] - min;
            if(diff > maxDiff) {
                maxDiff = diff;
            }
        }
        return maxDiff;
    }
}
