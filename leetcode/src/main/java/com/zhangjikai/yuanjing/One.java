package com.zhangjikai.yuanjing;

import java.util.*;

/**
 * Created by zhangjk on 2017/8/8.
 */
public class One {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String badKey = scanner.nextLine();
        String text = scanner.nextLine();
        System.out.println('A' + 0);
        System.out.println('z' + 0);

        boolean badShift = badKey.contains("+");
        Set<String> keySet = new HashSet<>();
        for(char c : badKey.toCharArray()) {
            if (c >= 'A' && c <= 'z') {
                keySet.add(String.valueOf(c).toLowerCase());
            } else {
                keySet.add(String.valueOf(c));
            }
        }

        for(char c : text.toCharArray()) {
            if (badShift) {
                if (c < 'a' && c >= 'A') {
                    continue;
                }
            }
            if(c >= 'A' && c <= 'z') {
                if(keySet.contains(String.valueOf(c).toLowerCase())) {
                    continue;
                }
            } else {
                if(keySet.contains(String.valueOf(c))) {
                    continue;
                }
            }
            System.out.print(c);
        }
        System.out.println();
    }
}
