import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jikai Zhang on 2017/4/10.
 */
public class HeapSort2 {


    static class Heap {
        List<Integer> list = new ArrayList<>();

        public void add(int num) {
            if (list.size() == 0) {
                list.add(num);
                return;
            }


            list.add(num);
            int index = list.size();
            int parentIndex;
            int tmp;
            while (index > 1) {
                parentIndex = index / 2;
                if (list.get(index - 1) >= list.get(parentIndex - 1)) {
                    break;
                } else {
                    tmp = list.get(index - 1);
                    list.set(index - 1, list.get(parentIndex - 1));
                    list.set(parentIndex - 1, tmp);
                }
                index = parentIndex;
            }
        }

        public int delete() {
            if (list.size() == 0) {
                return 0;
            }
            int min = list.get(0);
            list.set(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);
            int index = 1;
            int childIndex = index * 2;
            int tmp;
            while (childIndex - 1 < list.size()) {
                if (childIndex < list.size() && list.get(childIndex - 1) > list.get(childIndex)) {
                    childIndex++;
                }
                if (list.get(index - 1) <= list.get(childIndex - 1)) {
                    break;
                } else {
                    tmp = list.get(index - 1);
                    list.set(index - 1, list.get(childIndex - 1));
                    list.set(childIndex - 1, tmp);
                }
                index = childIndex;
                childIndex *= 2;
            }

            return min;
        }
    }

    public void sort(int[] nums) {
        Heap heap = new Heap();
        for (int i : nums) {
            heap.add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(heap.delete());
        }
    }

    public static void main(String[] args) {
        int nums[] = new int[]{49, 38, 65, 97, 76, 13, 27, 49, 55, 4, 2};
        HeapSort2 sort = new HeapSort2();
        sort.sort(nums);
    }


}
