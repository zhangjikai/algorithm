package exam.wangyi;

import java.util.Scanner;

/**
 * Created by ZhangJikai on 2017/3/24.
 */
public class InverseNum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

           StringBuilder builder = new StringBuilder(String.valueOf(a));
            StringBuilder builder2 = new StringBuilder(String.valueOf(b));

            int num = Integer.parseInt(builder.reverse().toString());
            int num2 = Integer.parseInt(builder2.reverse().toString());
            int total = num + num2;
            total = Integer.parseInt(new StringBuilder(String.valueOf(total)).reverse().toString());
            System.out.println(total);

        }
    }
}
