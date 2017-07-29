package com.zhangjikai.math;

import java.util.*;

/**
 * Created by zhangjk on 2017/7/29.
 */
public class DiceSum {


    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        List<Map.Entry<Integer, Double>> results = new ArrayList<>();
        if (n == 0) {
            return results;
        }

        int maxDiceCount = 6;
        long[][] appearTime = new long[2][n * maxDiceCount + 1];
        int flag = 0;

        for (int i = 1; i <= maxDiceCount; i++) {
            appearTime[flag][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                appearTime[1 - flag][j] = 0;
            }
            for (int j = i; j <= i * maxDiceCount; j++) {
                appearTime[1 - flag][j] = 0;
                for (int k = 1; k <= maxDiceCount; k++) {
                    if (j - k > 0) {
                        appearTime[1 - flag][j] += appearTime[flag][j - k];
                    }
                }

            }
            flag = 1 - flag;
        }

        //System.out.println(appearTime[flag]);
        double total = Math.pow(maxDiceCount, n);
//        for (int i = n; i <= n * maxDiceCount; i++) {
//            total += appearTime[flag][i];
//        }

        Map<Integer, Double> resultMap = new LinkedHashMap<>();
        for (int i = n; i <= n * maxDiceCount; i++) {
            if(i == 38) {
                System.out.println(appearTime[flag][i]);
            }
            resultMap.put(i, appearTime[flag][i] / total);
        }

        System.out.println(resultMap);
        results.addAll(resultMap.entrySet());
        return results;

    }

    public static void main(String[] args) {
        new DiceSum().dicesSum(15);
    }
}
