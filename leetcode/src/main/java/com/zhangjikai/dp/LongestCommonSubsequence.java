package com.zhangjikai.dp;

import java.util.Scanner;

/**
 * Created by Jikai Zhang on 2017/3/29.
 */
public class LongestCommonSubsequence {
    public static int lcs(String a, String b) {
        if (a == null || b == null || a.length() == 0 || b.length() == 0) {
            return 0;
        }
        int len[][] = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                len[i][j] = 0;
            }
        }

        //int match = 0;

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {

                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    len[i][j] = len[i - 1][j - 1] + 1;
                } else {
                    len[i][j] = Math.max(len[i][j - 1], len[i - 1][j]);
            }

            }
        }
        return len[a.length()][b.length()];
    }

    public static void main(String[] args) {
        /*String a = "programming";
        String b = "contest";
        System.out.println(new LongestPalindromicSubsequence().longestPalindromeSubseq(a, b))*/;


        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String a = scanner.next();
            String b = scanner.next();
            System.out.println(lcs(a, b));
        }
    }


}
