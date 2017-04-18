package com.zhangjikai.leetcode;

/**
 * Created by ZhangJikai on 2017/2/13.
 */
public class Palindromic {


    /**
     * 枚举中心点
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {


        int maxLength = 1;
        int length;
        int left = 0, right = 0;
        int i, j;
        if (s == null || s.length() == 0) {
            return "";
        }

        if (s.length() == 1) {
            return s;
        }

        for (i = 0; i < s.length(); i++) {
            length = 1;
            // 奇数
            for (j = 1; (i - j >= 0) && (i + j < s.length()); j++) {
                if (s.charAt(i - j) == s.charAt(i + j)) {
                    length += 2;
                } else {
                    break;
                }
            }

            if (length > maxLength) {
                maxLength = length;
                left = i - j + 1;
                right = i + j - 1;
            }

            length = 0;
            // 偶数
            for (j = 0; (i - j >= 0) && (i + j + 1 < s.length()); j++) {
                if (s.charAt(i - j) == s.charAt(i + j + 1)) {
                    length += 2;
                } else {
                    break;
                }
            }

            if (length > maxLength) {
                maxLength = length;
                left = i - j + 1;
                right = i + j;
            }
        }

        return s.substring(left, right + 1);
    }

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public String longestPalindrome3(String s) {


        String maxString = "";
        int maxLength = 0;
        int length;

        if (s == null || s.length() == 0) {
            return "";
        }

        if (s.length() == 1) {
            return s;
        }
        boolean flags[][] = new boolean[s.length()][s.length()];
        for (int i = 1; i < s.length(); i++) {
            flags[i][i] = true;
            flags[i][i - 1] = true;

        }
        maxLength = 1;
        maxString = s.charAt(0) + "";
        for (int k = 2; k <= s.length(); k++) {
            for (int i = 0; i <= s.length() - k; i++) {
                if (flags[i + 1][i + k - 2] && s.charAt(i) == s.charAt(i + k - 1)) {
                    flags[i][i + k - 1] = true;
                    length = k;
                    if (length > maxLength) {
                        maxLength = length;
                        maxString = s.substring(i, i + k);
                    }
                }
            }
        }

        return maxString;
    }

    /**
     * 暴力破解
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        String maxString = "";
        int maxLength = 0;
        int length;
        boolean isPa = false;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                length = 0;
                isPa = true;
                for (int k = i, m = j; k <= j; k++, m--) {
                    if (s.charAt(k) == s.charAt(m)) {
                        length++;
                    } else {
                        isPa = false;
                        break;
                    }
                }
                if (isPa) {
                    if (length > maxLength) {
                        maxLength = length;
                        maxString = s.substring(i, j + 1);
                    }

                }
            }
        }
        return maxString;
    }

    public static void main(String[] args) {
        String s = new Palindromic().longestPalindrome("abcda");
        System.out.println(s);
    }
}
