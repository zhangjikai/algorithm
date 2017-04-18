package exam.toutiao;

import java.util.Scanner;

/**
 * Created by Jikai Zhang on 2017/3/30.
 */
public class YiHuo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if((arr[i] ^ arr[j]) > m) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
