package common;

/**
 * Created by xingyun on 15/6/23.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(){}
    public TreeNode(int x) { val = x; }

    public void printTree() {

        System.out.print(val+"[");
        if(left != null) {
            System.out.print("l:" + left.val + " ");
        }
        if(right != null) {
            System.out.print("r:" + right.val + " ");
        }
        System.out.println("]");

        if(left != null) left.printTree();
        if(right != null) right.printTree();

    }
}
