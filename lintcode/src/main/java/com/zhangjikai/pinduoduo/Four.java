package com.zhangjikai.pinduoduo;

/**
 * Created by zhangjk on 2017/7/12.
 */
public class Four {

    public static int search(int[] array) {
        int left = 0, right = array.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (array[mid - 1] >= array[mid] && array[mid + 1] >= array[mid]) {
                return mid;
            } else if (array[mid - 1] >= array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1,32,3,4}));
    }
}
