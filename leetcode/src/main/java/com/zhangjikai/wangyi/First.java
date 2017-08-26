package com.zhangjikai.wangyi;

import java.util.Scanner;

/**
 * Created by zhangjk on 2017/8/12.
 */
public class First {
    public static void main(String[] args) {
        int spent, fruitNum, fruitPrice, total;
        Scanner scanner = new Scanner(System.in);
        spent = scanner.nextInt();
        fruitNum = scanner.nextInt();
        total = scanner.nextInt();
        fruitPrice = scanner.nextInt();

        int max = 0;
        while (total / spent > fruitNum) {
            total -= fruitPrice;
            fruitNum++;
            int now  = Math.min(total / spent, fruitNum);
            max = Math.max(now, max);
        }
        System.out.println(max);
    }
}
