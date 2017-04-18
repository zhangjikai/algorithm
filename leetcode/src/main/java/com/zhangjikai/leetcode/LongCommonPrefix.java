package com.zhangjikai.leetcode;

/**
 * Created by ZhangJikai on 2017/2/21.
 */
public class LongCommonPrefix {


    public String longestCommonPrefix(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }

        if (strings.length == 1) {
            return strings[0];
        }


        String prefix = strings[0];
        int prefixLen = prefix.length();
        int tmpLen = 0;


        for (int i = 0; i < strings.length; i++) {
            prefixLen = strings[i].length() < prefixLen ? strings[i].length() : prefixLen;
            tmpLen = 0;
            for (int j = 0; j < prefixLen; j++) {
                if (prefix.charAt(j) == strings[i].charAt(j)) {
                    tmpLen++;
                } else {
                    break;
                }
            }
            prefixLen = tmpLen;
        }

        return strings[0].substring(0, tmpLen);
    }
}
