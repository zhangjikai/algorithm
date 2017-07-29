package com.zhangjikai.math;

/**
 * Created by zhangjk on 2017/7/29.
 */
public class One {

    public int countOnes(int num) {
        if(num == 0) {
            return 0;
        }
        int total = 0;
        while((num = num & num-1) != 0) {
            total += 1;
        }
        total+=1;
        return total;
    }
}
