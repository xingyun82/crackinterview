package tree;


import java.util.*;
import common.*;
/**
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree is symmetric:

 1
 / \
 2   2
 / \ / \
 3  4 4  3
 But the following is not:
 1
 / \
 2   2
 \   \
 3    3
 * Created by xingyun on 15/7/24.
 */
public class LC_101_SymetricTree {

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        //if(root.left != null)
        Stack<TreeNode> leftStack = new Stack<TreeNode>();
        Stack<TreeNode> rightStack = new Stack<TreeNode>();
        if(root.left == null) return root.right == null;
        else if(root.right == null) return false;

        leftStack.push(root.left);
        rightStack.push(root.right);

        while(!leftStack.isEmpty() && !rightStack.isEmpty()) {
            TreeNode leftNode = leftStack.pop();
            TreeNode rightNode = rightStack.pop();
            if(leftNode.val != rightNode.val) return false;
            if(leftNode.left != null) {
                if(rightNode.right == null) return false;
                leftStack.push(leftNode.left);
                rightStack.push(rightNode.right);
            } else {
                if(rightNode.right != null) return false;
            }
            if(leftNode.right != null) {
                if(rightNode.left == null) return false;
                leftStack.push(leftNode.right);
                rightStack.push(rightNode.left);
            } else {
                if(rightNode.left != null) return false;
            }
        }
        if(!leftStack.isEmpty() || !rightStack.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        //node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        LC_101_SymetricTree inst = new LC_101_SymetricTree();
        System.out.println(inst.isSymmetric(node1));

    }


}
