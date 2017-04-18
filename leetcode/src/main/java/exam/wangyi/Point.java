package exam.wangyi;


import java.util.Scanner;

/**
 * Created by ZhangJikai on 2017/3/24.
 */
public class Point {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double eps = 1e-10;
        while (scanner.hasNext()) {
            int area = scanner.nextInt();

            double radius = Math.sqrt(area);
            double len = 0;
            long count = 0;
            for(int i = 0; i < radius; i++) {
                len = Math.sqrt(area - i * i);
                if(len - (int)len < eps) {
                    count+=4;
                }
            }
            System.out.println(count);
        }
    }
}
