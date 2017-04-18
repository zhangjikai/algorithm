package exam.toutiao;

import java.util.Scanner;

/**
 * Created by Jikai Zhang on 2017/3/30.
 */
public class StringShift {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] array = str.toCharArray();
        int count = 1;
        char a = str.charAt(0);
        char b = str.charAt(array.length - 1);
        for (int i = 1; i < str.length(); i++) {

            if (b == str.charAt(i - 1) && a == str.charAt(i)) {
                String tmp = str.substring(i) + str.substring(0, i);
                //System.out.println(tmp);

                if (tmp.equals(str)) {
                    count++;
                }
            }
            /*boolean same = true;
            int k = 0;
            int j = 0;
            for (j = i; j < str.length(); j++, k++) {
                if (array[j] != array[k]) {
                    same = false;
                    break;
                }
            }

            if (same) {
                for (j = 0; j < i; j++, k++) {
                    if (array[j] != array[k]) {
                        same = false;
                    }
                }
            }

            if (same) {
                count++;
            }*/
        }

        System.out.println(count);
    }
}
