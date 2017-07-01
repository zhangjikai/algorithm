package com.zhangjikai.dp;

/**
 * Created by Jikai Zhang on 2017/7/1.
 */
public class Match {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        char single = '.';
        char many = '*';
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        int sLen = sArray.length;
        int pLen = pArray.length;
        boolean[][] matchMatrix = new boolean[sLen + 1][pLen + 1];
        matchMatrix[0][0] = true;

        for (int j = 2; j <= pLen; j += 2) {
            if (pArray[j - 1] == many) {
                matchMatrix[0][j] = matchMatrix[0][j - 2];
            }
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (sArray[i - 1] == pArray[j - 1] || pArray[j - 1] == single) {
                    matchMatrix[i][j] = matchMatrix[i - 1][j - 1];
                    continue;
                }

                if (pArray[j - 1] == many && j - 2 >= 0) {
                    if (pArray[j - 2] != single && pArray[j - 2] != sArray[i - 1]) {
                        matchMatrix[i][j] = matchMatrix[i][j - 2];
                    } else {
                        matchMatrix[i][j] = matchMatrix[i - 1][j] || matchMatrix[i][j - 2];
                    }

                }

            }
        }

        return matchMatrix[sLen][pLen];
    }
}
