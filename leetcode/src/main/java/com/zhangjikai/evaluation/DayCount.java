package com.zhangjikai.evaluation;

/**
 * Created by zhangjk on 2017/8/26.
 */
public class DayCount {

    public static final int WEEK_DAY_NUM = 7;
    public static final int YEAR_MONTH_NUM = 12;
    public static final int[] NON_LEAP_MONTH_DAY = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static final int[] LEAP_MONTH_DAY = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int[] daysCount(int yearStart, int yearEnd, int yearFistDay, int targetDay) {
        int[] appearTimes = new int[WEEK_DAY_NUM];
        int[] monthDays;
        int dayIndex = yearFistDay;
        for (int yearIndex = yearStart; yearIndex < yearEnd; yearIndex++) {
            if (isLeapYear(yearIndex)) {
                monthDays = LEAP_MONTH_DAY;
            } else {
                monthDays = NON_LEAP_MONTH_DAY;
            }
            int weekIndex;
            for (int m = 0; m < YEAR_MONTH_NUM; m++) {
                weekIndex = (dayIndex + targetDay) % WEEK_DAY_NUM;
                appearTimes[weekIndex]++;
                dayIndex += monthDays[m];
            }
        }
        return appearTimes;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void main(String[] args) {
        DayCount dayCount = new DayCount();
        int N = 2;
        // 2017 年 1 月 1 日为周日，对应索引是 6
        // 17 号比 1号多 16天，所以要减 1
        int[] appearTimes = dayCount.daysCount(2017, 2017 + N, 6, 17 - 1);
        // 打印周一到周日
        for (int i : appearTimes) {
            System.out.println(i);
        }
    }
}
