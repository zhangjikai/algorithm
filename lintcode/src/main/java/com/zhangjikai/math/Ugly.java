package com.zhangjikai.math;

/**
 * Created by zhangjk on 2017/7/29.
 */
public class Ugly {
    public int nthSuperUglyNumber(int n, int[] primes) {
        // Write your code here

        if (primes == null || primes.length == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int m = primes.length;
        int[] uglyArr = new int[n];
        int[] uglyIndexes = new int[m];

        for (int i = 0; i < uglyIndexes.length; i++) {
            uglyIndexes[i] = 0;
        }

        uglyArr[0] = 1;
        int index = 1;

        while (index < n) {
            int min = uglyArr[uglyIndexes[0]] * primes[0];
            for (int i = 1; i < m; i++) {
                int tmp = uglyArr[uglyIndexes[i]] * primes[i];
                if (tmp < min) {
                    min = tmp;
                }
            }

            uglyArr[index++] = min;

            for(int i = 0; i < m; i++) {
                while (uglyArr[uglyIndexes[i]] * primes[i] <= uglyArr[index-1]) {
                    uglyIndexes[i]++;
                }
            }
        }


        return uglyArr[index-1];
    }


}
