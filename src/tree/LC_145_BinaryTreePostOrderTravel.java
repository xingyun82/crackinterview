package tree;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import common.TreeNode;

/**
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [3,2,1].

 Note: Recursive solution is trivial, could you do it iteratively?
 * Created by xingyun on 15/6/23.
 */
public class LC_145_BinaryTreePostOrderTravel {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            res.add(0, node.val);
            if(node.left != null) {
               stack.push(node.left);
            }
            if(node.right != null) {
                stack.push(node.right);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        LC_145_BinaryTreePostOrderTravel inst = new LC_145_BinaryTreePostOrderTravel();
        List<Integer> res = inst.postorderTraversal(node1);
        for(int i:res) {
            System.out.println(i);
        }
    }
}
