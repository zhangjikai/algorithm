package exam.wangyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ZhangJikai on 2017/3/24.
 */
public class BuyApple {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            List<Integer> times = new ArrayList<>();
            fetchTimes(num, times, 0);

            if (times.size() == 0) {
                System.out.println(-1);
                continue;
            }
            int min = 100;
            for (Integer i : times) {
                if (i < min) {
                    min = i;
                }
            }

            System.out.println(min);

        }
    }

    public static void fetchTimes(int rest, List<Integer> times, int index) {
        if (rest == 0) {
            times.add(index);
        }
        if (rest > 0) {
            index++;
            fetchTimes(rest - 8, times, index);
            fetchTimes(rest - 6, times, index);
        }
    }
}
