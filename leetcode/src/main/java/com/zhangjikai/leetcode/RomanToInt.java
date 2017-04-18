package com.zhangjikai.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhangJikai on 2017/2/21.
 */
public class RomanToInt {
    /**
     * 从后往前，前面的数大就加前面的数，前面的数小就减前面的数
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] chars = s.toCharArray();
        int c1, c2;
        int total = map.get(chars[chars.length - 1]);
        int i;

        for (i = chars.length - 1; i > 0; i--) {
            c1 = map.get(chars[i]);
            c2 = map.get(chars[i-1]);
            if(c1 > c2) {
                total +=  - c2;
            } else {
                total += c2;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int result = new RomanToInt().romanToInt("DMXCCICIMD");
        System.out.println(result);
    }
}
