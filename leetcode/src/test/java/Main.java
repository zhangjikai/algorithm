import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            double a = scan.nextInt();
            int b = scan.nextInt();
            double total = 0;
            for (int i = 0; i < b; i++) {
                total += a;
                a = Math.sqrt(a);

            }
            System.out.printf("%.2f\n", total);
        }
    }
}