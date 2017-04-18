package exam.toutiao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jikai Zhang on 2017/3/30.
 */
public class Xiaozhao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        if (n == 1) {
            System.out.println(2);
        } else if (n == 2) {
            System.out.println(1);
        } else {

            Arrays.sort(arr);

            int count = 0;
            int i;
            for (i = 0; i < n - 2; i++) {
                if (arr[i + 1] - arr[i] > 10) {
                    count += 2;
                    continue;
                }
                i++;
                if (arr[i + 1] - arr[i] > 10) {
                    count += 1;
                    continue;
                }
                i++;
            }

            if (i < n - 1 && arr[i + 1] - arr[i] <= 10) {
                count += 1;
            } else {
                count += n - i;
            }

            //System.out.println(count);

            int count2 = 0;
            for (i = n - 1; i >= 2; i--) {
                if (arr[i] - arr[i - 1] > 10) {
                    count2 += 2;
                    continue;
                }
                i--;
                if (arr[i] - arr[i - 1] > 10) {
                    count2 += 1;
                    continue;
                }
                i--;
            }

            if(i > 0 && arr[i] - arr[i - 1] <= 10) {
                count2 += 1;
            } else {
                count2 += i + 1;
            }
            //System.out.println(count2);
            count = Math.min(count, count2);
            System.out.println(count);

        }
    }
}

