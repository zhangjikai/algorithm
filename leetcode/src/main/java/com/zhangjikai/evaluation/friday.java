/*
ID: zjk111
LANG: JAVA
TASK: friday
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by zhangjk on 2017/8/26.
 */
public class friday {

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

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("friday.in"));
        PrintWriter pw = new PrintWriter(new File("friday.out"));
        int years = sc.nextInt();


        int freq[] = new friday().daysCount(1900, 1900 + years, 0, 13 - 1);
        pw.print(freq[5]);
        pw.print(' ');
        pw.print(freq[6]);
        pw.print(' ');
        pw.print(freq[0]);
        pw.print(' ');
        pw.print(freq[1]);
        pw.print(' ');
        pw.print(freq[2]);
        pw.print(' ');
        pw.print(freq[3]);
        pw.print(' ');
        pw.println(freq[4]);
        pw.close();
    }
}
