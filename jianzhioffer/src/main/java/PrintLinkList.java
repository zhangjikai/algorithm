import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Jikai Zhang on 2017/5/21.
 */
public class PrintLinkList {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode == null) {
            return new ArrayList<>();
        }

        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

}
