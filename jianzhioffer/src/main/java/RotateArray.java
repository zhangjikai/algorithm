/**
 * Created by Jikai Zhang on 2017/5/21.
 */
public class RotateArray {

    public int minNumberInRotateArray(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }
        int start = 0;
        int end = array.length - 1;
        int mid;
        int min = array[0];
        while (start <= end) {
            mid = (start + end) / 2;

            if (array[mid] == min) {
                return min;
            }
            if (array[mid] > min) {

                if (array[mid + 1] <= min) {
                    return array[mid + 1];
                } else {
                    start = mid;
                }
            } else {
                if (array[mid - 1] > min) {
                    return array[mid];
                } else {
                    end = mid;
                }


            }
        }
        return array[start];
    }


    public static void main(String[] args) {
        int[] array = new int[]{3,4,5,1,2};
        System.out.println(new RotateArray().minNumberInRotateArray(array));
    }
}
