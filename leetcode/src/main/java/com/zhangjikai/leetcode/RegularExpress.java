package com.zhangjikai.leetcode;

/**
 * Created by ZhangJikai on 2017/2/16.
 */
public class RegularExpress {


    public boolean isMatch(String s, String p) {
        char sourChars[] = s.toCharArray();
        char destChars[] = p.toCharArray();

        char any = '.';
        char many = '*';

        boolean[][] dp = new boolean[sourChars.length + 1][destChars.length + 1];
        dp[0][0] = true;


        for (int j = 1; j <= destChars.length; j++) {

            if (destChars[j - 1] == many && j >= 2) {
                dp[0][j] = dp[0][j - 2];
                continue;
            }
            /*dp[0][j] = false;*/
        }
        for (int i = 1; i <= sourChars.length; i++) {

            for (int j = 1; j <= destChars.length; j++) {

                if (sourChars[i - 1] == destChars[j - 1] || destChars[j - 1] == any) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }

                if (destChars[j - 1] == many) {
                    dp[i][j] = ((destChars[j - 2] == sourChars[i - 1] || destChars[j - 2] == any) && dp[i - 1][j]) || dp[i][j - 2];
                }
            }
        }

        return dp[sourChars.length][destChars.length];
    }

    public boolean isMatch2(String s, String p) {

        char sourChars[] = s.toCharArray();
        char destChars[] = p.toCharArray();
        int sLength = sourChars.length;
        int dLength = destChars.length;

        char any = '.';
        char many = '*';
        char preChar = 0;
        int sIndex = 0, dIndex = 0;

        while (dIndex < dLength && sIndex < sLength) {

            if (destChars[dIndex] == any || sourChars[sIndex] == destChars[dIndex]) {
                preChar = destChars[dIndex];
                sIndex++;
                dIndex++;
                continue;
            }

            if (destChars[dIndex] == many) {
                if (preChar != any) {
                    if (preChar != sourChars[sIndex]) {
                        dIndex++;
                        continue;
                    }
                    dIndex++;
                    while (sIndex < sLength) {
                        if (preChar != sourChars[sIndex]) {
                            break;
                        }
                        sIndex++;
                    }
                    while (dIndex < dLength) {
                        if (preChar != destChars[dIndex]) {
                            break;
                        }
                        dIndex++;
                    }
                    continue;
                } else {

                }


            }

            if (dIndex + 1 < dLength && destChars[dIndex + 1] != many) {
                break;
            } else {
                dIndex++;
            }
        }

        //System.out.println(dIndex);
        //System.out.println(sIndex);

        if (dIndex == dLength && sIndex == sLength) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String a = "aaaaaaabb";
        String b = "aaa*b*";
        boolean flag = new RegularExpress().isMatch(a, b);
        System.out.println(flag);
    }
}
