package com.zhangjikai.greedy;

/**
 * Created by Jikai Zhang on 2017/6/25.
 */
public class BuSellStock2 {

    public int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        int total = 0;
        for(int i = 1; i < prices.length; i++) {
            total += Math.max(prices[i] - prices[i-1], 0);
        }
        return total;
    }
    public int maxProfit2(int[] prices) {

        if(prices.length == 0) {
            return 0;
        }

        int total = 0;
        int min = 0;
        int diff = 0;
        boolean inBuy = true;
        int i;
        for(i = 0; i < prices.length - 1; i++) {
            if(prices[i] < prices[i+1]) {
                if(inBuy) {
                    min = prices[i];
                    inBuy = false;
                }
            }

            if(prices[i] > prices[i + 1]) {
                if(!inBuy) {
                    diff = prices[i] - min;
                    total += diff;
                    inBuy = true;
                }
            }
        }

        if(!inBuy) {
            if(prices[i] > min) {
                total += prices[i] - min;
            }
        }
        return total;
    }
}
