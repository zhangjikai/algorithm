import com.zhangjikai.sort.InsertSort;
import com.zhangjikai.sort.ShellSort;
import com.zhangjikai.sort.Sort;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangJikai on 2017/2/28.
 */
public class TestSort {


    private List<Integer> randomList;

    @Before
    public void init() {
        int[] arr = new int[]{49, 38, 65, 97, 76, 13, 27, 49};
        arr = new int[]{49, 38, 65, 97, 76, 13, 27, 49, 55, 04};
        randomList = new ArrayList<>();
        for(int i : arr) {
            randomList.add(i);
        }
    }

    @Test
    public void testInsertSort() {
        Sort<Integer> sort = new InsertSort<>();
        List<Integer> result = sort.sort(randomList);
        System.out.println(result);
    }

    @Test
    public void testShellSort() {
        Sort<Integer> sort = new ShellSort<>();
        List<Integer> result = sort.sort(randomList);
        System.out.println(result);
    }
}
