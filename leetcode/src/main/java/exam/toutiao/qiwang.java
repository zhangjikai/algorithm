package exam.toutiao;

import java.util.Scanner;

/**
 * Created by Jikai Zhang on 2017/3/30.
 */
public class qiwang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int values[] = new int[n];
        double props[] = new double[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            props[i] = scanner.nextInt();
        }
        double total = 0;
        for(int i = 0; i < n; i++) {
            total += values[i] * props[i] / 100;
        }
        System.out.printf("%.3f\n", total);
    }
}

