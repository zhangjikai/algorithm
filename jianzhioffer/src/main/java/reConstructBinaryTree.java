/**
 * Created by Jikai Zhang on 2017/5/21.
 */
public class ReConstructBinaryTree {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0 || pre.length != in.length) {
            return null;
        }


        return traverse(pre, in);
    }

    public TreeNode traverse(int[] pre, int[] in) {

        TreeNode root = new TreeNode(pre[0]);

        int split = search(in, root.val);
        if (split > 0) {
            int[] leftPre = new int[split];
            int[] leftIn = new int[split];
            for (int i = 0; i < split; i++) {
                leftPre[i] = pre[i + 1];
                leftIn[i] = in[i];
            }
            root.left = traverse(leftPre, leftIn);
        }

        if (split < pre.length - 1) {
            int[] rightPre = new int[pre.length - split - 1];
            int[] rightIn = new int[pre.length - split - 1];
            for (int i = split + 1; i < pre.length; i++) {
                rightPre[i - split - 1] = pre[i];
                rightIn[i - split - 1] = in[i];
            }
            root.right = traverse(rightPre, rightIn);
        }
        return root;
    }

    public int search(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
