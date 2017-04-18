package exam.wangyi;

import java.util.Scanner;

/**
 * Created by ZhangJikai on 2017/3/24.
 */
public class Sugar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double eps = 1e-10;
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int num2 = scanner.nextInt();
            int num3 = scanner.nextInt();
            int num4 = scanner.nextInt();

            double a = ((double) num + num3) / 2;
            double b = a - num;
            double c = b - num2;
            double d = num4 - b;

            if (a >= 0 && b >= 0 && c >= 0 && a - (int) a < eps && b - (int) b < eps && c - (int) c < eps && (int)d == (int)c) {
                System.out.printf("%d %d %d\n", (int) a, (int) b, (int) c);
            } else {
                System.out.println("No");
            }
        }
    }
}
