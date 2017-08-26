package com.zhangjikai.didi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhangjk on 2017/8/26.
 */
public class One {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numList = new ArrayList<>();
        while (scanner.hasNext()) {
            numList.add(scanner.nextInt());
        }
        int max = Integer.MIN_VALUE;
        boolean hasPos = false;
        for (int i : numList) {
            if (i > 0) {
                hasPos = true;
            }
            if (i > max) {
                max = i;
            }
        }

        if (!hasPos) {
            System.out.println(max);
        }

        int sum = 0;
        for (int i : numList) {
            if (sum < 0) {
                sum = i;
            } else {
                sum += i;
            }
            if(sum > max) {
                max = sum;
            }
        }
        System.out.println(max);
    }
}
