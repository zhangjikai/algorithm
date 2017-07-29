package com.zhangjikai.string;

/**
 * Created by zhangjk on 2017/7/29.
 */
public class CommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // write your code here

        if (strs == null || strs.length == 0) {
            return "";
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if(strs[i].length() < min) {
                min = strs[i].length();
            }
        }

        StringBuilder builder = new StringBuilder();
        char c;
        boolean isSame;
        for(int i = 0; i < min; i++) {
            c = strs[0].charAt(i);
            isSame = true;
            for(int j = 1; j < strs.length; j++) {
                if(c != strs[j].charAt(i)) {
                    isSame= false;
                    break;
                }
            }
            if(!isSame) {
                break;
            }
            builder.append(c);
        }
        return builder.toString();
    }
}
