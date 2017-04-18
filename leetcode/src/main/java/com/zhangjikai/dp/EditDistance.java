package com.zhangjikai.dp;

/**
 * Created by Jikai Zhang on 2017/3/28.
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {

        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }
        int dis[][] = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dis[i][0] = i;
        }

        for (int i = 0; i <= word2.length(); i++) {
            dis[0][i] = i;
        }


        int match;
        int dig, left, top;
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                match = 1;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    match = 0;
                }
                dig = dis[i - 1][j - 1] + match;
                dis[i][j] = dis[i - 1][j] < dis[i][j - 1] ? dis[i - 1][j] : dis[i][j - 1];
                dis[i][j] += 1;
                dis[i][j] = dis[i][j] < dig ? dis[i][j] : dig;
                /*left = dis[i][j - 1] + 1;
                top = dis[i - 1][j] + 1;
                dig = dis[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1);
                dis[i][j] = Math.min(Math.min(left, top), dig);*/
            }
        }
        return dis[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        String a = "";
        String b = "1";

        a = "pneumonoultramicroscopicsilicovolcanoconiosis";
        b = "ultramicroscopically";
        System.out.println(new EditDistance().minDistance(a, b));
    }
}
