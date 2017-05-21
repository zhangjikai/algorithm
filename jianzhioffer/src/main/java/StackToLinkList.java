import java.util.Stack;

/**
 * Created by Jikai Zhang on 2017/5/21.
 */
public class StackToLinkList {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();


    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {

        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }


        /*while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int last = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }*/
        return stack2.pop();
    }
}
