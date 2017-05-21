/**
 * Created by Jikai Zhang on 2017/5/21.
 */
public class Fibonacci {


    public int Fibonacci(int n) {
        if(n == 0) {
            return 0;
        }

        if(n == 1) {
            return 1;
        }

        int numOne = 0;
        int numTwo = 1;
        int numN = 0;


        for(int i = 2; i <= n; i++) {
            numN = numOne + numTwo;
            numOne = numTwo;
            numTwo = numN;
        }
        return numN;

    }

    public int Fibonacci2(int n) {
        if(n == 0) {
            return 0;
        }

        if(n == 1) {
            return 1;
        }

        int[] array = new int[n+1];
        array[0] = 0;
        array[1] = 1;
        for(int i = 2; i < array.length; i++) {
            array[i] = array[i-1] + array[i-2];
        }
        return array[n];

    }

    public static void main(String[] args) {
        System.out.println(new Fibonacci().Fibonacci(3));
    }

}
