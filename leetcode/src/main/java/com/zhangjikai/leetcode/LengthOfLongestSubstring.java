package com.zhangjikai.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhangJikai on 2016/10/18.
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int currentLen = 0;
        int prePos = 0;
        int minPos = 0;
        Map<Character, Integer> posMap = new HashMap<>();
        Character c = null;
        for(int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(posMap.containsKey(c)) {

                prePos = posMap.get(c);

                if(prePos < minPos) {
                    currentLen++;
                    if(currentLen > maxLen) {
                        maxLen = currentLen;
                    }
                } else {
                    currentLen = i - prePos;
                    minPos = i - currentLen;
                }


            } else {

                currentLen++;
                if(currentLen > maxLen) {
                    maxLen = currentLen;
                }
            }

            posMap.put(c, i);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "pwwkewjkjkljlfdjgiojuoruetienm,ngkdfshjgiohdfgndkfgnksdnfgkjsndfkjgnkdsfgnjklsdjf";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
