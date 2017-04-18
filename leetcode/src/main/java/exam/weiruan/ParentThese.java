package exam.weiruan;

import java.util.*;

/**
 * Created by Jikai Zhang on 2017/3/31.
 */
public class ParentThese {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Stack stack = new Stack();
        char[] chars = s.toCharArray();
        int count = 0;

        int anothCount = 0;
        for (char c : chars) {
            if (c == '(') {
                stack.push(c);

            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                anothCount++;

            }
        }

        //int size = Math.abs(count);

        char c = 'c';
        int size;
        if (count > 0) {
            size = count;
            c = ')';
        } else {
            size = -count;
            c = '(';
        }
        //System.out.println(size);
        String str;
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            str = s.substring(0, i) + c + s.substring(i);
            //System.out.println(str);
            recusive(size, 1, str, strings, c);

        }
        str = s + c;
        recusive(size, 1, str, strings, c);
        System.out.printf("%d %d\n", size, strings.size());
    }

    public static void recusive(int size, int index, String s, Set<String> strings, char c) {

        if (index >= size) {
            if (isMatch(s)) {
                strings.add(s);

            }
            return;
        }
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            str = s.substring(0, i) + c + s.substring(i);
            recusive(size, index + 1, str, strings, c);
        }
        str = s + c;
        recusive(size, index + 1, str, strings, c);
    }

    public static boolean isMatch(String s) {

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (c == '(') {
                stack.push(c);

            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                stack.pop();


            }
        }
        return stack.size() == 0;
    }

}
