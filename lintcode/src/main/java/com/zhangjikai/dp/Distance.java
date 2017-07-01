package com.zhangjikai.dp;

/**
 * Created by Jikai Zhang on 2017/7/1.
 */
public class Distance {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) {
            if (word2 == null) {
                return 0;
            } else {
                return word2.length();
            }
        }
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }

        char[] firstCharArray = word1.toCharArray();
        char[] secondCharArray = word2.toCharArray();
        int rowLen = firstCharArray.length;
        int columnLen = secondCharArray.length;
        int[][] disMatrix = new int[rowLen + 1][columnLen + 1];
        for (int i = 0; i <= rowLen; i++) {
            disMatrix[i][0] = i;
        }
        for (int j = 0; j <= columnLen; j++) {
            disMatrix[0][j] = j;
        }
        int diagScore, topScore, leftScore;
        for (int i = 1; i <= rowLen; i++) {
            for (int j = 1; j <= columnLen; j++) {
                diagScore = firstCharArray[i - 1] == secondCharArray[j - 1]
                        ? disMatrix[i - 1][j - 1] : disMatrix[i - 1][j - 1] + 1;
                topScore = disMatrix[i - 1][j] + 1;
                leftScore = disMatrix[i][j - 1] + 1;
                disMatrix[i][j] = Math.min(diagScore, leftScore);
                disMatrix[i][j] = Math.min(disMatrix[i][j], topScore);
            }
        }

        return disMatrix[rowLen][columnLen];
    }
}
