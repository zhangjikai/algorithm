package com.zhangjikai.yuanjing;

import java.util.Scanner;

/**
 * Created by zhangjk on 2017/8/8.
 */
public class Two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 20;
        String[] border = new String[size];
        char black = '*';
        char white = '+';
        char blank = '.';
        while (scanner.hasNext()) {
            for (int i = 0; i < size; i++) {
                border[i] = scanner.nextLine();
            }

            char nowChar;
            int count = 1;
            boolean canBreak = false;
            for (int i = 0; i < size; i++) {
                nowChar = border[i].charAt(0);
                count = 1;
                for (int j = 0; j < size; j++) {
                    if (nowChar == blank) {
                        nowChar = border[i].charAt(j);
                        count = 1;
                        continue;
                    }
                    if (nowChar == border[i].charAt(j)) {
                        count++;
                        canBreak = true;
                        System.out.println(true);
                        break;
                    } else {
                        nowChar = border[i].charAt(j);
                        count = 1;
                    }
                }
                if (canBreak) {
                    break;
                }
            }

            if (!canBreak) {
                for (int j = 0; j < size; j++) {
                    nowChar = border[0].charAt(j);
                    count = 1;
                    for (int i = 0; i < size; i++) {
                        if (nowChar == blank) {
                            nowChar = border[j].charAt(i);
                            count = 1;
                            continue;
                        }
                        if (nowChar == border[j].charAt(i)) {
                            count++;
                            canBreak = true;
                            System.out.println(true);
                            break;
                        } else {
                            nowChar = border[j].charAt(i);
                            count = 1;
                        }
                    }
                    if (canBreak) {
                        break;
                    }
                }
            }

            if (!canBreak) {
                System.out.println(false);
            }
        }
    }


}
