package exam.toutiao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Jikai Zhang on 2017/3/30.
 */
public class Directory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        /*if (n == 0 || m == 0) {
            System.out.println(0);

        } else {
            String strings[] = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = String.valueOf(i + 1);
            }
            Arrays.sort(strings);
            System.out.println(strings[m-1]);
        }*/
        if (n == 0 || m == 0) {
            System.out.println(0);
        } else {
            Integer arr[] = new Integer[n];
            for (int i = 1; i <= n; i++) {
                arr[i - 1] = i;
            }
            Arrays.sort(arr, new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    String str = o1.toString();
                    String str2 = o2.toString();
                    return str.compareTo(str2);
                }

                @Override
                public boolean equals(Object obj) {
                    return false;
                }
            });

            System.out.println(arr[m-1]);
        }
    }
}
