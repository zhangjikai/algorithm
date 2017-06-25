package com.zhangjikai.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jikai Zhang on 2017/6/25.
 */
public class BuySellStock3 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int min = prices[0];
        int max = prices[0];
        for (int i = 1; i < prices.length; i++) {

            if (prices[i] > max) {
                max = prices[i];
            }
            left[i] = max - min;

            if (prices[i] < min) {
                min = prices[i];
                max = prices[i];
            }
        }

        min = prices[prices.length - 1];
        max = prices[prices.length - 1];
        for (int j = prices.length - 2; j >= 0; j--) {

            if (prices[j] < min) {
                min = prices[j];
            }
            right[j] = max - min;

            if (prices[j] > max) {
                max = prices[j];
                min = prices[j];
            }
        }

        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {

            total = Math.max(total, left[i] + right[i + 1]);
        }
        total = Math.max(total, left[prices.length - 1]);
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new BuySellStock3().maxProfit(new int[]{7,11,4,1,2}));
    }

   /* public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int leftMax = 0;
        int rightMax = 0;
        int totalMax = 0;
        int tmpTotal = 0;
        for (int i = 0; i < prices.length; i++) {
            leftMax = getMaxDiff(0, i, prices);
            rightMax = getMaxDiff(i, prices.length, prices);
            tmpTotal = leftMax + rightMax;
            if (tmpTotal > totalMax) {
                totalMax = tmpTotal;
            }

        }
        return totalMax;
    }

    public int getMaxDiff(int start, int end, int[] prices) {
        if (start >= end) {
            return 0;
        }

        int diff = 0;
        int maxDiff = 0;
        int min = prices[start];
        for (int i = start; i < end; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            diff = prices[i] - min;
            if (diff > maxDiff) {
                maxDiff = diff;
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        System.out.println(new BuySellStock3().maxProfit(new int[]{6,1,3,2,4,7,21,2,3,14,5,6,8,19,20,11,23,2,4,5,8}));
    }*/

    /*public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int total = 0;
        int min = 0;
        int diff = 0;
        boolean inBuy = true;
        int i;
        List<Integer> diffArray = new ArrayList<>();

        for (i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                if (inBuy) {
                    min = prices[i];
                    inBuy = false;
                }
            }

            if (prices[i] > prices[i + 1]) {
                if (!inBuy) {
                    diff = prices[i] - min;
                    diffArray.add(diff);
                    inBuy = true;
                }
            }
        }

        if (!inBuy) {
            if (prices[i] > min) {
                diffArray.add(prices[i] - min);
            }
        }
        if(diffArray.size() == 0) {
            return 0;
        }

        if(diffArray.size() == 1) {
            return diffArray.get(0);
        }

        int maxDiff = diffArray.get(0);
        int nextMaxDiff = diffArray.get(0);
        for(i = 1; i < diffArray.size(); i++) {
            if(diffArray.get(i) > maxDiff) {
                maxDiff = diffArray.get(i);
                continue;
            }

            if(diffArray.get(i) > nextMaxDiff) {
                nextMaxDiff = diffArray.get(i);
            }
        }

        return maxDiff + nextMaxDiff;
    }*/
   /* public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int total = 0;
        int diff = 0;
        int maxDiff = 0;
        int nextMaxDiff = 0;
        int min = prices[0];
        int maxIndex = 0;
        int nextMaxIndex = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            diff = prices[i] - min;
            if (diff > maxDiff) {
                maxDiff = diff;
                maxIndex = i;
                continue;
            }
            if(diff > nextMaxDiff) {
                nextMaxDiff = diff;
                nextMaxIndex = i;
            }
        }

        total += maxDiff;
        maxDiff = 0;
        maxIndex += 1;
        if (maxIndex < prices.length) {
            min = prices[maxIndex];
            for (int i = maxIndex + 1; i < prices.length; i++) {
                if (prices[i] < min) {
                    min = prices[i];
                }
                diff = prices[i] - min;
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }
        total += maxDiff;
        return total;
    }*/
}
