import java.util.Map;

/**
 * Created by Jikai Zhang on 2017/5/21.
 */
public class JumpFloor2 {

    public int JumpFloorII(int target) {
        if (target == 1) {
            return 1;
        }

        if (target == 2) {
            return 2;
        }

        int[] array = new int[target + 1];
        array[1] = 1;
        array[2] = 2;
        for (int i = 3; i <= target; i++) {
            for(int j = 1; j < i; j++) {
                array[i] += array[j];
            }
            array[i] += 1;
            //array[i] = array[i-1] + array[i-2];
        }

        return array[target];
    }

    public static void main(String[] args) {
        System.out.println(new JumpFloor2().JumpFloorII(5));
    }
}
